package org.example.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
В кейс можно ставить налл, или нал с дефолтом одновременно, а также в случае многостраничного кейса использовать спец слово
для возврата результата это yield
 */
public class Lec02SwitchExpression {

    private static final Logger log = LoggerFactory.getLogger(Lec02SwitchExpression.class);

    public static void main(String[] args) {
        log.info("{}", getTax("US", 100));
        log.info("{}", getTax("UK", 100));
        log.info("{}", getTax("CA", 100));
    }

    private static double getTax(String country, Integer price) {
        var taxRate = switch (country) {
            case "US" -> 0.05;
            case "UK", "RU" -> 0.06;
            case null -> throw new IllegalArgumentException("country cannot be null");
//            default -> 0.08;
//            case null, default -> 0.08;
            default -> {
                log.info("default tax rate is used for country: {}", country);
                yield 0.08;
            }
        };
        log.info("country: {}, taxRate: {}", country, taxRate);
        return taxRate * price;
    }
}
