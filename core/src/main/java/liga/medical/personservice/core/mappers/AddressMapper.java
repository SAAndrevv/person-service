package liga.medical.personservice.core.mappers;

import liga.medical.personservice.core.model.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressMapper {

    List<Address> findAllAddress();

    Address findAddressById(@Param("id") long id);

}
