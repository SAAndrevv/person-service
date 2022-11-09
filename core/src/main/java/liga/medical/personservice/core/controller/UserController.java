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

    private final PersonDataService personDataService;

    @GetMapping
    @ApiOperation("Get current user information")
    public ResponseEntity<?> getUserInfo(Principal principal) {
        Optional<User> user = userService.findUserByUsername(principal.getName());
        long id = user.get().getId();

        Optional<PersonData> personData = personDataService.getPersonDataByUserId(id);

        if (personData.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(personData.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addUserInfo(@RequestBody PersonData personData, Principal principal) {
        //TODO check if the user saves his data and that data not created
        personDataService.savePersonData(personData);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
