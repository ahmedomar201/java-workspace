package com.example.universitytask.controllers;


import com.example.universitytask.models.dtos.requests.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("university")

public class LoginController {

    @PostMapping("login")
    public String login(@RequestBody LoginRequest loginRequest){

        return "username: "+loginRequest.getUserName()+"\npassword: "+loginRequest.getPassword();
    }



}
