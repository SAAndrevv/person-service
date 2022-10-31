package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.UserPrincipal;
import liga.medical.personservice.dto.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Mapper
public interface UserMapper {

    Optional<UserPrincipal> findUserUuidByName(@Param("name") String name);

    Optional<UserPrincipal> findUserUuidByUuid(@Param("uuid") String uuid);

    Optional<User> findUserByUserName(@Param("username") String username);

    List<UserPrincipal> findAllUsers();

    void saveUser(@Param("user") User user, @Param("uuid") String uuid);

    void saveUserToRole(@Param("roles") Set<Integer> roleSet, @Param("uuid") String uuid);

    default void save(String uuid, User user, Set<Integer> roleSet) {
        saveUser(user, uuid);
        saveUserToRole(roleSet, uuid);
    }

    void deleteUserToRole(@Param("uuid") String uuid);

    void deleteUser(@Param("uuid") String uuid);

    default void deleteUserById(String uuid) {
        deleteUserToRole(uuid);
        deleteUser(uuid);
    }

}
