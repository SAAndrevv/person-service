package liga.medical.personservice.api.service;

import liga.medical.personservice.dto.model.Address;

import java.util.Optional;

public interface AddressService {

    Optional<Address> getAddressByUserId(long id);
    void saveAddress(Address address);
    void updateAddress(Address address);

}
