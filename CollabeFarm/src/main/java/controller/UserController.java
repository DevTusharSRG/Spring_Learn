package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
    	userService.register(user);// Your registration logic
        return ResponseEntity.ok("User registered successfully");
    }
    
    @GetMapping("/get")
    public String getUser() {
        //userDAO.getUser();  // Call the method in the DAO that prints the message
        return "User fetched successfully! Check the console for logs.";
    }
}

