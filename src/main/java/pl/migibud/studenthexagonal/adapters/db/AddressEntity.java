package pl.migibud.studenthexagonal.adapters.db;

import lombok.*;
import pl.migibud.studenthexagonal.domain.model.Address;

import javax.persistence.*;

@Entity
@Getter(value = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor
@ToString
class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String number;
    private String city;
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    private AddressEntity(String street, String number, String city, String zipCode, StudentEntity student) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.zipCode = zipCode;
        this.student = student;
    }

    static AddressEntity of(Address address){
        return new AddressEntity(
                address.getStreet(),
                address.getNumber(),
                address.getCity(),
                address.getZipCode(),
                StudentEntity.of(address.getStudent())
        );
    }

    Address toDomain() {
        return new Address(
                id,
                street,
                number,
                city,
                zipCode,
                student.toDomain()
        );
    }
}
