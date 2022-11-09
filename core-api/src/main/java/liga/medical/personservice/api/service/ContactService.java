package liga.medical.personservice.api.service;

import liga.medical.personservice.dto.model.Contact;

import java.util.Optional;

public interface ContactService {

    Optional<Contact> getContactByUserId(long id);
    void saveContact(Contact contact);
    void updateContact(Contact contact);

}
