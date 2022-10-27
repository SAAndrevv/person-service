package liga.medical.personservice.core.mappers;

import liga.medical.personservice.core.model.PersonData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonDataMapper {

    List<PersonData> findAllPersonData();

}
