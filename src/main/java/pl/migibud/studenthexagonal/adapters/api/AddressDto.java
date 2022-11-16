package pl.migibud.studenthexagonal.adapters.api;

import lombok.*;
import pl.migibud.studenthexagonal.domain.model.Address;
import pl.migibud.studenthexagonal.domain.model.Student;

@NoArgsConstructor
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
class AddressDto {
    private Long id;
    private String street;
    private String number;
    private String city;
    private String zipCode;
    private Long studentId;

    static AddressDto of(Address address){
        return new AddressDto(
                address.getId(),
                address.getStreet(),
                address.getNumber(),
                address.getCity(),
                address.getZipCode(),
                address.getStudent().getId()
        );
    }
}
