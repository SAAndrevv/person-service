package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.ContactService;
import liga.medical.personservice.core.repository.ContactRepository;
import liga.medical.personservice.dto.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    @Override
    public Optional<Contact> getContactByUserId(long id) {
        return repository.findById(id);
    }

    @Override
    public void saveContact(Contact contact) {
        repository.save(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        repository.save(contact);
    }

}
