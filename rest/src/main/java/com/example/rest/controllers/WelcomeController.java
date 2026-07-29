package com.example.rest.controllers;

import com.example.rest.models.dtos.requests.StudentRequest;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080/welcome/student/mohamed

@RestController
@RequestMapping("welcome")

public class WelcomeController {

@GetMapping("student/{name}")

    public String WelcomeStudentWithPathVarApi(@PathVariable String name){

    return "Welcome "+name+" at this site";

      }

    @GetMapping("student")

    public String WelcomeStudentWithRequestParamApi(@RequestParam(name="employee",required = false) String eng){

        return "Welcome "+eng+" at this site";

    }


//    @GetMapping("student")
//
//    public String WelcomeStudentWithRequestBodyApi(@RequestBody StudentRequest studentRequest){
//
//        return "Welcome "+studentRequest.getEmail()+" at this site";
//
//    }


   }
