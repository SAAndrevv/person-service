package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.IllnessService;
import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.dto.model.Illness;
import liga.medical.personservice.dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user/illness")
@RequiredArgsConstructor
public class IllnessController {

    private final IllnessService illnessService;

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getIllness(Principal principal) {
        Optional<User> user = userService.findUserByUsername(principal.getName());
        long id = user.get().getId();

        Optional<Illness> illness = illnessService.getIllnessByUserId(id);

        if (illness.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(illness.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addIllness(@RequestBody Illness illness, Principal principal) {
        //TODO check if the user saves his data and that data not created
        illnessService.saveIllness(illness);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping
    public ResponseEntity<?> editIllness(@RequestBody Illness illness, Principal principal) {
        //TODO check if the user edit his data
        illnessService.updateIllness(illness);

        return ResponseEntity.ok().build();
    }

}
