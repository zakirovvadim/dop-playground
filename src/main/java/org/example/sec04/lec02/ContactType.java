package org.example.sec04.lec02;

public sealed interface ContactType {
    record Email(String address) implements ContactType{

    }

    record Phone(String countryCode, String number) implements ContactType {

    }


}
