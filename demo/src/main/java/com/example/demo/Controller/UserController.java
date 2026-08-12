package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping
    public User createUser(@Valid @RequestBody User user){

        return userService.saveUser(user);
    }


    @GetMapping
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){

        return userService.getUserById(id);
    }


    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable int id,
            @RequestBody User user){

        return userService.updateUser(id, user);
    }

    @PatchMapping("/{id}")
    public User patchUser(
        @PathVariable int id,
        @RequestBody User user) {

        return userService.patchUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){

        userService.deleteUser(id);

        return "User deleted successfully";
    }
}