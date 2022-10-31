package liga.medical.personservice.api.service;

import liga.medical.personservice.dto.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();

    Address getAddressById(long id);
}
