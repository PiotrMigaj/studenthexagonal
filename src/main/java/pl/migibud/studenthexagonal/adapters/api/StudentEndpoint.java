package pl.migibud.studenthexagonal.adapters.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@Slf4j
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
class StudentEndpoint {

    private final StudentFacade studentFacade;

    @PostMapping
    ResponseEntity<StudentDto> createStudent(@RequestBody CreateStudentRequest request){
        log.info("Got request with: {}",request);
        StudentDto studentDto = studentFacade.createStudent(request);
        log.info("StudentDto: {}",studentDto);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping("/{id}")
    ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        StudentDto studentDto = studentFacade.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }
}
