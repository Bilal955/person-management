package person.management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.management.cmd.CreateAddressCmd;
import person.management.dto.AddressDto;
import person.management.mapper.PersonAddressMapper;
import person.management.model.Address;
import person.management.model.Person;
import person.management.repository.AddressRepository;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final PersonService personService;
    private final PersonAddressMapper personAddressMapper;

    @Transactional
    public AddressDto create(final long personId, final CreateAddressCmd cmd) {
        final Person person = personService.findPersonById(personId);
        final Address address = personAddressMapper.cmdToEntity(person, cmd);
        addressRepository.save(address);
        return personAddressMapper.entityToDto(address);
    }

    @Transactional
    public AddressDto update(final long id, final AddressDto cmd) {
        // raise exception if address not present
        findAddressById(id);
        Address address = personAddressMapper.dtoToEntity(cmd);
        addressRepository.save(address);
        return personAddressMapper.entityToDto(address);
    }

    @Transactional
    public void delete(final long id) {
        final Address address = findAddressById(id);
        addressRepository.delete(address);
    }

    private Address findAddressById(final long id) {
        return addressRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
