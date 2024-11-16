package com.github.brice.flashcards_api.config;

import com.github.brice.architecture.UseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.github.brice.flashcards_api.application",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = UseCase.class)
)
public class DomainConfig {
}
