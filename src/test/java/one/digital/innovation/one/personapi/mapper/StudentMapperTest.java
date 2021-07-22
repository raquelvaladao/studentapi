package one.digital.innovation.one.personapi.mapper;

import one.digital.innovation.one.personapi.dto.request.GradesDTO;
import one.digital.innovation.one.personapi.dto.request.StudentDTO;
import one.digital.innovation.one.personapi.entity.Grades;
import one.digital.innovation.one.personapi.entity.Student;
import one.digital.innovation.one.personapi.utils.GradesUtils;
import one.digital.innovation.one.personapi.utils.StudentUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
    public class StudentMapperTest {

        @Autowired
        private StudentMapper studentMapper;

        @Test
        void testGivenPersonDTOThenReturnStudentEntity() {
            StudentDTO studentDTO = StudentUtils.createFakeDTO();
            Student student = studentMapper.toModel(studentDTO);

            assertEquals(((StudentDTO) studentDTO).getFirstName(), student.getFirstName());
            assertEquals(studentDTO.getLastName(), student.getLastName());
            assertEquals(studentDTO.getNumber(), student.getNumber());

            Grades grades = student.getGrades().get(0);
            GradesDTO gradesDTO = studentDTO.getGrades().get(0);

            assertEquals(gradesDTO.getGradesType(), grades.getGradesType());
            assertEquals(gradesDTO.getGradesSource(), grades.getGradesSource());
            assertEquals(gradesDTO.getReminders(), grades.getReminders());
        }

        @Test
        void testGivenPersonEntityThenReturnStudentDTO() {
            Student student = StudentUtils.createFakeEntity();
            StudentDTO studentDTO = studentMapper.toDTO(student);

            assertEquals(student.getFirstName(), student.getFirstName());
            assertEquals(student.getLastName(), student.getLastName());
            assertEquals(student.getNumber(), student.getNumber());

            Grades grades = student.getGrades().get(0);
            GradesDTO gradesDTO = studentDTO.getGrades().get(0);

            assertEquals(grades.getGradesType(), studentDTO.getGrades());
            assertEquals(grades.getGrades(), studentDTO.getGrades());
            assertEquals(grades.getGradesSource(), studentDTO.getGrades());
            assertEquals(grades.getReminders(), studentDTO.getGrades());
        }
    }

