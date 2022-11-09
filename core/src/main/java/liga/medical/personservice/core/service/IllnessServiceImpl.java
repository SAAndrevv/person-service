package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.IllnessService;
import liga.medical.personservice.core.repository.IllnessRepository;
import liga.medical.personservice.dto.model.Illness;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IllnessServiceImpl implements IllnessService {

    private final IllnessRepository repository;

    @Override
    public Optional<Illness> getIllnessByUserId(long id) {
        return repository.findIllnessByContactId(id);
    }

    @Override
    public void saveIllness(Illness illness) {
        repository.save(illness);
    }

    @Override
    public void updateIllness(Illness illness) {
        repository.save(illness);
    }

}
