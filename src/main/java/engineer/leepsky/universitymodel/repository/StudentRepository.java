package engineer.leepsky.universitymodel.repository;

import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT l FROM Student s JOIN Lesson l ON l.groupId = s.groupId WHERE s.id = ?1")
    List<Lesson> getStudentLessons(int studentId);

    @Query(value = "SELECT l FROM Student s JOIN Lesson l ON l.groupId = s.groupId WHERE s.id = ?1 AND l.date = ?2")
    List<Lesson> getStudentLessonsByDate(int studentId, Date date);

}
