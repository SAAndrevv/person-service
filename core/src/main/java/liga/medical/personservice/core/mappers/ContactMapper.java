package liga.medical.personservice.core.mappers;

import liga.medical.personservice.core.model.Contact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactMapper {

    List<Contact> findAllContact();
}
