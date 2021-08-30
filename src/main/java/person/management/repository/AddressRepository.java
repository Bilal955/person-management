package person.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import person.management.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
