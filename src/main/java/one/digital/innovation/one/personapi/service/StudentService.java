package one.digital.innovation.one.personapi.service;

import one.digital.innovation.one.personapi.dto.request.StudentDTO;
import one.digital.innovation.one.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.one.personapi.entity.Student;
import one.digital.innovation.one.personapi.mapper.StudentMapper;
import one.digital.innovation.one.personapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private StudentMapper studentMapper = StudentMapper.INSTANCE;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public MessageResponseDTO createStudent(StudentDTO studentDTO){
      Student studentToSave = studentMapper.toModel(studentDTO);
        Student savedStudent = studentRepository.save(studentToSave);
        return MessageResponseDTO
                .builder()
                .message("Saved student with ID:" + savedStudent.getId())
                .build();
    }
}
