package com.github.brice.flashcards_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlashcardsApiApplication {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        SpringApplication.run(FlashcardsApiApplication.class, args);
    }
}