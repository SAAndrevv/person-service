package liga.medical.personservice.core.service;

import liga.medical.personservice.core.mappers.PersonDataMapper;
import liga.medical.personservice.core.model.PersonData;
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
