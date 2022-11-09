package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    enum Roles {
        ROLE_ADMIN, ROLE_USER
    }

    Optional<User> findUserByUsername(String username);
    void deleteUserByUsername(String username);

}
