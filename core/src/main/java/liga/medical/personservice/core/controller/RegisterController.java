package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.dto.exception.UserValidateException;
import liga.medical.personservice.dto.security.UserRegisterBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
@Api("Registration API")
public class RegisterController {

    private final UserService userService;

    private final UserValidate userValidate;

    @PostMapping
    @ApiOperation("Register current user")
    public ResponseEntity<?> addUser(@RequestBody UserRegisterBody userRegisterBody) {
        try {
            userValidate.validate(userRegisterBody);
        } catch (UserValidateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        userService.save(userRegisterBody);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
