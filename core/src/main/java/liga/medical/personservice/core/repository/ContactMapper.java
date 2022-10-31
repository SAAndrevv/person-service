package liga.medical.personservice.core.repository;

import liga.medical.personservice.dto.model.Contact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactMapper {

    List<Contact> findAllContact();
}
