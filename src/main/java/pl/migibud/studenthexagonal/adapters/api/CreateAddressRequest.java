package pl.migibud.studenthexagonal.adapters.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.migibud.studenthexagonal.domain.model.Address;
import pl.migibud.studenthexagonal.domain.model.Student;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CreateAddressRequest {
    private String street;
    private String number;
    private String city;
    private String zipCode;
    private Long studentId;

    Address toAddress() {
        return new Address(
                street,
                number,
                city,
                zipCode
        );
    }
}
