package person.management.dto;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class AddressDto {

    @NonNull
    private Long id;

    @NonNull
    private String street;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private String postalCode;
}
