package person.management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.management.cmd.CreatePersonCmd;
import person.management.dto.PersonDto;
import person.management.mapper.PersonAddressMapper;
import person.management.model.Person;
import person.management.repository.PersonRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonAddressMapper personAddressMapper;

    @Transactional(readOnly = true)
    public List<PersonDto> findAll() {
        final List<Person> persons = personRepository.findAll();
        return personAddressMapper.entitiesToDtos(persons);
    }

    @Transactional
    public PersonDto create(final CreatePersonCmd cmd) {
        final Person person = personAddressMapper.cmdToEntity(cmd);
        personRepository.save(person);
        return personAddressMapper.entityToDto(person);
    }

    @Transactional
    public PersonDto update(final long id, final PersonDto cmd) {
        // raise exception if person not present
        Person person = findPersonById(id);
        person.setFirstName(cmd.getFirstName());
        person.setLastName(cmd.getLastName());
        person.setAddresses(personAddressMapper.dtoToEntities(cmd.getAddresses()));
        personRepository.save(person);
        return personAddressMapper.entityToDto(person);
    }

    @Transactional
    public void delete(final long id) {
        final Person person = findPersonById(id);
        personRepository.delete(person);
    }

    @Transactional
    public long count() {
        return personRepository.count();
    }

    public Person findPersonById(final long id) {
        return personRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
