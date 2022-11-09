package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.ContactService;
import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.dto.model.Contact;
import liga.medical.personservice.dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getContact(Principal principal) {
        Optional<User> user = userService.findUserByUsername(principal.getName());
        long id = user.get().getId();

        Optional<Contact> contact = contactService.getContactByUserId(id);

        if (contact.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(contact.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addContact(@RequestBody Contact contact, Principal principal) {
        //TODO check if the user saves his data and that data not created
        contactService.saveContact(contact);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping
    public ResponseEntity<?> editContact(@RequestBody Contact contact, Principal principal) {
        //TODO check if the user edit his data
        contactService.updateContact(contact);

        return ResponseEntity.ok().build();
    }

}
