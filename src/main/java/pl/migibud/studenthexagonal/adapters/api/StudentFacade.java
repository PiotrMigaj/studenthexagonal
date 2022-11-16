package pl.migibud.studenthexagonal.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.migibud.studenthexagonal.domain.model.Student;
import pl.migibud.studenthexagonal.domain.ports.StudentService;

@Component
@RequiredArgsConstructor
class StudentFacade {

    private final StudentService studentService;

    StudentDto getStudentById(Long id){
        Student student = studentService.getById(id);
        return StudentDto.of(student);
    }

    StudentDto createStudent(CreateStudentRequest request){
        Student student = studentService.create(request.toStudent());
        return StudentDto.of(student);
    }

}
