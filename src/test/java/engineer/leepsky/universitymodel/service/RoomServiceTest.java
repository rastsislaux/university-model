package engineer.leepsky.universitymodel.service;


import engineer.leepsky.universitymodel.model.Room;
import engineer.leepsky.universitymodel.repository.RoomRepository;
import engineer.leepsky.universitymodel.service.RoomServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@DisplayName("Room Service")
@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomServiceImpl roomService;

    @Test
    @DisplayName("Create a student with taken ID")
    void testCreateWithTakenId() {
        when(roomRepository.existsById(anyString())).thenReturn(true);
        assertFalse(roomService.create(new Room("room", 1)));
    }

    @Test
    @DisplayName("Create a student with free ID")
    void testCreateWithFreeId() {
        when(roomRepository.existsById(anyString())).thenReturn(false);
        assertTrue(roomService.create(new Room("room", 1)));
    }

    @Test
    @DisplayName("Read all rooms")
    void testReadAll() {
        List<Room> rooms = List.of(
                new Room("room1", 1),
                new Room("room2", 2),
                new Room("room3", 3));

        when(roomRepository.findAll()).thenReturn(rooms);

        assertEquals(rooms, roomService.readAll());
    }

    @Test
    @DisplayName("Read one existing room")
    void testRead() {
        Room room = new Room("room1", 1);

        when(roomRepository.findById(anyString())).thenReturn(Optional.of(
                room
        ));

        assertEquals(room, roomService.read("room1"));
    }

    @Test
    @DisplayName("Read one non-existent room")
    void testReadNonExistent() {
        when(roomRepository.findById(anyString())).thenReturn(Optional.empty());

        assertNull(roomService.read("no room"));
    }

    @Test
    @DisplayName("Update existing room")
    void testUpdate() {
        when(roomRepository.existsById(anyString())).thenReturn(true);

        assertTrue(roomService.update("room1", new Room("room1", 1)));
    }

    @Test
    @DisplayName("Update non-existent room")
    void testUpdateNonExistent() {
        when(roomRepository.existsById(anyString())).thenReturn(false);

        assertFalse(roomService.update("room1", new Room("room1", 1)));
    }

    @Test
    @DisplayName("Delete existing room")
    void testDelete() {
        when(roomRepository.existsById(anyString())).thenReturn(true);

        assertTrue(roomService.delete("room"));
    }

    @Test
    @DisplayName("Delete non-existent room")
    void testDeleteNonExistent() {
        when(roomRepository.existsById(anyString())).thenReturn(false);

        assertFalse(roomService.delete("room"));
    }

}
