package com.example.rest.controllers;

import com.example.rest.models.dtos.requests.StudentRequest;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080/welcome/student/mohamed

@RestController
@RequestMapping("welcome")

public class WelcomeController {

@GetMapping("student/PathVariable/{name}")

    public String WelcomeStudentWithPathVarApi(@PathVariable String name){

    return "Welcome "+name+" at this site";

      }

    @GetMapping("student/requestParm")

    public String WelcomeStudentWithRequestParamApi(@RequestParam(name="employee",required = false) String eng){

        return "Welcome "+eng+" at this site";

    }


    @PostMapping("student/requestBody")

    public String WelcomeStudentWithRequestBodyApi(@RequestBody StudentRequest studentRequest){

        return "Welcome "+studentRequest.getName()+  " at this site\n"+
                "age: "+studentRequest.getAge()+
                "\nEmail: "+studentRequest.getEmail()+
                "\nid: "+studentRequest.getId()
                ;

    }


   }
