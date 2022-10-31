package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface RoleMapper {

    enum Roles {
        ROLE_ADMIN, ROLE_USER
    }

    Optional<Role> findRoleById(@Param("id") long id);

}
