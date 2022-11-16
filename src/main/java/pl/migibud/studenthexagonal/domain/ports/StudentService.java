package pl.migibud.studenthexagonal.domain.ports;

import lombok.RequiredArgsConstructor;
import pl.migibud.studenthexagonal.domain.model.Student;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student create(Student student){
        return studentRepository.save(student);
    }

    public Student getById(Long id){
        return studentRepository.getById(id)
                .orElseThrow(()->new EntityNotFoundException("Student not found with id: "+id));
    }

}
