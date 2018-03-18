package com.yocollection.core;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GameValidator implements Validator {
    @Override
    public boolean supports(Class clazz) {
        return Game.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Game game = (Game) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty");
    }
}
