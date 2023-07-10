package com.silascandiolli.app;

import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

public class Day001 {

    /**
     * This code is creating a Mono in 3 ways.
     * You can have a empty Mono, as a simple type or complex type.
     * You could use Mono to communication between modules or services, ever to receive 0 or 1 result
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Mono<String> emptyResult = Mono.empty();
        Optional<String> optionalServiceEmptyResult = emptyResult.blockOptional();
        print(optionalServiceEmptyResult);

        Mono<String> result = Mono.just("Not empty");
        Optional<String> optionalServiceResult = result.blockOptional();
        print(optionalServiceResult);

        Mono<Customer> resultComplexObject = Mono.just(new Customer(UUID.randomUUID(),
                "John", "john@john.com"));
        Optional<Customer> optionalServiceResultObject = resultComplexObject.blockOptional();
        System.out.println(optionalServiceResultObject.orElse(null));
    }

    private static void print(Optional<String> result) {
        System.out.println(result.orElse("is empty"));
    }
}
