package pl.migibud.studenthexagonal.domain.ports;

import pl.migibud.studenthexagonal.domain.model.Student;

import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);
    Optional<Student> getById(Long id);
}
