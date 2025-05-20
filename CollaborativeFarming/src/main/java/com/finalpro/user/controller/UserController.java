package com.finalpro.user.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.finalpro.user.dto.LoginRequestDto;
import com.finalpro.user.dto.LoginResponseDto;
import com.finalpro.user.dto.RequestDto;
import com.finalpro.user.model.User;
import com.finalpro.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
//	public UserController() {
//	    System.out.println("UserController initialized!");
//	}

    
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/")
    public String getAll() {
        //List<User> users = userService.getAllUsers();
        return "this is testing";
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@Valid @RequestBody RequestDto dto) {
        userService.saveUser(dto);
        return ResponseEntity.ok("User Added Successfully");
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginDto) {
        LoginResponseDto response = userService.login(loginDto.getEmail(), loginDto.getPassword(), loginDto.getName());
        return ResponseEntity.ok(response);
    }


    // Error handler for validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
	

//	    @GetMapping("/get")
//	    public ResponseEntity<String> getAllUsers() {
//	        return ResponseEntity.ok("Users retrieved");
//	    }
//
//	    @PostMapping("/register")
//	    public ResponseEntity<String> createUser() {
//	        return ResponseEntity.ok("User created");
//	    }
}
