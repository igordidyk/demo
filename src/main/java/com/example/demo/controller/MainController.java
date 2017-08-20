package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    private UserServise servise;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("admin", principal);
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/register")
    public String registrtation() {
        return "/register";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name,
                       @RequestParam("email") String email,
                       @RequestParam("username") String username,
                       @RequestParam("password") String password) {
        User user = new User(name, email, username, password);
        System.out.println(user);
        servise.save(user);
        return "redirect:/register";
//        return "index";
    }

}


