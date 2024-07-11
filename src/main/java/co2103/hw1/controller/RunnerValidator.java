package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Marathon;
import co2103.hw1.domain.Runner;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class RunnerValidator implements Validator {


        @Override
        public boolean supports(Class<?> clazz) {
            return Runner.class.equals(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            List<String> categorylist = new ArrayList<>();
            categorylist.add("Professional");
            categorylist.add("Amateur");
            categorylist.add("Under 18s");

            Runner a = (Runner) target;

            if (!categorylist.contains(a.getCategory())) {
                errors.rejectValue("category", "", "Must contain either Professional, Amateur, or Under 18s");
            }

            if (a.getNumber() < 1){
                errors.rejectValue("number", "", "Must be between (including) 1 and 500.");
            }
            if (a.getNumber() > 500){
                errors.rejectValue("number", "", "Must be between (including) 1 and 500.");
            }


            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Your runner needs a name!");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationality", "", "Your runner needs a nationality!");
        }

    }

