package com.github.brice.flashcards_api.application.out;

import com.github.brice.flashcards_api.application.flashcard.Flashcard;

public interface Flashcards {
    Flashcard save(Flashcard flashcard);
}
