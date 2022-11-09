package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.dto.exception.UserValidateException;
import liga.medical.personservice.dto.security.UserRegisterBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidate {

    @Autowired
    private UserService userService;

    public void validate(UserRegisterBody userRegisterBody) throws UserValidateException {
        if (userRegisterBody.getUsername().length() < 6 || userRegisterBody.getUsername().length() > 32) {
            throw new UserValidateException("Size.userForm.username");
        }

        if (userService.findUserByUsername(userRegisterBody.getUsername()).isPresent()) {
            throw new UserValidateException("Duplicate.userForm.username");
        }

        if (userRegisterBody.getPassword().length() < 8 || userRegisterBody.getPassword().length() > 32) {
            throw new UserValidateException("Size.userForm.password");
        }
    }

}
