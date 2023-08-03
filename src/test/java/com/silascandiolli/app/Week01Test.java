package com.silascandiolli.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class Week01Test
{

    @Test
    public void hello_world_mono() {
        // Create a Mono from String, but it could be a call to another function or reactive web service
        Mono<String> serviceResult = Mono.just("Hello World!");

        StepVerifier
                .create(serviceResult)
                .expectNext("Hello World!")
                .expectComplete()
                .verify();
    }

    @Test
    public void hello_world_flux() {
        // Create a Flux from String, but it could be a call to another function or reactive web service
        Flux<String> serviceResult = Flux.just("Hello World 1", "Hello World 2");

        StepVerifier
                .create(serviceResult)
                .expectNext("Hello World 1")
                .expectNext("Hello World 2")
                .expectComplete()
                .verify();
    }
}