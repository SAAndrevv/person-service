package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.UserPrincipal;
import liga.medical.personservice.dto.model.User;
import liga.medical.personservice.dto.security.UserRegisterBody;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserModelMapper {

    @NonNull
    private ModelMapper mapper;

    /*public UserPrincipal toPrincipal(UserDto userDto) {
        return mapper.map(userDto, UserPrincipal.class);
    }*/

    public UserPrincipal userToPrincipal(User user) {
        return mapper.map(user, UserPrincipal.class);
    }

    public User userRegisterBodyToUser(UserRegisterBody userRegisterBody) {
        return mapper.map(userRegisterBody, User.class);
    }

    public UserRegisterBody toDto(UserPrincipal userPrincipal) {
        return mapper.map(userPrincipal, UserRegisterBody.class);
    }

    public List<UserPrincipal> toPrincipals(List<UserRegisterBody> userRegisterBodies) {
        return userRegisterBodies
                .stream()
                .map(user -> mapper.map(user, UserPrincipal.class))
                .collect(Collectors.toList());
    }

    public List<UserRegisterBody> toDtos(List<UserPrincipal> userPrincipals) {
        return userPrincipals
                .stream()
                .map(user -> mapper.map(user, UserRegisterBody.class))
                .collect(Collectors.toList());
    }

}
