package com.github.brice.flashcards_api.adapter.in.rest;

import com.github.brice.flashcards_api.adapter.in.rest.re.FlashcardResponse;
import com.github.brice.flashcards_api.adapter.in.rest.resource.FlashcardRequest;
import com.github.brice.flashcards_api.application.in.ManagingFlashcards;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/platform/api/flashcards")
public class FlashcardController {

    private final ManagingFlashcards user;

    public FlashcardController(ManagingFlashcards user) {
        this.user = user;
    }

    @PostMapping
    public ResponseEntity<FlashcardResponse> createFlashcard(@RequestBody FlashcardRequest request, UriComponentsBuilder uriComponentsBuilder) {
        var flashcard = user.createFlashcard(request.toDomain());
        var location = uriComponentsBuilder.path("/platform/api/flashcards/{id}")
                .buildAndExpand(flashcard.id())
                .toUri();
        return ResponseEntity.created(location).body(FlashcardResponse.fromDomain(flashcard));
    }
}
