package engineer.leepsky.universitymodel.repository;

import engineer.leepsky.universitymodel.model.Room;
import engineer.leepsky.universitymodel.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
