package engineer.leepsky.universitymodel.repository;

import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.model.Student;
import engineer.leepsky.universitymodel.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Student Repository")
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("Get all lessons of a student")
    void getStudentLessonsTest() {
        this.entityManager.persist(new Student(111777, "Test Student", 1919));

        Lesson testLesson = new Lesson(1, 1, 1, "test room", 1919,
                Date.valueOf("2022-09-09"));
        Lesson testLesson2 = new Lesson(2, 2, 2, "test room2", 1919,
                Date.valueOf("2022-09-10"));
        Lesson testLesson3 = new Lesson(3, 3, 3, "test room3", 1920,
                Date.valueOf("2022-09-09"));

        this.entityManager.persist(testLesson);
        this.entityManager.persist(testLesson2);
        this.entityManager.persist(testLesson3);

        assertEquals(List.of(testLesson, testLesson2), studentRepository.getStudentLessons(111777));
    }

    @Test
    @DisplayName("Get all lessons of a student on a certain date")
    void getStudentLessonsByDateTest() {
        this.entityManager.persist(new Student(111777, "Test Student", 1919));

        Lesson testLesson = new Lesson(1, 1, 1, "test room", 1919,
                Date.valueOf("2022-09-09"));
        Lesson testLesson2 = new Lesson(2, 2, 2, "test room2", 1919,
                Date.valueOf("2022-09-10"));
        Lesson testLesson3 = new Lesson(3, 3, 3, "test room3", 1920,
                Date.valueOf("2022-09-09"));

        this.entityManager.persist(testLesson);
        this.entityManager.persist(testLesson2);
        this.entityManager.persist(testLesson3);

        assertEquals(List.of(testLesson), studentRepository.getStudentLessonsByDate(111777,
                Date.valueOf("2022-09-09")));
    }

}
