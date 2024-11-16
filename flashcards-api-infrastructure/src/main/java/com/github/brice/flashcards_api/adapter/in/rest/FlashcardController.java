package com.github.brice.flashcards_api.adapter.in.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform/api/flashcards")
public class FlashcardController {
    @GetMapping
    public String test() {
        return "Hello";
    }
}
