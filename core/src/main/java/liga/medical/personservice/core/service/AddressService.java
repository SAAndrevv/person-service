package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();

    Address getAddressById(long id);
}
