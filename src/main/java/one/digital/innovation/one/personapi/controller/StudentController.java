package one.digital.innovation.one.personapi.controller;


import one.digital.innovation.one.personapi.dto.MessageResponseDTO;
import one.digital.innovation.one.personapi.entity.Student;
import one.digital.innovation.one.personapi.repository.StudentRepository;
import one.digital.innovation.one.personapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentRepository studentRepository;
    private StudentService studentService;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public MessageResponseDTO createStudent(@RequestBody Student student){
            return studentService.createStudent(student);
    }

}
