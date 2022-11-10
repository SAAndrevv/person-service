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
        Optional<Long> id = userService.getIdByUsername(principal.getName());

        if (id.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        Optional<MedicalCard> medicalCardOptional = medicalCardService.getMedicalCardByUserId(id.get());

        // Not full check
        if (medicalCardOptional.isEmpty()) {
            medicalCardService.saveMedicalCard(medicalCard);
            return ResponseEntity.status(HttpStatus.CREATED).body(medicalCard);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PatchMapping
    public ResponseEntity<?> editMedicalCard(@RequestBody MedicalCard medicalCard, Principal principal) {
        Optional<Long> id = userService.getIdByUsername(principal.getName());
        if (id.isPresent()) {
            Optional<MedicalCard> medicalCardOptional = medicalCardService.getMedicalCardByUserId(id.get());

            if (medicalCardOptional.isPresent() &&
                    medicalCardOptional.get().getId() == medicalCard.getId()) {
                medicalCardService.updateMedicalCard(medicalCard);
                return ResponseEntity.status(HttpStatus.OK).body(medicalCard);
            }

            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}
