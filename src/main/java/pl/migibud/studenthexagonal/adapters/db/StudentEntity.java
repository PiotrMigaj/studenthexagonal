package pl.migibud.studenthexagonal.adapters.db;

import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.migibud.studenthexagonal.domain.model.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@ToString
class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private boolean graduated;

    private StudentEntity(String firstName, String lastName, int age, boolean graduated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.graduated = graduated;
    }

    private StudentEntity(Long id, String firstName, String lastName, int age, boolean graduated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.graduated = graduated;
    }

    static StudentEntity of(Student student){
        return new StudentEntity(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.isGraduated()
        );
    }

    Student toDomain(){
        return new Student(
                id,
                firstName,
                lastName,
                age,
                graduated
        );
    }
}
