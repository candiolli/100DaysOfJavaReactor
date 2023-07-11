package com.silascandiolli.app;

import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;

public class Week01 {

    /**
     * This code is creating a Mono in 4 ways.
     * You can have a empty Mono, as a simple type or complex type.
     * You could use Mono to communication between modules or services, ever to receive 0 or 1 result
     * @param args
     */
    public static void main(String[] args) {
        createEmptyMono(Mono.empty());

        creatingMonoWithJust(Mono.just("Not empty"));

        creatingMonoFromComplexType();

        creatingFromCallable();
    }

    private static void creatingMonoFromComplexType()
    {
        Mono<Customer> resultComplexObject = Mono.just(new Customer(UUID.randomUUID(),
                "John", "john@john.com"));
        Optional<Customer> optionalServiceResultObject = resultComplexObject.blockOptional();
        System.out.println(optionalServiceResultObject.orElse(null));
    }

    private static void creatingFromCallable()
    {
        Callable<Integer> legacyTask = () -> {
            // Perform legacy blocking operation
            return 42;
        };

        Mono<Integer> integerMono = Mono.fromCallable(legacyTask);

        print(integerMono.blockOptional());
    }

    private static void creatingMonoWithJust(Mono<String> Not_empty)
    {
        Mono<String> result = Not_empty;
        Optional<String> optionalServiceResult = result.blockOptional();
        print(optionalServiceResult);
    }

    private static void createEmptyMono(Mono<String> empty)
    {
        Mono<String> emptyResult = empty;
        Optional<String> optionalServiceEmptyResult = emptyResult.blockOptional();
        print(optionalServiceEmptyResult);
    }

    private static void print(Optional result) {
        System.out.println(result.orElse("is empty"));
    }
}
