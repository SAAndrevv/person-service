package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.UserPrincipal;
import liga.medical.personservice.dto.model.User;
import liga.medical.personservice.dto.security.UserRegisterBody;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserModelMapper {

    @NonNull
    private ModelMapper mapper;

    public UserPrincipal userToPrincipal(User user) {
        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setUsername(user.getUsername());
        userPrincipal.setPassword(user.getPassword());
        userPrincipal.setRoles(user.getRoles());
        return userPrincipal;
    }

    public User userRegisterBodyToUser(UserRegisterBody userRegisterBody) {
        return mapper.map(userRegisterBody, User.class);
    }

}
