package org.example.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Lec03CompactConstructor {

    private static final Logger log = LoggerFactory.getLogger(Lec03CompactConstructor.class);

    record Person(String firstName, String lastName) {
        Person {
            Objects.requireNonNull(lastName, "lastName must not be null"); // компактный конструктор подходит для логики
            lastName = lastName.toUpperCase();
        }
    }
    

    public static void main(String[] args) {
        var person = new Person("Vadim", "Zakirov");

        log.info("{}", person);
    }
}
