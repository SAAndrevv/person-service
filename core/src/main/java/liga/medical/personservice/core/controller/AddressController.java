package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.AddressService;
import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.dto.model.Address;
import liga.medical.personservice.dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAddress(Principal principal) {
        Optional<User> user = userService.findUserByUsername(principal.getName());
        long id = user.get().getId();

        Optional<Address> address = addressService.getAddressByUserId(id);

        if (address.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(address.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addAddress(@RequestBody Address address, Principal principal) {
        //TODO check if the user saves his data and that data not created
        addressService.saveAddress(address);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping
    public ResponseEntity<?> editAddress(@RequestBody Address address, Principal principal) {
        //TODO check if the user edit his data
        addressService.updateAddress(address);

        return ResponseEntity.ok().build();
    }

}
