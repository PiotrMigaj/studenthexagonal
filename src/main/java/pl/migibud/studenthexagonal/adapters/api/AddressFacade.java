package pl.migibud.studenthexagonal.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.migibud.studenthexagonal.domain.model.Address;
import pl.migibud.studenthexagonal.domain.model.Student;
import pl.migibud.studenthexagonal.domain.ports.AddressService;

@Component
@RequiredArgsConstructor
class AddressFacade {

    private final AddressService addressService;

    AddressDto getAddressById(Long id){
        Address address = addressService.getById(id);
        return AddressDto.of(address);
    }

    AddressDto getAddressByStudentId(Long studentId){
        Address address = addressService.getByStudentId(studentId);
        return AddressDto.of(address);
    }

    AddressDto createAddress(CreateAddressRequest request){
        Address address = addressService.create(request.toAddress(), request.getStudentId());
        return AddressDto.of(address);
    }

}
