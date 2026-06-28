package org.example.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec04PatternLabelDominance {

    private static final Logger log = LoggerFactory.getLogger(Lec04PatternLabelDominance.class);

    public static void main(String[] args) {
        patternMatch(5); // по умолчанию интеджер
        patternMatch(5.0);
        patternMatch(5.0f);
        patternMatch(6_000_000_000_000L);
    }

    private static void patternMatch(Object object) {
        switch (object) {
            case Double d -> log.info("double {}", d);
            case Integer i -> log.info("int {}", i);
            case Number n -> log.info("number {}", n); // более широкий тип должен быть ниже более узкого
            case null, default ->  log.info("null/default {}", object);
        }
    }

}
