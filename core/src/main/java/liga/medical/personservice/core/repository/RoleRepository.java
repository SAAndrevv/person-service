package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findRoleByName(String name);

}
