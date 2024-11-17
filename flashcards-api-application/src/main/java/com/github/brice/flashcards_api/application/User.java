package com.github.brice.flashcards_api.application;

import com.github.brice.architecture.UseCase;
import com.github.brice.flashcards_api.application.flashcard.Flashcard;
import com.github.brice.flashcards_api.application.in.ManagingFlashcards;
import com.github.brice.flashcards_api.application.out.Flashcards;
import com.github.brice.flashcards_api.shared.Validator;

import java.util.Objects;

@UseCase
public class User implements ManagingFlashcards {
    private final Flashcards flashcards;

    public User(Flashcards flashcards) {
        this.flashcards = flashcards;
    }

    @Override
    public Flashcard createFlashcard(Flashcard flashcard) {
        return flashcards.save(validateFlashcard(flashcard));
    }

    private Flashcard validateFlashcard(Flashcard flashcard) {
        return new Validator<>(flashcard, null)
                .check(Flashcard::question, Objects::nonNull, "You cannot create flashcard without question")
                .check(Flashcard::answer, Objects::nonNull, "You cannot create flashcard without answer")
                .orElseThrow();
    }
}
