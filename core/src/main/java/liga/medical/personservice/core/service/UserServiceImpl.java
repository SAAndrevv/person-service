package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.core.repository.RoleRepository;
import liga.medical.personservice.core.repository.UserRepository;
import liga.medical.personservice.dto.model.Role;
import liga.medical.personservice.dto.security.UserRegisterBody;
import liga.medical.personservice.core.mapper.UserModelMapper;
import liga.medical.personservice.core.model.UserPrincipal;
import liga.medical.personservice.dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserModelMapper userModelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public void save(UserRegisterBody userRegisterBody) {
        userRegisterBody.setPassword(bCryptPasswordEncoder.encode(userRegisterBody.getPassword()));
        User user = userModelMapper.userRegisterBodyToUser(userRegisterBody);

        Optional<Role> role = roleRepository.findRoleByName(UserRepository.Roles.ROLE_USER.toString());
        role.ifPresent(value -> user.setRoles(Set.of(value)));

        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new LinkedList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public void addRoleToUser(String username, Role role) {
        Optional<User> optionalUser = findUserByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.addRole(role);
            userRepository.save(user);
        }
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteUserByUsername(username);
    }

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found user with username: " + username));

        return userModelMapper.userToPrincipal(user.get());
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Optional<Long> getIdByUsername(String username) {
        return userRepository.findIdByUsername(username);
    }

    @Override
    public UserPrincipal getUserPrincipalByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = findUserByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found user with uuid: " + username));

        return userModelMapper.userToPrincipal(user.get());
    }

}
