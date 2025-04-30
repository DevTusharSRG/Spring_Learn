package com.XmlDemo.XmlDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class App {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Welcome to Spring Framework XML Configuration Example!");
        return "hello";  // Resolves to /WEB-INF/views/hello.jsp
    }
}
