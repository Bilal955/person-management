package person.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PersonManagementApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PersonManagementApplication.class, args);
    }

}
