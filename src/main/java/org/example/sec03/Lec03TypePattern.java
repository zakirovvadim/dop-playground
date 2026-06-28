package org.example.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/*
В новом паттерн матчинге можно не использовать инстанс оф формулирвоку, а сразу делать это в кейсах и получать конвертированный результат
 */
public class Lec03TypePattern {

    private static final Logger log = LoggerFactory.getLogger(Lec03TypePattern.class);

    public static void main(String[] args) {
        log.info("{}", isEmpty(null));
        log.info("{}", isEmpty(""));
        log.info("{}", isEmpty("vadim"));
        log.info("{}", isEmpty(List.of()));
        log.info("{}", isEmpty(List.of(1)));
        log.info("{}", isEmpty(java.util.Map.of()));
        log.info("{}", isEmpty(java.util.Map.of(1,2)));
        log.info("{}", isEmpty(new Object[]{}));
        log.info("{}", isEmpty(new Object[]{1, 2}));
    }

    // Можно не использовать инстанс оф в каждом кейсе
    private static boolean isEmpty(Object object) {
        log.info("received: {}", object);
        return switch (object) {
            case null -> true;
            case String s -> s.isEmpty();
            case Collection<?> collection -> collection.isEmpty();
            case Map<?,?> map -> map.isEmpty();
            case Object[] array -> array.length == 0;
            default -> false;
        };
    }
}
