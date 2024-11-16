package com.github.brice.flashcards_api.application;

import com.github.brice.flashcards_api.application.flashcard.Flashcard;
import com.github.brice.flashcards_api.application.in.ManagingFlashcards;
import com.github.brice.flashcards_api.application.out.stub.InMemoryFlashcards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private ManagingFlashcards user;

    @BeforeEach
    void setUp() {
        var flashcards = new InMemoryFlashcards();
        user = new User(flashcards);
    }

    @Nested
    class CreateFlashcardTest {
        @Test
        void userCanCreateFlashcard() {
            var flashcardToCreate = new Flashcard("question", "answer");

            var flashcard = user.createFlashcard(flashcardToCreate);

            assertEquals(flashcardToCreate, flashcard);
        }

        @Test
        void userCannotCreateFlashcardWithoutQuestion() {
            var flashcardToCreate = new Flashcard(null, "answer");
            var exception = assertThrows(IllegalStateException.class, () -> user.createFlashcard(flashcardToCreate));
            assertTrue(Arrays.stream(exception.getSuppressed())
                    .anyMatch(throwable -> "You cannot create flashcard without question".equals(throwable.getMessage())));
        }

        @Test
        void userCannotCreateFlashcardWithoutAnswer() {
            var flashcardToCreate = new Flashcard("question", null);
            var exception = assertThrows(IllegalStateException.class, () -> user.createFlashcard(flashcardToCreate));
            assertTrue(Arrays.stream(exception.getSuppressed())
                    .anyMatch(throwable -> "You cannot create flashcard without answer".equals(throwable.getMessage())));
        }

        @Test
        void userCannotCreateFlashcardWithoutQuestionAndAnswer() {
            var flashcardToCreate = new Flashcard(null, null);
            var exception = assertThrows(IllegalStateException.class, () -> user.createFlashcard(flashcardToCreate));
            assertNotNull(exception);
            assertNotNull(exception.getSuppressed());
            assertTrue(Arrays.stream(exception.getSuppressed())
                    .anyMatch(throwable -> "You cannot create flashcard without question".equals(throwable.getMessage())));
            assertTrue(Arrays.stream(exception.getSuppressed())
                    .anyMatch(throwable -> "You cannot create flashcard without answer".equals(throwable.getMessage())));
        }
    }
}