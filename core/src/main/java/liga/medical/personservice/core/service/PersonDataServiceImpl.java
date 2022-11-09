package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.PersonDataService;
import liga.medical.personservice.core.repository.PersonDataRepository;
import liga.medical.personservice.dto.model.PersonData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonDataServiceImpl implements PersonDataService {

    private final PersonDataRepository repository;

    @Override
    public Optional<PersonData> getPersonDataByUserId(long id) {
        return repository.findPersonDataByContactId(id);
    }

    @Override
    public void savePersonData(PersonData personData) {
        repository.save(personData);
    }

    @Override
    public void updatePersonData(PersonData personData) {
        repository.save(personData);
    }

}
