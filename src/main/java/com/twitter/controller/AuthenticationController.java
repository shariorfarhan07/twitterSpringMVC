package com.twitter.controller;

import com.twitter.dto.CredentialDto;
import com.twitter.dto.RegisterDto;
import com.twitter.service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import  com.twitter.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@Log
@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private AuthenticationService authenticationService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,Model model){
        System.out.println("logging out as "+session.getAttribute("username"));
        if (session.getAttribute("username") == null){
            model.addAttribute("warning","Please login first to use logout");
        }else {
            session.invalidate();
            model.addAttribute("success","You have been logged out successfully");
        }
        return "login";
    }


    @PostMapping("/register")
    public String registerPost(@ModelAttribute("User") RegisterDto regiteruser, Model model){
        User user=regiteruser.toUser();
        log.info(user.toString());
        if (!user.validPayload()){
            model.addAttribute("error","Please provide valid payload!!!");
            log.info("invalid payload");
            return "register";
        }
        if (authenticationService.duplicate(user)){
            log.info("duplicate user found in the database");
            model.addAttribute("error","User already exist in our database.");;
            return "register";
        }
        authenticationService.create(user);
        model.addAttribute("success","User has been created please login!");
        return "login";
    }
    @PostMapping("/login")
    public String loginPost(@ModelAttribute("CredentialDto") CredentialDto credential, Model model, HttpSession session){
        log.info(credential.toString());
        if (!credential.valid()){
            model.addAttribute("error","Please provide valid user name and password!");
        }
        if (authenticationService.isValidCredential(credential)){
           return authenticationService.createSession(credential,session);
        }else {
            model.addAttribute("error","The user name and password didn't matches with the one in our database");
        }
        return "login";
    }






}
