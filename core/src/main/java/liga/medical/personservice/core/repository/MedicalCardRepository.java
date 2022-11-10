package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.MedicalCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedicalCardRepository extends CrudRepository<MedicalCard, Long> {

    @Query("SELECT mc FROM MedicalCard mc" +
            " JOIN PersonData pd ON mc.id = pd.medicalCard.id" +
            " JOIN Contact c ON c.id = pd.contact.id" +
            " WHERE c.id = ?1")
    Optional<MedicalCard> findMedicalCardByContactId(long id);

}
