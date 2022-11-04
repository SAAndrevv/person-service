package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.log.LogDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LogMapper {

    void save(@Param("log") LogDto logDto);

}
