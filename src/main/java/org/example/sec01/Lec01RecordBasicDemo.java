package org.example.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01RecordBasicDemo {

    private static final Logger log = LoggerFactory.getLogger(Lec01RecordBasicDemo.class);

    record Person(String firstName, String lastName) {

    }


    public static void main(String[] args) {
        var person1 = new Person("Vadim", "Zakirov");
        var person2 = new Person("Vadim", "Zakirov");
        var person3 = new Person("Mariia", "Kataeva");


        log.info("firstName: {}", person1.firstName);
        log.info("lastName: {}", person1.lastName);
        log.info("toString: {}", person1);

        log.info("person1 == person2: {}", person1 == person2);
        log.info("person1 equals person2: {}", person1.equals(person2));
        log.info("person1 equals person3: {}", person1.equals(person3));

        log.info("person1 hashcode: {}", person1.hashCode());
        log.info("person2 hashcode: {}", person2.hashCode());
        log.info("person3 hashcode: {}", person3.hashCode());
    }
}
