package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.UserPrincipal;
import liga.medical.personservice.dto.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface UserToRoleMapper {

    void addUserRoles(@Param("user") UserPrincipal user, @Param("roles") Set<Role> roleSet);

}
