package com.example.universitytask.controllers;


import com.example.universitytask.models.dtos.requests.LoginRequest;
import com.example.universitytask.models.dtos.requests.RegisterRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("university")

public class RegisterController {

    @PostMapping("Register")
    public String login(@RequestBody RegisterRequest registerRequest){

        return "fistName: "+registerRequest.getFirstName()+"\nlastName: "+registerRequest.getLastName()+
                "\nusername: "+registerRequest.getUserName()+"\nemail: "+registerRequest.getEmail()+"\npassword: "+registerRequest.getPassword();

    }

}
