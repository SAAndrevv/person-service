package liga.medical.personservice.core.service;

import liga.medical.personservice.api.annotation.Verify;
import liga.medical.personservice.api.service.AuthenticateService;
import liga.medical.personservice.dto.security.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private final AuthenticationManager authenticationManager;

    @Verify
    @Override
    public void authenticate(AuthenticationRequest authenticationRequest) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(),
                authenticationRequest.getPassword()));
    }

}