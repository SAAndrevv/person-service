package liga.medical.personservice.api.service;

import liga.medical.personservice.api.model.IUserDetails;
import liga.medical.personservice.dto.model.User;
import liga.medical.personservice.dto.security.RoleDto;
import liga.medical.personservice.dto.security.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService extends UserDetailsService {

    @Override
    IUserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    IUserDetails getUserByUuid(String uuid) throws UsernameNotFoundException;

    Optional<User> findUserByUserName(String username);

    UserDto getUserDtoByUserName(String username);

    List<UserDto> getAllUsersDto();

    void save(User user);

    void addRolesToUser(String userId, Set<RoleDto> roles);

    void addRoleToUser(String userId, String roleName);

    void deleteById(String uuid);

}
