package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.MedicalCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MedicalCardMapper {

    List<MedicalCard> findAllMedicalCard();

}
