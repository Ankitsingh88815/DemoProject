package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@Controller("/home")
public class ViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }
}
