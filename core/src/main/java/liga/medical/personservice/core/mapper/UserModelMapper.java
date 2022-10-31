package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.UserPrincipal;
import liga.medical.personservice.dto.security.UserDto;
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

    public UserPrincipal toPrincipal(UserDto userDto) {
        return mapper.map(userDto, UserPrincipal.class);
    }

    public UserDto toDto(UserPrincipal userPrincipal) {
        return mapper.map(userPrincipal, UserDto.class);
    }

    public List<UserPrincipal> toPrincipals(List<UserDto> userDtos) {
        return userDtos
                .stream()
                .map(user -> mapper.map(user, UserPrincipal.class))
                .collect(Collectors.toList());
    }

    public List<UserDto> toDtos(List<UserPrincipal> userPrincipals) {
        return userPrincipals
                .stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

}
