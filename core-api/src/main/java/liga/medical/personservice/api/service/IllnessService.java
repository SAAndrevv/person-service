package liga.medical.personservice.api.service;

import liga.medical.personservice.dto.model.Illness;

import java.util.Optional;

public interface IllnessService {

    Optional<Illness> getIllnessByUserId(long id);
    void saveIllness(Illness illness);
    void updateIllness(Illness illness);

}
