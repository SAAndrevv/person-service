package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.core.mapper.RoleModelMapper;
import liga.medical.personservice.core.repository.UserToRoleMapper;
import liga.medical.personservice.dto.model.Role;
import liga.medical.personservice.dto.security.RoleDto;
import liga.medical.personservice.dto.security.UserDto;
import liga.medical.personservice.core.mapper.UserModelMapper;
import liga.medical.personservice.core.model.UserPrincipal;
import liga.medical.personservice.core.repository.RoleMapper;
import liga.medical.personservice.core.repository.UserMapper;
import liga.medical.personservice.dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final RoleMapper roleMapper;

    private final UserModelMapper userModelMapper;

    private final RoleModelMapper roleModelMapper;

    private final UserToRoleMapper userToRoleMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setId(UUID.randomUUID().toString());
        Set<Integer> roleIdList = Set.of(RoleMapper.Roles.ROLE_USER.ordinal());
        userMapper.save(user.getId(), user, roleIdList);
    }

    @Override
    public void addRolesToUser(String userId, Set<RoleDto> roles) {
        UserPrincipal userPrincipal =  getUserByUuid(userId);
        Set<Role> roleSet = roles.stream()
                .filter(role -> roleMapper.findRoleById(role.getId()).isPresent())
                .map(roleModelMapper::toRole)
                .collect(Collectors.toSet());

        userToRoleMapper.addUserRoles(userPrincipal, roleSet);
    }

    @Override
    public void addRoleToUser(String userId, String roleName) {
        RoleMapper.Roles enumRole = null;
        System.out.println(roleName);
        try {
            enumRole = RoleMapper.Roles.valueOf(roleName);
        } catch (IllegalArgumentException ex) {
            System.out.println("Role not found");
        }

        if (enumRole != null) {
            addRolesToUser(userId, Set.of(new RoleDto(enumRole.ordinal(), roleName)));
        }
    }

    @Override
    public void deleteById(String uuid) {
        userMapper.deleteUserById(uuid);
    }

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserPrincipal> user = userMapper.findUserUuidByName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found user with username: " + username));

        return user.get();
    }

    public Optional<User> findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

    @Override
    public UserDto getUserDtoByUserName(String username) {
        return userModelMapper.toDto(loadUserByUsername(username));
    }

    @Override
    public UserPrincipal getUserByUuid(String uuid) throws UsernameNotFoundException {
        Optional<UserPrincipal> user = userMapper.findUserUuidByUuid(uuid);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found user with uuid: " + uuid));

        return user.get();
    }

    @Override
    public List<UserDto> getAllUsersDto() {
        List<UserPrincipal> userPrincipals = userMapper.findAllUsers();

        return userModelMapper.toDtos(userPrincipals);
    }

}
