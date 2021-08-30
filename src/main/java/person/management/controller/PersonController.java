package person.management.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import person.management.cmd.CreatePersonCmd;
import person.management.dto.PersonDto;
import person.management.service.PersonService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDto> findAll(){
        log.info("Getting all persons");
        final List<PersonDto> personDtos = personService.findAll();
        log.info("Found {} person(s)", personDtos.size());
        return personDtos;
    }

    @PostMapping
    public PersonDto create(@RequestBody @Valid final CreatePersonCmd cmd) {
        log.info("Creating person: data={}", cmd);
        final PersonDto personDto = personService.create(cmd);
        log.info("Person created: data={}", personDto);
        return personDto;
    }

    @PutMapping
    public PersonDto upload(@RequestBody @Valid final PersonDto cmd) {
        log.info("Updating person: data={}", cmd);
        final PersonDto personDto = personService.update(cmd.getId(), cmd);
        log.info("Person updated: data={}", personDto);
        return personDto;
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final long id) {
        log.info("Deleting person: ={}", id);
        personService.delete(id);
        log.info("Person deleted: id={}", id);
    }

    @GetMapping(value = "/count")
    public Long count() {
        log.info("Counting person");
        final long nbPerson = personService.count();
        log.info("Found {} person(s)", nbPerson);
        return nbPerson;
    }
}
