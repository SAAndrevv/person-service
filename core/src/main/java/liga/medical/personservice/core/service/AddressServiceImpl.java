package liga.medical.personservice.core.service;

import liga.medical.personservice.api.service.AddressService;
import liga.medical.personservice.api.service.ContactService;
import liga.medical.personservice.core.repository.AddressRepository;
import liga.medical.personservice.dto.model.Address;
import liga.medical.personservice.dto.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    private final ContactService contactService;

    @Override
    public Optional<Address> getAddressByUserId(long id) {
        Optional<Contact> contact = contactService.getContactByUserId(id);
        if (contact.isEmpty()) {
            return Optional.empty();
        }

        return repository.findAddressByContactId(contact.get().getId());
    }

    @Override
    public void saveAddress(Address address) {
        repository.save(address);
    }

    @Override
    public void updateAddress(Address address) {
        repository.save(address);
    }

}
