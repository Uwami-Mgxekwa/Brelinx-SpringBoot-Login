package com.brelin.loginPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }
    
    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }
}
