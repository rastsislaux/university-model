package engineer.leepsky.universitymodel.service;


import engineer.leepsky.universitymodel.model.Group;
import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.repository.GroupRepository;
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

@DisplayName("Group Service")
@ExtendWith(MockitoExtension.class)
class GroupServiceTest {

    @Mock
    private GroupRepository groupRepository;

    @InjectMocks
    private GroupServiceImpl groupService;

    @Test
    @DisplayName("Create a group with taken ID")
    void testCreateWithTakenId() {
        when(groupRepository.existsById(anyInt())).thenReturn(true);
        assertFalse(groupService.create(new Group(1212, 1)));
    }

    @Test
    @DisplayName("Create a group with free ID")
    void testCreateWithFreeId() {
        when(groupRepository.existsById(anyInt())).thenReturn(false);
        assertTrue(groupService.create(new Group(1213, 1)));
    }

    @Test
    @DisplayName("Read all groups")
    void testReadAll() {
        List<Group> groups = List.of(new Group(1, 1),
                new Group(2, 2),
                new Group(3, 3));

        when(groupRepository.findAll()).thenReturn(groups);

        assertEquals(groups, groupService.readAll());
    }

    @Test
    @DisplayName("Read one existing group")
    void testRead() {
        Group group = new Group(123, 1);

        when(groupRepository.findById(anyInt())).thenReturn(Optional.of(
                group
        ));

        assertEquals(group, groupService.read(123));
    }

    @Test
    @DisplayName("Read one non-existent group")
    void testReadNonExistent() {
        when(groupRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertNull(groupService.read(124));
    }

    @Test
    @DisplayName("Update existing group")
    void testUpdate() {
        when(groupRepository.existsById(anyInt())).thenReturn(true);

        assertTrue(groupService.update(1, new Group(1, 1)));
    }

    @Test
    @DisplayName("Update non-existent group")
    void testUpdateNonExistent() {
        when(groupRepository.existsById(anyInt())).thenReturn(false);

        assertFalse(groupService.update(1, new Group(1, 1)));
    }

    @Test
    @DisplayName("Delete existing group")
    void testDelete() {
        when(groupRepository.existsById(anyInt())).thenReturn(true);

        assertTrue(groupService.delete(1));
    }

    @Test
    @DisplayName("Delete non-existent group")
    void testDeleteNonExistent() {
        when(groupRepository.existsById(anyInt())).thenReturn(false);

        assertFalse(groupService.delete(1));
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

        when(groupRepository.readLessons(anyInt())).thenReturn(lessons);

        assertEquals(lessons, groupService.readLessons(1919));
    }

    @Test
    @DisplayName("Get lessons")
    void testGetLessonsOnDate() {
        List<Lesson> lessons = List.of(
                new Lesson(1, 1, 1, "test room", 1919,
                        Date.valueOf("2022-09-09")),
                new Lesson(3, 3, 3, "test room3", 1919,
                        Date.valueOf("2022-09-09")));

        when(groupRepository.readLessonsOnDate(anyInt(), any())).thenReturn(lessons);

        assertEquals(lessons, groupService.readLessonsOnDate(1919, Date.valueOf("2022-09-09")));
    }

}
