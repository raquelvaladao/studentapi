package one.digital.innovation.one.personapi.utils;

import one.digital.innovation.one.personapi.dto.request.StudentDTO;
import one.digital.innovation.one.personapi.entity.Student;

import java.util.Collections;

public class StudentUtils {

        private static final String FIRST_NAME = "Fernando";
        private static final String LAST_NAME = "da Silva";
        private static final String PHONE_NUMBER = "895.542.878-80";
        private static final long STUDENT_ID = 1L;

        public static StudentDTO createFakeDTO() {
            return StudentDTO.builder()
                    .firstName(FIRST_NAME)
                    .lastName(LAST_NAME)
                    .number(PHONE_NUMBER)
                    .grades(Collections.singletonList(GradesUtils.createFakeDTO()))
                    .build();
        }

        public static Student createFakeEntity() {
            return Student.builder()
                    .id(STUDENT_ID)
                    .firstName(FIRST_NAME)
                    .lastName(LAST_NAME)
                    .number(PHONE_NUMBER)
                    .grades(Collections.singletonList(GradesUtils.createFakeEntity()))
                    .build();
        }

    }