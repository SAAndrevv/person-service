package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.api.service.AuthenticateService;
import liga.medical.personservice.dto.security.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api("Authentication API")
public class AuthenticateController {

    private final AuthenticateService authenticateService;

    /**
     * Not full authentication. Only for demonstrate work of logger.
     * For correct authentication use /login
     * @param authenticationRequest username + password
     * @return ResponseEntity
     */
    @PostMapping("/auth")
    @ApiOperation("Sign in")
    public ResponseEntity<?> authentication(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticateService.authenticate(authenticationRequest);

        } catch (AuthenticationException aex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(aex.getMessage());
        }

        return ResponseEntity.ok("Success authentication");
    }

}
