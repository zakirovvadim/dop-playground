package org.example.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Lec09RecordInterface {

    private static final Logger log = LoggerFactory.getLogger(Lec09RecordInterface.class);

    record EmailTempalte(String template) implements UnaryOperator<String> {
        @Override
        public String apply(String s) {
            return template.formatted(s);
        }
    }

    public static void main(String[] args) {
        var emailTempalte = new EmailTempalte("Hi %s, Welcome...");
        Stream.of("vadim", "mariia", "albert")
                .map(emailTempalte)
                .forEach(log::info);
    }

}
