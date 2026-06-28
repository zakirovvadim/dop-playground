package org.example.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpTimeoutException;

/**
 * Демонстрация record pattern в switch.
 *
 * Идея: можно не только проверить тип самого объекта,
 * но и сразу "распаковать" record и проверить типы его компонентов.
 *
 * Например:
 * case ApiResponse(String data, _) ->
 *
 * означает:
 * - response является ApiResponse;
 * - первый компонент success содержит String;
 * - этот String доступен в переменной data;
 * - второй компонент error сейчас не нужен (_).
 *
 * Record pattern работает только с record, потому что у record
 * явно заданы компоненты и их порядок в объявлении.
 */
public class Lec07RecordPattern {

    private static final Logger log = LoggerFactory.getLogger(Lec07RecordPattern.class);

    record ApiResponse<T>(T success, Throwable error) {

    }
    public static void main(String[] args) {
        patternMatch(new ApiResponse<>("vadim", null));
        patternMatch(new ApiResponse<>(50, null));
        patternMatch(new ApiResponse<>(null, new HttpTimeoutException("unable to reach google.com")));
        patternMatch(new ApiResponse<>(null, null));
    }

    // only record classes can be deconstructed and perform pattern matching on the record components as well
    private static void patternMatch(ApiResponse<?> response) {
        switch (response) {
            case ApiResponse(Integer data, _) -> log.info("int data: {}", data);
            case ApiResponse(String data, _) -> log.info("string data: {}", data);
            case ApiResponse(_, HttpTimeoutException ex) -> log.info("timed out: {}", ex.getMessage());
            case null, default -> log.error("unexpected: {}", response);
        }
    }
}
