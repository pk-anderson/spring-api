package com.social_network.controller;

import com.social_network.model.User;
import com.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User saveduser = userService.createUser(user);
            return new ResponseEntity<>(saveduser, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    } 
    
    @GetMapping
    public ResponseEntity<String> getMethodName() {
        var hello = "helloworld";
        return ResponseEntity.ok(hello);
    }
    
}
