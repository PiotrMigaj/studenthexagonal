package pl.migibud.studenthexagonal.adapters.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
class AddressEndpoint {

    private final AddressFacade addressFacade;

    @PostMapping
    ResponseEntity<AddressDto> createAddress(@RequestBody CreateAddressRequest request){
        log.info("Got request with: {}",request);
        AddressDto addressDto = addressFacade.createAddress(request);
        log.info("StudentDto: {}",addressDto);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping("/{id}")
    ResponseEntity<AddressDto> getAddressById(@PathVariable Long id){
        AddressDto addressDto = addressFacade.getAddressById(id);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping("/student/{id}")
    ResponseEntity<AddressDto> getAddressByStudentId(@PathVariable Long id){
        AddressDto addressDto = addressFacade.getAddressByStudentId(id);
        return ResponseEntity.ok(addressDto);
    }
}
