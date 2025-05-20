package com.tushar.beanfile;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SuppressWarnings("deprecation")
public class App {
    public static void main(String[] args) {
        System.out.println("This is Tushar with Constructor + Setter DI");
        
        ClassPathResource resource = new ClassPathResource("beans.xml");
        BeanFactory context = new XmlBeanFactory(resource);
		
        
        //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloService hello = (HelloService)context.getBean("helloService");
        hello.sayHello();
        Student student = (Student) context.getBean("student");
        student.displayInfo();
    }
}
