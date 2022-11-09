package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.Signal;
import org.springframework.data.repository.CrudRepository;

public interface SignalRepository extends CrudRepository<Signal, Long> {
}
