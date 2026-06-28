package org.example.sec04.lec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class LoginVerificationService {

    private static final Logger log = LoggerFactory.getLogger(LoginVerificationService.class);

    public static void sendVerification(User user) {
        var code = ThreadLocalRandom.current().nextInt(1000, 10000);

        switch (user.contact()) {
            case ContactType.Phone phone -> phoneVerification(code, user.name(), phone);
            case ContactType.Email email -> emailVerification(code, user.name(), email);
        }
    }

    private static void emailVerification(int code, String name, ContactType.Email email) {
        log.info("sending the code {} to {} via email {}", code, email, email.address());
    }

    private static void  phoneVerification(int code, String name, ContactType.Phone phone) {
        log.info("sending the code {} to {} via phone {}", phone.countryCode(), phone, phone.number());
    }
}
