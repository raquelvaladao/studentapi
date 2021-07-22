package one.digital.innovation.one.personapi.service;

import one.digital.innovation.one.personapi.dto.request.StudentDTO;
import one.digital.innovation.one.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.one.personapi.entity.Student;
import one.digital.innovation.one.personapi.mapper.StudentMapper;
import one.digital.innovation.one.personapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<StudentDTO> listAll(){
        List<Student> allStudents = studentRepository.findAll();
        return allStudents
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable Long id) throws StudentNotFoundException {
       Student student = studentRepository
               .findById(id)
               .orElseThrow(() -> new StudentNotFoundException(id));
       return studentMapper.toDTO(student);
    }
}
