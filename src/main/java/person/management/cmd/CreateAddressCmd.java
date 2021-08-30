package person.management.cmd;

import lombok.NonNull;
import lombok.Value;
import person.management.dto.PersonDto;

import javax.validation.Valid;

@Value(staticConstructor = "of")
public class CreateAddressCmd {

    @NonNull
    private String street;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private String postalCode;

    @Valid
    private PersonDto personDto;

}
