package pl.migibud.studenthexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private boolean graduated;

    public Student(String firstName, String lastName, int age, boolean graduated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.graduated = graduated;
    }
}
