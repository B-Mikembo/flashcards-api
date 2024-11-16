package com.github.brice.flashcards_api.application.out.stub;

import com.github.brice.flashcards_api.application.flashcard.Flashcard;
import com.github.brice.flashcards_api.application.out.Flashcards;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryFlashcards implements Flashcards {
    private Map<UUID, Flashcard> entities = new HashMap<>();

    @Override
    public Flashcard save(Flashcard flashcard) {
        entities.put(flashcard.id(), flashcard);
        return flashcard;
    }
}
