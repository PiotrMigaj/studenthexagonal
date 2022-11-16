package pl.migibud.studenthexagonal.adapters.api;

import lombok.*;
import pl.migibud.studenthexagonal.domain.model.Student;

@NoArgsConstructor
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private boolean graduated;

    static StudentDto of(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.isGraduated()
        );
    }
}
