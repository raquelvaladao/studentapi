package one.digital.innovation.one.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.one.personapi.enums.GradesType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradesDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private GradesType gradesType;

    @NotEmpty
    @Size(min = 5, max = 10)
    private String grades;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String gradesSource;

    @Size(min = 2, max = 100)
    private String reminders;

}
