package liga.medical.personservice.api.service;

import liga.medical.personservice.dto.model.MedicalCard;

import java.util.Optional;

public interface MedicalCardService {

    Optional<MedicalCard> getMedicalCardByUserId(long id);
    void saveMedicalCard(MedicalCard medicalCard);
    void updateMedicalCard(MedicalCard medicalCard);

}