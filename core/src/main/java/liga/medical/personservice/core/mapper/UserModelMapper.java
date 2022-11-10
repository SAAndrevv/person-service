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
        return mapper.map(user, UserPrincipal.class);
    }

    public User userRegisterBodyToUser(UserRegisterBody userRegisterBody) {
        return mapper.map(userRegisterBody, User.class);
    }

}
