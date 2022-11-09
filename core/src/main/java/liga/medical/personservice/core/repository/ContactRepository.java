package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
