package engineer.leepsky.universitymodel.repository;

import engineer.leepsky.universitymodel.model.Subject;
import engineer.leepsky.universitymodel.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
