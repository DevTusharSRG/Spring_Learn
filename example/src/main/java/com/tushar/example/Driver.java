package com.tushar.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Driver {
    private Car car;

    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    public void drive() {
        System.out.println("Driving a " + car.getModel());
    }
}