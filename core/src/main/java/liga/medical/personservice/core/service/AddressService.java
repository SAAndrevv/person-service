package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();

    Address getAddressById(long id);
}
