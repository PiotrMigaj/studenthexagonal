package pl.migibud.studenthexagonal.adapters.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.migibud.studenthexagonal.domain.model.Address;
import pl.migibud.studenthexagonal.domain.ports.AddressRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

interface SqlAddressRepository extends JpaRepository<AddressEntity,Long>{
    Optional<AddressEntity> findByStudentId(Long id);
}

@Slf4j
@Repository
@RequiredArgsConstructor
class AddressRepositoryImpl implements AddressRepository {

    private final SqlAddressRepository sqlAddressRepository;
    private final SqlStudentRepository sqlStudentRepository;

    @Override
    public Address save(Address address) {
        Long id = address.getStudent().getId();
        StudentEntity studentEntity = sqlStudentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student does not exists with id: " + id));
        AddressEntity addressEntity = AddressEntity.of(address);
        log.info("addressEntity from repo: {}",addressEntity);
        return sqlAddressRepository.save(addressEntity).toDomain();
    }

    @Override
    public Optional<Address> getById(Long id) {
        Address address = sqlAddressRepository.findById(id)
                .map(AddressEntity::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Address does not exists with id: " + id));
        return Optional.of(address);
    }

    @Override
    public Optional<Address> getByStudentId(Long id) {
        Address address = sqlAddressRepository.findByStudentId(id)
                .map(AddressEntity::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Student does not exists with id: " + id));
        return Optional.of(address);
    }
}
