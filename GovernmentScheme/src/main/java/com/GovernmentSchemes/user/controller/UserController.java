package com.GovernmentSchemes.user.controller;

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

import com.GovernmentSchemes.GovernmentSchemeReport.dto.UserRequestDto;
import com.GovernmentSchemes.user.dto.RequestDto;
import com.GovernmentSchemes.user.dto.UserResponseDto;
import com.GovernmentSchemes.user.model.User;
import com.GovernmentSchemes.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
//	public UserController() {
//	    System.out.println("UserController initialized!");
//	}

    
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers();
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
    

    // READ - Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable int id) {
        UserResponseDto user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE - Update user
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody UserRequestDto dto) {
        boolean updated = userService.updateUser(id, dto);
        if (updated) {
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
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
