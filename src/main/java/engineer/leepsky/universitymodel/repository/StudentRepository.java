package engineer.leepsky.universitymodel.repository;

import engineer.leepsky.universitymodel.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> { }
