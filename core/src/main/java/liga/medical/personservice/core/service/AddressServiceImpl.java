package liga.medical.personservice.core.service;

import liga.medical.personservice.core.mappers.AddressMapper;
import liga.medical.personservice.core.model.Address;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@EnableScheduling
public class AddressServiceImpl implements AddressService {

    @NonNull
    private AddressMapper mapper;

    @Override
    public List<Address> getAllAddress() {
        return mapper.findAllAddress();
    }

    @Override
    public Address getAddressById(long id) {
        return mapper.findAddressById(1);
    }

}
