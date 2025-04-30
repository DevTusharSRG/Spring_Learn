package com.tushar.example;

import org.springframework.stereotype.Component;

@Component  // tells Spring to create and manage this as a bean
public class HelloService {
    public void sayHello() {
        System.out.println("OK, Tushar! Welcome to Spring Core.");
    }
}