package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.PersonData;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonDataRepository extends CrudRepository<PersonData, Long> {


    Optional<PersonData> findPersonDataByContactId(long id);

}
