package org.example.sec02.lec02;

public class Demo {

    public static void main(String[] args) {
        processPayment(new CreditCard("123-456-789"));
        processPayment(new Paypal("Aappolon17@gmail.com"));
    }

    private static void processPayment(Payment payment) {
        payment.process(100);
    }
}
