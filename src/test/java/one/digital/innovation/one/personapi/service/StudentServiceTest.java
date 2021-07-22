package one.digital.innovation.one.personapi.service;

import one.digital.innovation.one.personapi.dto.request.StudentDTO;
import one.digital.innovation.one.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.one.personapi.entity.Student;
import one.digital.innovation.one.personapi.mapper.StudentMapper;
import one.digital.innovation.one.personapi.repository.StudentRepository;
import one.digital.innovation.one.personapi.utils.StudentUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digital.innovation.one.personapi.utils.StudentUtils.createFakeDTO;
import static one.digital.innovation.one.personapi.utils.StudentUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentService studentService;

    @Test
        void testGivenStudentDTOThenReturnSuccessSavedMessage () {
            StudentDTO studentDTO = createFakeDTO();
            Student expectedSavedStudent = createFakeEntity();

            when(studentMapper.toModel(studentDTO)).thenReturn(expectedSavedStudent);
            when(studentRepository.save(any(Student.class))).thenReturn(expectedSavedStudent);

            MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedStudent.getId());
            MessageResponseDTO successMessage = studentService.createStudent(studentDTO);

            assertEquals(expectedSuccessMessage, successMessage);
        }

        private MessageResponseDTO createExpectedSuccessMessage (Long savedStudentId){
            return MessageResponseDTO.builder()
                    .message("Saved student with ID:" + savedStudentId)
                    .build();
        }

    }