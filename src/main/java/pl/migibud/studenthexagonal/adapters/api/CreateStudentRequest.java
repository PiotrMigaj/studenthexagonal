package pl.migibud.studenthexagonal.adapters.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.migibud.studenthexagonal.domain.model.Student;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private int age;
    private boolean graduated;

    Student toStudent() {
        return new Student(
                firstName,
                lastName,
                age,
                graduated
        );
    }
}
