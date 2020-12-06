package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Cart cart = new Cart(controller);
        Turnstile turnstile1 = new Turnstile(controller,"a",2);
        Turnstile turnstile2 = new Turnstile(controller,"b",6);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(turnstile1);
        executorService.submit(turnstile2);
        executorService.submit(cart);
    }
}
