package de.hsba.bi.projectWork.user.annotations;

import de.hsba.bi.projectWork.web.user.RegisterUserForm;
import de.hsba.bi.projectWork.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UserAlreadyExistValidator implements ConstraintValidator<UserAlreadyExist, Object> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(UserAlreadyExist constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        RegisterUserForm user = (RegisterUserForm) obj;
        return !userService.usernameExists(user.getName());
    }

}