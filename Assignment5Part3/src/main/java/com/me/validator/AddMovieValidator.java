package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.Movie;
import com.me.pojo.User;

public class AddMovieValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(User.class);
	}

	public void validate(Object obj, Errors errors) {
		Movie movie = (Movie) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.title", "Title Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "error.invalid.actor", "Actor Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "error.invalid.actress", "Actress Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "error.invalid.genre", "Genre Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "error.invalid.year",
				"Year Required");
		
		
	}
}
