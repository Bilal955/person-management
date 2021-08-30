package person.management.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import person.management.cmd.CreateAddressCmd;
import person.management.dto.AddressDto;
import person.management.service.AddressService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping(value = "/{personId}")
    public AddressDto create(@PathVariable final long personId, @RequestBody @Valid final CreateAddressCmd cmd) {
        log.info("Creating address: data={}", cmd);
        final AddressDto addressDto = addressService.create(personId, cmd);
        log.info("Address created: data={}", addressDto);
        return addressDto;
    }

    @PutMapping
    public AddressDto upload(@RequestBody @Valid final AddressDto cmd) {
        log.info("Updating address: data={}", cmd);
        final AddressDto addressDto = addressService.update(cmd.getId(), cmd);
        log.info("Address updated: data={}", addressDto);
        return addressDto;
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final long id) {
        log.info("Deleting address: ={}", id);
        addressService.delete(id);
        log.info("Address deleted: id={}", id);
    }

}
