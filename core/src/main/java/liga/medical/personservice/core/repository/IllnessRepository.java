package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.Illness;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IllnessRepository extends CrudRepository<Illness, Long> {

    @Query("SELECT i FROM Illness i" +
            " JOIN MedicalCard mc ON i.medicalCard.id = mc.id" +
            " JOIN PersonData pd ON mc.id = pd.medicalCard.id" +
            " JOIN Contact c ON c.id = pd.contact.id" +
            " WHERE c.id = ?1")
    Optional<Illness> findIllnessByContactId(long id);

}
