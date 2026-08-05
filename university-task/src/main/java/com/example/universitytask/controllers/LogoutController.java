package com.example.universitytask.controllers;

import com.example.universitytask.models.dtos.requests.StudentRegister;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("university")
public class LogoutController {

    @PostMapping("logout")
    public String login(@RequestBody StudentRegister studentRegister){

        return "fistName: "+ studentRegister.getFirstName()+"\nlastName: "+ studentRegister.getLastName()+
                "\nusername: "+ studentRegister.getUserName()+"\nemail: "+ studentRegister.getEmail()+"\npassword: "+ studentRegister.getPassword();

    }



}






