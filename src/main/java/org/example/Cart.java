package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Cart implements Runnable {
    private final Controller controller;
    private ArrayList<Person> peopleInCart;
    private int cartSize = 6;

    Cart(Controller controller) {
        this.controller = controller;
        peopleInCart = new ArrayList<>();
    }

    public int getCartSize() {
        return cartSize;
    }

    public void rideCart() {
        try {
            System.out.println("All people in cart " + peopleInCart);
            Thread.sleep(1000 + new Random().nextInt(2000));
            System.out.println("Cart arrived");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void freeCart() {
        peopleInCart.clear();
    }

    public void addPeopleInCart() {
        for (int i = 0; i < cartSize; i++) {
            System.out.println("Waiting for next person");
            peopleInCart.add(controller.letInCart());
            System.out.println("Next person entered cart");
        }
    }

    @Override
    public void run() {
        while (true) {
            addPeopleInCart();
            rideCart();
            freeCart();
        }
    }
}
