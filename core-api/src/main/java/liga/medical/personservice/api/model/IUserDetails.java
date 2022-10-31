package liga.medical.personservice.api.model;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserDetails extends UserDetails {

    String getId();

}
