package org.example;

import java.util.Random;

public class Turnstile implements Runnable {

    private final Controller controller;
    private String numOfTurnstile;
    private int number = 0;
    private int maxNumberOfPeople;

    public Turnstile(Controller controller, String turnstile, int maxNumber) {
        this.controller = controller;
        numOfTurnstile = turnstile;
        maxNumberOfPeople = maxNumber;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < maxNumberOfPeople; i++) {
            try {
                System.out.println("Turnstile is waiting");
                Thread.sleep(random.nextInt(1000));
                System.out.println("Turnstile not waiting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String fullNumber = number + numOfTurnstile;
            Person person = new Person(fullNumber);
            number++;
            System.out.println("New person entered turnstile");
            controller.addIntoQueue(person);
            System.out.println("New person entered the queue");

        }
    }
}
