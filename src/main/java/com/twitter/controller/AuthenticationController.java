package com.twitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "login";
    }


    @PostMapping("/register")
    public String registerPost(){
        return "login";
    }
    @PostMapping("/login")
    public String loginPost(){
        return "home";
    }






}
