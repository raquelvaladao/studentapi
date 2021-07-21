package one.digital.innovation.one.personapi.service;

import one.digital.innovation.one.personapi.dto.MessageResponseDTO;
import one.digital.innovation.one.personapi.entity.Student;
import one.digital.innovation.one.personapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public MessageResponseDTO createStudent(@RequestBody Student student){
        Student savedStudent = studentRepository.save(student);
        return MessageResponseDTO
                .builder()
                .message("Saved student with ID:" + savedStudent.getId())
                .build();
    }
}
