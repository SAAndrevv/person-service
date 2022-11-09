package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.MedicalCardService;
import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.dto.model.MedicalCard;
import liga.medical.personservice.dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user/medical-card")
@RequiredArgsConstructor
public class MedicalCardController {

    private final MedicalCardService medicalCardService;

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getMedicalCard(Principal principal) {
        Optional<User> user = userService.findUserByUsername(principal.getName());
        long id = user.get().getId();

        Optional<MedicalCard> medicalCard = medicalCardService.getMedicalCardByUserId(id);

        if (medicalCard.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(medicalCard.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addMedicalCard(@RequestBody MedicalCard medicalCard, Principal principal) {
        //TODO check if the user saves his data and that data not created
        medicalCardService.saveMedicalCard(medicalCard);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping
    public ResponseEntity<?> editMedicalCard(@RequestBody MedicalCard medicalCard, Principal principal) {
        //TODO check if the user edit his data
        medicalCardService.updateMedicalCard(medicalCard);

        return ResponseEntity.ok().build();
    }

}
