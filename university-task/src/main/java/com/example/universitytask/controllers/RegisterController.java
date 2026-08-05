package com.example.universitytask.controllers;


import com.example.universitytask.models.dtos.requests.StudentRegister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("university")

public class RegisterController {

    @PostMapping("Register")
    public String login(@RequestBody StudentRegister studentRegister){

        return "fistName: "+ studentRegister.getFirstName()+"\nlastName: "+ studentRegister.getLastName()+
                "\nusername: "+ studentRegister.getUserName()+"\nemail: "+ studentRegister.getEmail()+"\npassword: "+ studentRegister.getPassword();

    }

}
