package one.digital.innovation.one.personapi.entity;

import lombok.*;
import one.digital.innovation.one.personapi.enums.GradesType;

import javax.persistence.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GradesType gradesType;

    @Column(nullable = false)
    private String grades;

    @Column(nullable = false)
    private String gradesSource;

    @Column(nullable = true)
    private String reminders;
}

