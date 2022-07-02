package engineer.leepsky.universitymodel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import engineer.leepsky.universitymodel.model.Room;
import engineer.leepsky.universitymodel.service.RoomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
@DisplayName("Room Controller")
class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Create a room with a new ID")
    void testCreate() throws Exception {
        when(roomService.create(any())).thenReturn(true);

        mockMvc.perform(
                    post("/rooms")
                            .content(objectMapper.writeValueAsString(new Room()))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Create a room with taken ID")
    void testCreateFail() throws Exception {
        when(roomService.create(any())).thenReturn(false);

        mockMvc.perform(
                    post("/rooms")
                            .content(objectMapper.writeValueAsString(new Room()))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Read all rooms")
    void testReadAll() throws Exception {
        List<Room> rooms = List.of(new Room());

        when(roomService.readAll()).thenReturn(rooms);

        mockMvc.perform(get("/rooms"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(rooms)));
    }

    @Test
    @DisplayName("Read all rooms when no is present")
    void testReadAllFail() throws Exception {
        List<Room> rooms = Collections.emptyList();

        when(roomService.readAll()).thenReturn(rooms);

        mockMvc.perform(get("/rooms"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Read one room")
    void testRead() throws Exception {
        Room room = new Room();

        when(roomService.read(any())).thenReturn(room);

        mockMvc.perform(get("/rooms/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(room)));
    }

    @Test
    @DisplayName("Read non-existent room")
    void testReadFail() throws Exception {
        when(roomService.read(any())).thenReturn(null);

        mockMvc.perform(get("/rooms/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Update room")
    void testUpdate() throws Exception {
        when(roomService.update(any(), any())).thenReturn(true);

        mockMvc.perform(
                put("/rooms/1")
                        .content(objectMapper.writeValueAsString(new Room()))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Update non-existent room")
    void testUpdateFail() throws Exception {
        when(roomService.update(any(), any())).thenReturn(false);

        mockMvc.perform(
                put("/rooms/1")
                        .content(objectMapper.writeValueAsString(new Room()))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Delete room")
    void testDelete() throws Exception {
        when(roomService.delete(any())).thenReturn(true);

        mockMvc.perform(delete("/rooms/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete non-existent room")
    void testDeleteFail() throws Exception {
        when(roomService.delete(any())).thenReturn(false);

        mockMvc.perform(delete("/rooms/1"))
                .andExpect(status().isNotModified());
    }



}
