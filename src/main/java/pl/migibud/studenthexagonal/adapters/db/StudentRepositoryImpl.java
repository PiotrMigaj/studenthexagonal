package pl.migibud.studenthexagonal.adapters.db;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.migibud.studenthexagonal.domain.model.Student;
import pl.migibud.studenthexagonal.domain.ports.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

interface SqlStudentRepository extends JpaRepository<StudentEntity,Long>{
}

@Repository
@RequiredArgsConstructor
class StudentRepositoryImpl implements StudentRepository {

    private final SqlStudentRepository sqlStudentRepository;
    @Override
    public Student save(Student student) {
        StudentEntity studentEntity = StudentEntity.of(student);
        return sqlStudentRepository.save(studentEntity).toDomain();
    }

    @Override
    public Optional<Student> getById(Long id) {
        Student student = sqlStudentRepository.findById(id)
                .map(StudentEntity::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Student does not exists with id: " + id));
        return Optional.of(student);
    }
}
