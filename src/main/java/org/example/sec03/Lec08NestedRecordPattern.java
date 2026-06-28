package org.example.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpTimeoutException;


public class Lec08NestedRecordPattern {

    private static final Logger log = LoggerFactory.getLogger(Lec08NestedRecordPattern.class);

    record Product(String name, int price) {

    }

    record User(String name, String email) {

    }
    record ApiResponse<T>(T success, Throwable error) {

    }
    public static void main(String[] args) {
        patternMatch(new ApiResponse<>("vadim", null));
        patternMatch(new ApiResponse<>(new Product("tv", 100), null));
        patternMatch(new ApiResponse<>(new User("vadim", "appolon17@gmail.com"), null));
        patternMatch(new ApiResponse<>(50, null));
        patternMatch(new ApiResponse<>(null, new HttpTimeoutException("unable to reach google.com")));
        patternMatch(new ApiResponse<>(null, null));
    }

    // only record classes can be deconstructed and perform pattern matching on the record components as well
    private static void patternMatch(ApiResponse<?> response) {
        switch (response) {
            case ApiResponse(Product(var name, _), _) -> log.info("product name: {}", name);
//            case ApiResponse(User user, _) -> log.info("user email: {}", user.email); // можно не делать декнструкцию, например, если много полей у рекорда
            case ApiResponse(User(_, var email), _) -> log.info("user email: {}", email);
            case ApiResponse(String data, _) -> log.info("string data: {}", data);
            case ApiResponse(_, HttpTimeoutException ex) -> log.info("timed out: {}", ex.getMessage());
            case null, default -> log.error("unexpected: {}", response);
        }
    }
}
