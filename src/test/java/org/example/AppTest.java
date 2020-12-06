package org.example;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
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
