package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Teacher;
import engineer.leepsky.universitymodel.repository.TeacherRepository;
import engineer.leepsky.universitymodel.service.TeacherServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@DisplayName("Teacher Service")
@ExtendWith(MockitoExtension.class)
class TeacherServiceTest {

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    @Test
    @DisplayName("Create a teacher with taken ID")
    void testCreateWithTakenId() {
        when(teacherRepository.existsById(anyInt())).thenReturn(true);
        assertFalse(teacherService.create(new Teacher(1, "teacher")));
    }

    @Test
    @DisplayName("Create a teacher with free ID")
    void testCreateWithFreeId() {
        when(teacherRepository.existsById(anyInt())).thenReturn(false);
        assertTrue(teacherService.create(new Teacher(1, "teacher")));
    }

    @Test
    @DisplayName("Read all teachers")
    void testReadAll() {
        List<Teacher> teachers = List.of(
                new Teacher(1, "teacher1"),
                new Teacher(2, "teacher2"),
                new Teacher(3, "teacher3"));

        when(teacherRepository.findAll()).thenReturn(teachers);

        assertEquals(teachers, teacherService.readAll());
    }

    @Test
    @DisplayName("Read one existing teacher")
    void testRead() {
        Teacher teacher = new Teacher(1, "teacher");

        when(teacherRepository.findById(anyInt())).thenReturn(Optional.of(
                teacher
        ));

        assertEquals(teacher, teacherService.read(1));
    }

    @Test
    @DisplayName("Read one non-existent teacher")
    void testReadNonExistent() {
        when(teacherRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertNull(teacherService.read(1));
    }

    @Test
    @DisplayName("Update existing teacher")
    void testUpdate() {
        when(teacherRepository.existsById(anyInt())).thenReturn(true);

        assertTrue(teacherService.update(1, new Teacher(1, "teacher")));
    }

    @Test
    @DisplayName("Update non-existent teacher")
    void testUpdateNonExistent() {
        when(teacherRepository.existsById(anyInt())).thenReturn(false);

        assertFalse(teacherService.update(1, new Teacher(1, "teacher")));
    }

    @Test
    @DisplayName("Delete existing teacher")
    void testDelete() {
        when(teacherRepository.existsById(anyInt())).thenReturn(true);

        assertTrue(teacherService.delete(1));
    }

    @Test
    @DisplayName("Delete non-existent teacher")
    void testDeleteNonExistent() {
        when(teacherRepository.existsById(anyInt())).thenReturn(false);

        assertFalse(teacherService.delete(1));
    }

}
