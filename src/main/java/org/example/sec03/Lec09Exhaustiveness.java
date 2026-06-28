package org.example.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec09Exhaustiveness {

    private static final Logger log = LoggerFactory.getLogger(Lec09Exhaustiveness.class);

    enum Country {
        US,
        UK,
        CA,
        RU
    }

    public static void main(String[] args) {
        log.info("{}", getTax(Country.US, 100));
        log.info("{}", getTax(Country.UK, 100));
        log.info("{}", getTax(Country.CA, 100));
        log.info("{}", getTax(Country.RU, 100));
    }

    private static double getTax(Country country, Integer price) { // если использовать енам, и не указать все кейсы
        // по значениям енама, то будет ругаться на то, что не указал исчерпывающий список енама в кейсах
        var taxRate = switch (country) {
            case US -> 0.05;
            case UK, RU -> 0.06;
            case CA -> 0.08;
        };
        log.info("country: {}, taxRate: {}", country, taxRate);
        return taxRate * price;
    }
}
