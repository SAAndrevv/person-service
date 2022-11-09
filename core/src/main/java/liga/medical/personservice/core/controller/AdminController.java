package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.dto.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Api("Admin API")
public class AdminController {

    private final UserService userService;

    @GetMapping
    @ApiOperation("Get all registered users")
    public ResponseEntity<?> userList() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/delete-user/{username}")
    @ApiOperation("Delete user by id")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
        userService.deleteByUsername(username);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-role/{username}")
    @ApiOperation("Add role to user by id")
    public ResponseEntity<?> addRoleToUser(@PathVariable("username") String username, @RequestBody Role role) {
        userService.addRoleToUser(username, role);

        return ResponseEntity.ok().build();
    }

}
