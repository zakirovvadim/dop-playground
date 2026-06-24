package org.example.sec02.lec02;

import org.example.sec02.lec01.CashRewards;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record CreditCard(String number) implements Payment {

    private static final Logger log = LoggerFactory.getLogger(CreditCard.class);


    @Override
    public void process(int amount) {
        log.info("processing amount {} using creditcard {}", amount, this.number);
    }
}
