package com.example.universitytask.models.dtos.requests;

import com.example.universitytask.utills.validators.ValidationItems;
import com.example.universitytask.utills.validators.ValidationRules;

public record StudentUpdate(
        String firstName,
        String secondName,
        int age,
        String email,
        String password,
        float score
) {

    public void validate() throws ValidationRules.ValidationException {

        ValidationRules.validate(ValidationItems.FIRST_NAME, firstName);
        ValidationRules.validate(ValidationItems.SECOND_NAME, secondName);
        ValidationRules.validate(ValidationItems.AGE, String.valueOf(age));
        ValidationRules.validate(ValidationItems.EMAIL, email);
        ValidationRules.validate(ValidationItems.PASSWORD, password);
        ValidationRules.validate(ValidationItems.SCORE, String.valueOf(score));


    }


}
