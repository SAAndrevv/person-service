package liga.medical.personservice.core.mapper;

import liga.medical.personservice.dto.model.Role;
import liga.medical.personservice.dto.security.RoleDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleModelMapper {

    @NonNull
    private ModelMapper mapper;

    public Role toRole(RoleDto roleDto) {
        return mapper.map(roleDto, Role.class);
    }

    public RoleDto toDto(Role role) {
        return mapper.map(role, RoleDto.class);
    }

    public Set<Role> toRoles(Set<RoleDto> roleDtos) {
        return roleDtos
                .stream()
                .map(role -> mapper.map(role, Role.class))
                .collect(Collectors.toSet());
    }

    public Set<RoleDto> toDtos(Set<Role> roles) {
        return roles
                .stream()
                .map(role -> mapper.map(role, RoleDto.class))
                .collect(Collectors.toSet());
    }

}
