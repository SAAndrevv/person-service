package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.api.service.AuthenticateService;
import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.core.filter.config.JwtUtil;
import liga.medical.personservice.dto.security.AuthenticationRequest;
import liga.medical.personservice.dto.security.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api("Authentication API")
public class AuthenticateController {

    private final AuthenticateService authenticateService;

    private final UserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("/auth")
    @ApiOperation("Sign in")
    public ResponseEntity<?> authentication(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticateService.authenticate(authenticationRequest);
        } catch (AuthenticationException aex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(aex.getMessage());
        }

        UserDetails userDetails = userService
                .loadUserByUsername(authenticationRequest.getUsername());

        String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
