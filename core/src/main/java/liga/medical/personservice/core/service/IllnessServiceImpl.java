package liga.medical.personservice.core.service;

import liga.medical.personservice.core.mappers.IllnessMapper;
import liga.medical.personservice.core.model.Illness;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IllnessServiceImpl implements IllnessService {

    @NonNull
    private IllnessMapper mapper;

    @Override
    public List<Illness> getAllIllness() {
        return mapper.findAllIllness();
    }

}
