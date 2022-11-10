package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.api.service.PersonDataService;
import liga.medical.personservice.api.service.UserService;

import liga.medical.personservice.dto.model.PersonData;
import liga.medical.personservice.dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api("User information API")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ApiOperation("Get current user information")
    public ResponseEntity<?> getUserInfo(Principal principal) {
        Optional<User> user = userService.findUserByUsername(principal.getName());

        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
