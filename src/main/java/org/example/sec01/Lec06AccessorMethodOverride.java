package org.example.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/*
Record acessor methods can be ovveridden without changing their method signature
 */
public class Lec06AccessorMethodOverride {
    private static final Logger log = LoggerFactory.getLogger(Lec06AccessorMethodOverride.class);

    record Person(String firstname, String lastname) {

        public Optional<String> firstNameOptional() { // мы не можем переопределить стандартные методы, например, получения поля
            // но можем создать свой метод, который, к примеру, буде возвращать опшнл
            return Optional.ofNullable(firstname);
        }
    }

    public static void main(String[] args) {
        var person = new Person("vadim", "zakirov");
        log.info("{}", person);
    }
}
