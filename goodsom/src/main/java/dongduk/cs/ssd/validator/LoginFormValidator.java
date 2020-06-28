package dongduk.cs.ssd.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import dongduk.cs.ssd.controller.user.UserForm;
import dongduk.cs.ssd.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author Yejin Lee  |  kimdahyee
 * @since 2020.05.07  |  2020.06.12
 */

@Component
public class LoginFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object obj, Errors errors) {
		UserForm userForm = (UserForm)obj; 
		User user = userForm.getUser();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.email", "EMAIL_REQUIRED", "Email is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.userName", "USER_NAME_REQUIRED", "User name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.nickname", "NICKNAME_REQUIRED", "Nickname is required.");
		
		if (userForm.isNewUser()) {
//			user.setStatus("OK");
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.userName", "USER_ID_REQUIRED", "User ID is required.");
			if (user.getPassword() == null || user.getPassword().length() < 1 || !user.getPassword().equals(userForm.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH",
					 "Passwords did not match or were not provided. Matching passwords are required.");
			}
		}
		else if (user.getPassword() != null && user.getPassword().length() > 0) {
			if (!user.getPassword().equals(userForm.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH", "Passwords did not match. Matching passwords are required.");
			}
		}
	}
}