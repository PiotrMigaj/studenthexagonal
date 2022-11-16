package pl.migibud.studenthexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.migibud.studenthexagonal.domain.ports.StudentRepository;
import pl.migibud.studenthexagonal.domain.ports.StudentService;

@Configuration
class StudentConfig {

    @Bean
    StudentService studentService(StudentRepository studentRepository){
        return new StudentService(studentRepository);
    }
}
