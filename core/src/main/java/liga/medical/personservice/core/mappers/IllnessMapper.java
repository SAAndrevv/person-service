package liga.medical.personservice.core.mappers;

import liga.medical.personservice.core.model.Illness;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IllnessMapper {

    List<Illness> findAllIllness();

}
