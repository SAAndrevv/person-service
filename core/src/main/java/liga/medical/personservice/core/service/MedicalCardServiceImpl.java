package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.MedicalCardService;
import liga.medical.personservice.core.repository.MedicalCardMapper;
import liga.medical.personservice.dto.model.MedicalCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    @NonNull
    private MedicalCardMapper mapper;

    @Override
    public List<MedicalCard> getAllMedicalCard() {
        return mapper.findAllMedicalCard();
    }

}
