package org.example;

public class Person {
    private String number;

    Person(String num){
        number=num;
    }

    @Override
    public String toString() {
        return "Person{" +
                "number=" + number +
                '}';
    }
}
