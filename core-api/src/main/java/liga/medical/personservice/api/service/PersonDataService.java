package liga.medical.personservice.api.service;

import liga.medical.personservice.dto.model.PersonData;

import java.util.Optional;

public interface PersonDataService {

    Optional<PersonData> getPersonDataByUserId(long id);
    void savePersonData(PersonData personData);
    void updatePersonData(PersonData personData);

}
