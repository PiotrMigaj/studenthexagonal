package pl.migibud.studenthexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.migibud.studenthexagonal.domain.model.Address;
import pl.migibud.studenthexagonal.domain.ports.AddressRepository;
import pl.migibud.studenthexagonal.domain.ports.AddressService;
import pl.migibud.studenthexagonal.domain.ports.StudentRepository;
import pl.migibud.studenthexagonal.domain.ports.StudentService;

@Configuration
class AddressConfig {

    @Bean
    AddressService addressService(AddressRepository addressRepository,StudentRepository studentRepository){
        return new AddressService(addressRepository,studentRepository);
    }
}
