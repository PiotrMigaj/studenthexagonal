package pl.migibud.studenthexagonal.domain.ports;

import pl.migibud.studenthexagonal.domain.model.Address;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AddressRepository {
    Address save(Address address);
    Optional<Address> getById(Long id);
    Optional<Address> getByStudentId(Long id);
}

