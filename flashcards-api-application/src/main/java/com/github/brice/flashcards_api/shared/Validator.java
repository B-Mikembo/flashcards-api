package com.github.brice.flashcards_api.shared;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public record Validator<V>(V value, Error error) {
    public V orElseThrow() throws IllegalStateException {
        if (error == null) {
            return value;
        }
        var exception = new IllegalStateException();
        Stream.iterate(error, Objects::nonNull, Error::next).map(Error::exception).forEach(exception::addSuppressed);
        throw exception;
    }

    public <U> Validator<V> check(Function<? super V, ? extends U> projection, Predicate<? super U> validation, String message) {
        return check(projection.andThen(validation::test)::apply, message);
    }

    private Validator<V> check(Predicate<? super V> validation, String message) {
        if (!validation.test(value)) {
            return new Validator<>(value, new Error(new IllegalArgumentException(message), error));
        }
        return this;
    }

    private record Error(IllegalArgumentException exception, Error next) {
    }

}
