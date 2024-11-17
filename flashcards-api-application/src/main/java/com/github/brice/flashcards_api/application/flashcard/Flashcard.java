package com.github.brice.flashcards_api.application.flashcard;

import java.util.UUID;

public record Flashcard(
        UUID id,
        String question,
        String answer
) {
    public Flashcard(String question, String answer) {
        this(UUID.randomUUID(), question, answer);
    }
}
