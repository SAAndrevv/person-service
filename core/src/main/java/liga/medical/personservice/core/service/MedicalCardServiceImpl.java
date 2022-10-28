package liga.medical.personservice.core.service;

import liga.medical.personservice.core.mappers.MedicalCardMapper;
import liga.medical.personservice.core.model.MedicalCard;
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
