package engineer.leepsky.universitymodel.service;


import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.model.Student;
import engineer.leepsky.universitymodel.repository.StudentRepository;
import engineer.leepsky.universitymodel.service.StudentServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@DisplayName("Student Service")
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    @DisplayName("Create a student with taken ID")
    void testCreateWithTakenId() {
        when(studentRepository.existsById(anyInt())).thenReturn(true);
        assertFalse(studentService.create(new Student(1, "Name", 1212)));
    }

    @Test
    @DisplayName("Create a student with free ID")
    void testCreateWithFreeId() {
        when(studentRepository.existsById(anyInt())).thenReturn(false);
        assertTrue(studentService.create(new Student(1, "Name", 1212)));
    }

    @Test
    @DisplayName("Read all students")
    void testReadAll() {
        List<Student> students = List.of(
                new Student(1, "Name1", 1212),
                new Student(2, "Name2", 1213),
                new Student(3, "Name3", 1214));

        when(studentRepository.findAll()).thenReturn(students);

        assertEquals(students, studentService.readAll());
    }

    @Test
    @DisplayName("Read one existing student")
    void testRead() {
        Student student = new Student(1, "Name", 1212);

        when(studentRepository.findById(anyInt())).thenReturn(Optional.of(
                student
        ));

        assertEquals(student, studentService.read(1));
    }

    @Test
    @DisplayName("Read one non-existent student")
    void testReadNonExistent() {
        when(studentRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertNull(studentService.read(1));
    }

    @Test
    @DisplayName("Update existing student")
    void testUpdate() {
        when(studentRepository.existsById(anyInt())).thenReturn(true);

        assertTrue(studentService.update(1, new Student(1, "Name", 1212)));
    }

    @Test
    @DisplayName("Update non-existent student")
    void testUpdateNonExistent() {
        when(studentRepository.existsById(anyInt())).thenReturn(false);

        assertFalse(studentService.update(1, new Student(1, "Name", 1212)));
    }

    @Test
    @DisplayName("Delete existing student")
    void testDelete() {
        when(studentRepository.existsById(anyInt())).thenReturn(true);

        assertTrue(studentService.delete(1));
    }

    @Test
    @DisplayName("Delete non-existent student")
    void testDeleteNonExistent() {
        when(studentRepository.existsById(anyInt())).thenReturn(false);

        assertFalse(studentService.delete(1));
    }

    @Test
    @DisplayName("Get lessons")
    void testGetLessons() {
        List<Lesson> lessons = List.of(
                new Lesson(1, 1, 1, "test room", 1919,
                        Date.valueOf("2022-09-09")),
                new Lesson(2, 2, 2, "test room2", 1919,
                        Date.valueOf("2022-09-10")),
                new Lesson(3, 3, 3, "test room3", 1919,
                        Date.valueOf("2022-09-09")));

        when(studentRepository.getStudentLessons(anyInt())).thenReturn(lessons);

        assertEquals(lessons, studentService.readLessons(1));
    }

    @Test
    @DisplayName("Get lessons")
    void testGetLessonsOnDate() {
        List<Lesson> lessons = List.of(
                new Lesson(1, 1, 1, "test room", 1919,
                        Date.valueOf("2022-09-09")),
                new Lesson(3, 3, 3, "test room3", 1919,
                        Date.valueOf("2022-09-09")));

        when(studentRepository.getStudentLessonsByDate(anyInt(), any())).thenReturn(lessons);

        assertEquals(lessons, studentService.readLessonsOnDate(1, Date.valueOf("2022-09-09")));
    }

}
