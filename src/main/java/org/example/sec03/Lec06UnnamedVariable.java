package org.example.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec06UnnamedVariable {

    private static final Logger log = LoggerFactory.getLogger(Lec06UnnamedVariable.class);

    public static void main(String[] args) {
        patternMatch(5); // по умолчанию интеджер
        patternMatch(5.0);
        patternMatch(-5);
        patternMatch(5.0f);
        patternMatch(6_000_000_000_000L);
    }

    private static void patternMatch(Object object) {
        switch (object) {
            case Double _ -> log.info("double"); // если нам не нужен объект, можем прописать просто подчеркивание, вместо ignore
            case Integer _ -> log.info("int");
            case null, default ->  log.info("null/default {}", object);
        }
    }

}
