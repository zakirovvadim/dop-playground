package org.example.sec04.lec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailService {
    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    /*
    problem this way:
    1. what if the caller switches parameters?
    2. is it a valid email?
    3. is the message valid?
     */
    public static void send(String emailAddress, String message) {
        log.info("sending {} to {}", message, emailAddress);
    }

    /*
    таким способом мы можем решить проблемы валидности содержимого (прописав проверки внутри компакт конструктора), определенности аргументов
     */
    public static void send(EmailAddress emailAddress, Message message) {
        log.info("sending {} to {}", message.value(), emailAddress.value());
    }
}
