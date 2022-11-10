package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.IllnessService;
import liga.medical.personservice.api.service.MedicalCardService;
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

    private final MedicalCardService medicalCardService;

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
        Optional<Long> id = userService.getIdByUsername(principal.getName());

        if (id.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        Optional<Illness> illnessOptional = illnessService.getIllnessByUserId(id.get());
        Optional<Long> medicalCardId = medicalCardService.getMedicalCardIdByUserId(id.get());
        if (illnessOptional.isEmpty() && medicalCardId.isPresent() &&
                medicalCardId.get() == illness.getMedicalCard().getId()) {
            illnessService.saveIllness(illness);
            return ResponseEntity.status(HttpStatus.CREATED).body(illness);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PatchMapping
    public ResponseEntity<?> editIllness(@RequestBody Illness illness, Principal principal) {
        Optional<Long> id = userService.getIdByUsername(principal.getName());
        if (id.isPresent()) {
            Optional<Illness> illnessOptional = illnessService.getIllnessByUserId(id.get());

            if (illnessOptional.isPresent() &&
                    illnessOptional.get().getMedicalCard().getId() == illness.getMedicalCard().getId()) {
                illnessService.updateIllness(illness);
                return ResponseEntity.status(HttpStatus.OK).body(illness);
            }

            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}
