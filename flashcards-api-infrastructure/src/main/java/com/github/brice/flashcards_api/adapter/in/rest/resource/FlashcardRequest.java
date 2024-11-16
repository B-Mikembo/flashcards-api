package com.github.brice.flashcards_api.adapter.in.rest.resource;

import com.github.brice.flashcards_api.application.flashcard.Flashcard;

public record FlashcardRequest(String question, String answer) {
    public Flashcard toDomain() {
        return new Flashcard(question, answer);
    }
}
