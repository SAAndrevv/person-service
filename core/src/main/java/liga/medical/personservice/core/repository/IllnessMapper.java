package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.Illness;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IllnessMapper {

    List<Illness> findAllIllness();

}
