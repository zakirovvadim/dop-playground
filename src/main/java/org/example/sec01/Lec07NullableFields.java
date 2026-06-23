package org.example.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.Option;
import java.util.Optional;

/*
Records are data carriers, and their fields can be null.
If you want to prevent null, use a compact constructor to validate the fields
or use Optional to make it explicit
 */
/**
 * Optional-компонент record явно обозначает, что поле может отсутствовать.
 * Для удобства вызывающего кода стоит добавлять конструкторы, принимающие
 * обычное nullable-значение и преобразующие его через Optional.ofNullable(...),
 * а не заставлять каждого клиента создавать Optional вручную.
 *
 * Optional обычно не используют как параметр обычных методов.
 */
public class Lec07NullableFields {

    private static final Logger log = LoggerFactory.getLogger(Lec07NullableFields.class);

    record Person(String name,
                  Optional<String> nickName) {

        Person(String name) {
            this(name, Optional.empty());
        }

        Person(String name, String nickName) {
            this(name, Optional.of(nickName));
        }
    }

    public static void main(String[] args) {
        var vadim = new Person("Vadim");
        var mariia = new Person("Mariia", "marika");

        log.info("{}", vadim);
        log.info("{}", mariia);
    }

}
