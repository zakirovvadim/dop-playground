package org.example.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

// Non-canonical constructor - a constructor with a different signature than record's components
public class Lec04NonCanonicalConstructor {

    private static final Logger log = LoggerFactory.getLogger(Lec04NonCanonicalConstructor.class);


    record Task(String title, LocalDate date) {
        Task(String title) {
            this(title, LocalDate.now());
        }
    }

    public static void main(String[] args) {
        var task = new Task("Submit report");
        log.info("{}", task);

    }




}
