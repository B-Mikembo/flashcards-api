package com.github.brice.flashcards_api.adapter.out.persistence;

import com.github.brice.flashcards_api.application.flashcard.Flashcard;
import com.github.brice.flashcards_api.application.out.Flashcards;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class FlashcardsInMemoryAdapter implements Flashcards {
    private Map<UUID, Flashcard> entities = new HashMap<>();

    @Override
    public Flashcard save(Flashcard flashcard) {
        entities.put(flashcard.id(), flashcard);
        return flashcard;
    }
}
