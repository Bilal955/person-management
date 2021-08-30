package person.management.cmd;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class CreatePersonCmd {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

}
