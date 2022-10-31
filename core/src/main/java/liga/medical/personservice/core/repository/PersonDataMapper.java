package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.PersonData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonDataMapper {

    List<PersonData> findAllPersonData();

}
