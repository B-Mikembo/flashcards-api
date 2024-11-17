package com.github.brice.flashcards_api.adapter.in.rest.resource;

import com.github.brice.flashcards_api.application.flashcard.Flashcard;

import java.util.UUID;

public record FlashcardResponse(UUID id, String question, String answer) {
    public static FlashcardResponse fromDomain(Flashcard flashcard) {
        return new FlashcardResponse(flashcard.id(), flashcard.question(), flashcard.answer());
    }
}
