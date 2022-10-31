package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.PersonDataService;
import liga.medical.personservice.core.repository.PersonDataMapper;
import liga.medical.personservice.dto.model.PersonData;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonDataServiceImpl implements PersonDataService {

    @NonNull
    private PersonDataMapper mapper;

    @Override
    public List<PersonData> getAllPersonData() {
        return mapper.findAllPersonData();
    }

}
