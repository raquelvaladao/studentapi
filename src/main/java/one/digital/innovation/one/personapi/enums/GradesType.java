package one.digital.innovation.one.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GradesType {
     MATH("Matematica"),
     PORT("Portugues"),
     SCI("Ciencias"),
     GEO("Geografia");

    private final String description;
}
