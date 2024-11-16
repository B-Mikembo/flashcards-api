package com.github.brice.flashcards_api.application.in;

import com.github.brice.flashcards_api.application.flashcard.Flashcard;

public interface ManagingFlashcards {
    Flashcard createFlashcard(Flashcard flashcard);
}
