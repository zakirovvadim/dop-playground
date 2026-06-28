package org.example.sec04.lec02;

public class Demo {

    public static void main(String[] args) {
        var vadim = new User("vadim", new ContactType.Phone("+7", "9514499288"));
        var mariia = new User("mariia", new ContactType.Email("mariia@gmail.com"));

        LoginVerificationService.sendVerification(vadim);
        LoginVerificationService.sendVerification(mariia);
    }
}
