package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.ContactService;
import liga.medical.personservice.core.repository.ContactMapper;
import liga.medical.personservice.dto.model.Contact;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    @NonNull
    private ContactMapper mapper;

    @Override
    public List<Contact> getAllContacts() {
        return mapper.findAllContact();
    }

}
