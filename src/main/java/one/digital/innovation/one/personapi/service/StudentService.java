package one.digital.innovation.one.personapi.service;

import lombok.AllArgsConstructor;
import one.digital.innovation.one.personapi.dto.request.StudentDTO;
import one.digital.innovation.one.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.one.personapi.entity.Student;
import one.digital.innovation.one.personapi.mapper.StudentMapper;
import one.digital.innovation.one.personapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {

    private StudentRepository studentRepository;

    private StudentMapper studentMapper = StudentMapper.INSTANCE;

    @PostMapping
    public MessageResponseDTO createStudent(StudentDTO studentDTO){
      Student studentToSave = studentMapper.toModel(studentDTO);
        Student savedStudent = studentRepository.save(studentToSave);
        return createMessageResponse(savedStudent);
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
       Student student = checkIfExists(id);
       return studentMapper.toDTO(student);
    }

    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid StudentDTO studentDTO) throws StudentNotFoundException {
            checkIfExists(id);
            Student studentToUptade = studentMapper.toModel(studentDTO);
            Student updatedStudent = studentRepository.save(studentToUptade);
            return createMessageResponse(updatedStudent);
    }

    public void delete(Long id) throws StudentNotFoundException {
        checkIfExists(id);
        studentRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(Student message) {
        return MessageResponseDTO
                .builder()
                .message("Saved student with ID:" + message.getId())
                .build();
    }

    private Student checkIfExists(@PathVariable Long id) throws StudentNotFoundException {
        return studentRepository
                .findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }
}
