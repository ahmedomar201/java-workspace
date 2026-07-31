package com.example.universitytask.controllers;

import com.example.universitytask.models.dtos.requests.RegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("university")
public class LogoutController {

    @PostMapping("logout")
    public String login(@RequestBody RegisterRequest registerRequest){

        return "fistName: "+registerRequest.getFirstName()+"\nlastName: "+registerRequest.getLastName()+
                "\nusername: "+registerRequest.getUserName()+"\nemail: "+registerRequest.getEmail()+"\npassword: "+registerRequest.getPassword();

    }



}






