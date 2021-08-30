package person.management.dto;

import lombok.NonNull;
import lombok.Value;

import java.util.Set;


@Value(staticConstructor = "of")
public class PersonDto {

    @NonNull
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private Set<AddressDto> addresses;
}
