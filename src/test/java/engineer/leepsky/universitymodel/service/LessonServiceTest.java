package engineer.leepsky.universitymodel.service;


import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.repository.LessonRepository;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@DisplayName("Lesson Service")
@ExtendWith(MockitoExtension.class)
class LessonServiceTest {

    @Mock
    private LessonRepository lessonRepository;

    @InjectMocks
    private LessonServiceImpl lessonService;

    @Test
    @DisplayName("Create a student with taken ID")
    void testCreateWithTakenId() {
        when(lessonRepository.existsById(anyInt())).thenReturn(true);
        assertFalse(lessonService.create(new Lesson(1, 1, 1, "", 1, new Date(1))));
    }

    @Test
    @DisplayName("Create a student with free ID")
    void testCreateWithFreeId() {
        when(lessonRepository.existsById(anyInt())).thenReturn(false);
        assertTrue(lessonService.create(new Lesson(1, 1, 1, "", 1, new Date(1))));
    }

    @Test
    @DisplayName("Read all lessons")
    void testReadAll() {
        List<Lesson> lessons = List.of(
                new Lesson(1, 1, 1, "test room", 1919,
                        Date.valueOf("2022-09-09")),
                new Lesson(2, 2, 2, "test room2", 1919,
                        Date.valueOf("2022-09-10")),
                new Lesson(3, 3, 3, "test room3", 1919,
                        Date.valueOf("2022-09-09")));

        when(lessonRepository.findAll()).thenReturn(lessons);

        assertEquals(lessons, lessonService.readAll());
    }

    @Test
    @DisplayName("Read one existing lesson")
    void testRead() {
        Lesson lesson = new Lesson(1, 1, 1, "test room", 1919,
                Date.valueOf("2022-09-09"));

        when(lessonRepository.findById(anyInt())).thenReturn(Optional.of(
                lesson
        ));

        assertEquals(lesson, lessonService.read(1));
    }

    @Test
    @DisplayName("Read one non-existent lesson")
    void testReadNonExistent() {
        when(lessonRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertNull(lessonService.read(124));
    }

    @Test
    @DisplayName("Update existing lesson")
    void testUpdate() {
        when(lessonRepository.existsById(anyInt())).thenReturn(true);

        assertTrue(lessonService.update(1, new Lesson(1, 1, 1, "test room", 1919,
                Date.valueOf("2022-09-09"))));
    }

    @Test
    @DisplayName("Update non-existent lesson")
    void testUpdateNonExistent() {
        when(lessonRepository.existsById(anyInt())).thenReturn(false);

        assertFalse(lessonService.update(1, new Lesson(1, 1, 1, "test room", 1919,
                Date.valueOf("2022-09-09"))));
    }

    @Test
    @DisplayName("Delete existing lesson")
    void testDelete() {
        when(lessonRepository.existsById(anyInt())).thenReturn(true);

        assertTrue(lessonService.delete(1));
    }

    @Test
    @DisplayName("Delete non-existent lesson")
    void testDeleteNonExistent() {
        when(lessonRepository.existsById(anyInt())).thenReturn(false);

        assertFalse(lessonService.delete(1));
    }

}
