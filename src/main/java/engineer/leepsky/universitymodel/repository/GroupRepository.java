package engineer.leepsky.universitymodel.repository;

import engineer.leepsky.universitymodel.model.Group;
import engineer.leepsky.universitymodel.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query(value = "SELECT l FROM Group g JOIN Lesson l ON l.groupId = g.id WHERE g.id = ?1")
    List<Lesson> getGroupLessons(Integer id);

    @Query(value = "SELECT l FROM Group g JOIN Lesson l ON l.groupId = g.id WHERE g.id = ?1 AND l.date = ?2")
    List<Lesson> getGroupLessonsByDate(Integer id, Date date);

}
