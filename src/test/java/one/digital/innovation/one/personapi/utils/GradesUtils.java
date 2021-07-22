package one.digital.innovation.one.personapi.utils;

import one.digital.innovation.one.personapi.dto.request.GradesDTO;
import one.digital.innovation.one.personapi.entity.Grades;
import one.digital.innovation.one.personapi.enums.GradesType;

public class GradesUtils {

    private static final String GRADES = "9,52";
    private static final String GRADES_SOURCE = "Avaliacao final";
    private static final String REMINDERS = "Colou na prova";
    private static final GradesType GRADES_TYPE = GradesType.GEO;
    private static final long GRADES_ID = 1L;

    public static GradesDTO createFakeDTO() {
        return GradesDTO.builder()
                .grades(GRADES)
                .gradesType(GRADES_TYPE)
                .gradesSource(GRADES_SOURCE)
                .reminders(REMINDERS)
                .build();
    }

    public static Grades createFakeEntity() {
        return Grades.builder()
                .id(GRADES_ID)
                .grades(GRADES)
                .gradesType(GRADES_TYPE)
                .gradesSource(GRADES_SOURCE)
                .reminders(REMINDERS)
                .build();
    }
}