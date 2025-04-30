package com.tushar.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // tells Spring this class is configuration (no XML needed)
@ComponentScan(basePackages = "com.tushar.example")  // scans the package for @Component classes
public class App {
    public static void main(String[] args) {
    	
    	System.out.println("This is Tushar");
        // Loads the context and all beans
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        // Fetch the HelloService bean
        HelloService service = context.getBean(HelloService.class);
        service.sayHello();
        // Singleton scope: Same instance every time
        Car car1 = context.getBean(Car.class);
        Car car2 = context.getBean(Car.class);
        System.out.println("Are both car beans the same? " + (car1 == car2));

        // Prototype scope: Different instance every time
        Driver driver1 = context.getBean(Driver.class);
        Driver driver2 = context.getBean(Driver.class);
        System.out.println("Are both driver beans the same? " + (driver1 == driver2));
    }
}
