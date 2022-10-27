package liga.medical.personservice.core.mappers;

import liga.medical.personservice.core.model.MedicalCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MedicalCardMapper {

    List<MedicalCard> findAllMedicalCard();

}
