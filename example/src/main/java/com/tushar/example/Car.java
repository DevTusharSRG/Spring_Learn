package com.tushar.example;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model = "Toyota";
    
    public String getModel() {
        return model;
    }
}
