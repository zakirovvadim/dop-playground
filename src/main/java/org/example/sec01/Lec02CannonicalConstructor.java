package org.example.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec02CannonicalConstructor {

    private static final Logger log = LoggerFactory.getLogger(Lec02CannonicalConstructor.class);

    record Person(String firstName, String lastName) {
        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName.toUpperCase();
        }
    }
    

    public static void main(String[] args) {
        var person = new Person("Vadim", "Zakirov");

        log.info("{}", person);
    }
}
