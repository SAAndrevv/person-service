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
        Optional<Long> id = userService.getIdByUsername(principal.getName());

        if (id.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        Optional<Address> addressOptional = addressService.getAddressByUserId(id.get());
        if (id.get() == address.getContact().getId() && addressOptional.isEmpty()) {
            addressService.saveAddress(address);
            return ResponseEntity.status(HttpStatus.CREATED).body(address);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PatchMapping
    public ResponseEntity<?> editAddress(@RequestBody Address address, Principal principal) {
        Optional<Long> id = userService.getIdByUsername(principal.getName());
        if (id.isPresent()) {
            Optional<Address> addressOptional = addressService.getAddressByUserId(id.get());

            if (id.get() == address.getContact().getId() && addressOptional.isPresent()) {
                addressService.updateAddress(address);
                return ResponseEntity.status(HttpStatus.OK).body(address);
            }

            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}
