package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.PersonDataService;
import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.dto.model.Address;
import liga.medical.personservice.dto.model.PersonData;
import liga.medical.personservice.dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user/person-data")
@RequiredArgsConstructor
public class PersonDataController {

    private final PersonDataService personDataService;

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getPersonData(Principal principal) {
        Optional<User> user = userService.findUserByUsername(principal.getName());
        long id = user.get().getId();

        Optional<PersonData> personData = personDataService.getPersonDataByUserId(id);
        System.out.println(personData);
        if (personData.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(personData.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addPersonData(@RequestBody PersonData personData, Principal principal) {
        Optional<Long> id = userService.getIdByUsername(principal.getName());

        if (id.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        Optional<PersonData> personDataOptional = personDataService.getPersonDataByUserId(id.get());
        if (id.get() == personData.getContact().getId() && personDataOptional.isEmpty()) {
            personDataService.savePersonData(personData);
            return ResponseEntity.status(HttpStatus.CREATED).body(personData);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PatchMapping
    public ResponseEntity<?> editPersonData(@RequestBody PersonData personData, Principal principal) {
        Optional<Long> id = userService.getIdByUsername(principal.getName());
        if (id.isPresent()) {
            Optional<PersonData> personDataOptional = personDataService.getPersonDataByUserId(id.get());

            if (id.get() == personData.getContact().getId() && personDataOptional.isPresent()) {
                personDataService.updatePersonData(personData);
                return ResponseEntity.status(HttpStatus.OK).body(personData);
            }

            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}
