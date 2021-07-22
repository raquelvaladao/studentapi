package one.digital.innovation.one.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.one.personapi.entity.Grades;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long id;
    @NotEmpty
    @Size(min = 5, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String lastName;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

    @Valid
    @NotEmpty
    private List<Grades> grades;
}
