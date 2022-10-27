package liga.medical.personservice.core.service;

import liga.medical.personservice.core.mappers.PersonDataMapper;
import liga.medical.personservice.core.model.Address;
import liga.medical.personservice.core.model.PersonData;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@EnableScheduling
@RequiredArgsConstructor
@Service
public class PersonDataServiceImpl implements PersonDataService {

    @NonNull
    private PersonDataMapper mapper;

    @Override
    public List<PersonData> getAllPersonData() {
        return mapper.findAllPersonData();
    }

    @Scheduled(fixedDelay = 1000)
    public void test() {
        List<PersonData> test = mapper.findAllPersonData();
        test.forEach(System.out::println);
    }

}
