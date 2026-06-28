package org.example.sec04.lec03;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public record EmailAddress(String value) {

    private static final Predicate<String> IS_INVALID_EMAIL = Pattern.compile("^[a-z]+@[a-z.]+$").asMatchPredicate().negate();

    public EmailAddress {
        if (IS_INVALID_EMAIL.test(value)) {
            throw new IllegalArgumentException("Not a valid email expression");
        }
    }

}
