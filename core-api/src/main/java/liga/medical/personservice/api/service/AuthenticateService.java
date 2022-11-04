package liga.medical.personservice.api.service;

import liga.medical.personservice.dto.security.AuthenticationRequest;

public interface AuthenticateService {

    void authenticate(AuthenticationRequest authenticationRequest);

}
