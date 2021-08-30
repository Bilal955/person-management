package person.management.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import person.management.cmd.CreateAddressCmd;
import person.management.cmd.CreatePersonCmd;
import person.management.dto.AddressDto;
import person.management.dto.PersonDto;
import person.management.model.Address;
import person.management.model.Person;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PersonAddressMapper {

    public PersonDto entityToDto(final Person entity) {
        if (entity == null) {
            return null;
        }
        return PersonDto.of(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entitiesToDtos(entity.getAddresses()));
    }

    public List<PersonDto> entitiesToDtos(final List<Person> entites) {
        return entites.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    private Set<AddressDto> entitiesToDtos(final Set<Address> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toSet());
    }

    public AddressDto entityToDto(final Address entity) {
        return AddressDto.of(
                entity.getId(),
                entity.getStreet(),
                entity.getCity(),
                entity.getState(),
                entity.getPostalCode());
    }

    public Person cmdToEntity(final CreatePersonCmd createPersonCmd) {
        return Person.builder()
                .firstName(createPersonCmd.getFirstName())
                .lastName(createPersonCmd.getLastName())
                .build();
    }

    public Set<Address> dtoToEntities(final Set<AddressDto> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toSet());
    }

    public Address dtoToEntity(final AddressDto dto) {
        return Address.builder()
                .city(dto.getCity())
                .postalCode(dto.getPostalCode())
                .state(dto.getState())
                .street(dto.getStreet())
                .build();
    }

    public Address cmdToEntity(final Person person, final CreateAddressCmd createAddressCmd) {
        return Address.builder()
                .city(createAddressCmd.getCity())
                .postalCode(createAddressCmd.getPostalCode())
                .state(createAddressCmd.getState())
                .street(createAddressCmd.getStreet())
                .person(person)
                .build();
    }
}
