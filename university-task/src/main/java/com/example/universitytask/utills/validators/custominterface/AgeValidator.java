package com.example.universitytask.utills.validators.custominterface;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age,Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value==null){
            return false;
        }
        return value >=18&&value<=25;
    }
}
