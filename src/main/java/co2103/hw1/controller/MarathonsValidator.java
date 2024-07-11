package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Marathon;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MarathonsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Marathon.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Marathon a = (Marathon) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "", "Id needed");
        for (Marathon ex : Hw1Application.marathons) {
            if (a.getId() == ex.getId()) {
                errors.rejectValue("id", "", "ID already in use.");
                break;
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "", "Your marathon needs a location!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "month", "", "Your marathon needs a month!");
    }
}
