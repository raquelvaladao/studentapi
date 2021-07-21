package one.digital.innovation.one.personapi.repository;

import one.digital.innovation.one.personapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
