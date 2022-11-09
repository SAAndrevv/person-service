package liga.medical.personservice.api.service;

import liga.medical.personservice.dto.model.Role;
import liga.medical.personservice.dto.model.User;
import liga.medical.personservice.dto.security.UserRegisterBody;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    UserDetails getUserPrincipalByUsername(String username) throws UsernameNotFoundException;

    Optional<User> findUserByUsername(String username);

    void save(UserRegisterBody userRegisterBody);

    List<User> getAllUsers();

    void addRoleToUser(String username, Role role);

    void deleteByUsername(String username);

}
