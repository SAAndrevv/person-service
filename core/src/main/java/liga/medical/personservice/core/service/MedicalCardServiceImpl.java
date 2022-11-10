package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.MedicalCardService;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.dto.model.MedicalCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    private final MedicalCardRepository repository;

    @Override
    public Optional<MedicalCard> getMedicalCardByUserId(long id) {
        return repository.findMedicalCardByContactId(id);
    }

    @Override
    public void saveMedicalCard(MedicalCard medicalCard) {
        repository.save(medicalCard);
    }

    @Override
    public void updateMedicalCard(MedicalCard medicalCard) {
        repository.save(medicalCard);
    }

    @Override
    public Optional<Long> getMedicalCardIdByUserId(long id) {
        Optional<MedicalCard> medicalCard = repository.findMedicalCardByContactId(id);
        return medicalCard.map(MedicalCard::getId);
    }

}
