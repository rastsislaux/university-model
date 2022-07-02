package engineer.leepsky.universitymodel.service;


import engineer.leepsky.universitymodel.model.Subject;
import engineer.leepsky.universitymodel.repository.SubjectRepository;
import engineer.leepsky.universitymodel.service.SubjectServiceImpl;
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

@DisplayName("Subject Service")
@ExtendWith(MockitoExtension.class)
class SubjectServiceTest {

    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectServiceImpl subjectService;

    @Test
    @DisplayName("Create a subject with taken ID")
    void testCreateWithTakenId() {
        when(subjectRepository.existsById(anyInt())).thenReturn(true);
        assertFalse(subjectService.create(new Subject(1, "subject")));
    }

    @Test
    @DisplayName("Create a subject with free ID")
    void testCreateWithFreeId() {
        when(subjectRepository.existsById(anyInt())).thenReturn(false);
        assertTrue(subjectService.create(new Subject(1, "subject")));
    }

    @Test
    @DisplayName("Read all subjects")
    void testReadAll() {
        List<Subject> subjects = List.of(
                new Subject(1, "subject1"),
                new Subject(2, "subject2"),
                new Subject(3, "subject3"));

        when(subjectRepository.findAll()).thenReturn(subjects);

        assertEquals(subjects, subjectService.readAll());
    }

    @Test
    @DisplayName("Read one existing subject")
    void testRead() {
        Subject subject = new Subject(1, "subject");

        when(subjectRepository.findById(anyInt())).thenReturn(Optional.of(
                subject
        ));

        assertEquals(subject, subjectService.read(1));
    }

    @Test
    @DisplayName("Read one non-existent subject")
    void testReadNonExistent() {
        when(subjectRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertNull(subjectService.read(1));
    }

    @Test
    @DisplayName("Update existing subject")
    void testUpdate() {
        when(subjectRepository.existsById(anyInt())).thenReturn(true);

        assertTrue(subjectService.update(1, new Subject(1, "subject")));
    }

    @Test
    @DisplayName("Update non-existent subject")
    void testUpdateNonExistent() {
        when(subjectRepository.existsById(anyInt())).thenReturn(false);

        assertFalse(subjectService.update(1, new Subject(1, "subject")));
    }

    @Test
    @DisplayName("Delete existing subject")
    void testDelete() {
        when(subjectRepository.existsById(anyInt())).thenReturn(true);

        assertTrue(subjectService.delete(1));
    }

    @Test
    @DisplayName("Delete non-existent subject")
    void testDeleteNonExistent() {
        when(subjectRepository.existsById(anyInt())).thenReturn(false);

        assertFalse(subjectService.delete(1));
    }

}
