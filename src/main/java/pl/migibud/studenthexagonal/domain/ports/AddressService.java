package pl.migibud.studenthexagonal.domain.ports;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.migibud.studenthexagonal.domain.model.Address;
import pl.migibud.studenthexagonal.domain.model.Student;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final StudentRepository studentRepository;

    public Address create(Address address,Long studentId){
        Student student = studentRepository.getById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));
        log.info("Student from address service: {}",student);
        address.setStudent(student);
        return addressRepository.save(address);
    }

    public Address getById(Long id){
        return addressRepository.getById(id)
                .orElseThrow(()->new EntityNotFoundException("Address not found with id: "+id));
    }

    public Address getByStudentId(Long id){
        return addressRepository.getByStudentId(id)
                .orElseThrow(()->new EntityNotFoundException("Student not found with id: "+id));
    }

}
