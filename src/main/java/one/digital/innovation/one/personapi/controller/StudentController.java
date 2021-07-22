package one.digital.innovation.one.personapi.controller;


import one.digital.innovation.one.personapi.dto.request.StudentDTO;
import one.digital.innovation.one.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.one.personapi.entity.Student;
import one.digital.innovation.one.personapi.service.StudentNotFoundException;
import one.digital.innovation.one.personapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createStudent(@RequestBody @Valid StudentDTO studentDTO){
            return studentService.createStudent(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> listAll(){
        return studentService.listAll();
    }

    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable Long id) throws StudentNotFoundException {
       return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid StudentDTO studentDTO) throws StudentNotFoundException{
        return studentService.updateById(id, studentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws StudentNotFoundException {
        studentService.delete(id);
    }
}
