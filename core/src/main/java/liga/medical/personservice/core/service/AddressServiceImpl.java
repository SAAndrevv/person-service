package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.AddressService;
import liga.medical.personservice.core.repository.AddressMapper;
import liga.medical.personservice.dto.model.Address;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
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
