package one.digital.innovation.one.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.one.personapi.enums.GradesType;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradesDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private GradesType gradesType;

    private String grades;

    private String gradesSource;

    private String reminders;

}
