package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Long> {

    Optional<Address> findAddressByContactId(long id);

}
