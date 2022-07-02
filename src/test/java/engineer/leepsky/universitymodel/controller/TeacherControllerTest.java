package engineer.leepsky.universitymodel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import engineer.leepsky.universitymodel.model.Teacher;
import engineer.leepsky.universitymodel.service.TeacherService;
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

@WebMvcTest(TeacherController.class)
@DisplayName("Teacher Controller")
class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherService teacherService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Create a teacher with a new ID")
    void testCreate() throws Exception {
        when(teacherService.create(any())).thenReturn(true);

        mockMvc.perform(
                    post("/teachers")
                            .content(objectMapper.writeValueAsString(new Teacher()))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Create a teacher with taken ID")
    void testCreateFail() throws Exception {
        when(teacherService.create(any())).thenReturn(false);

        mockMvc.perform(
                    post("/teachers")
                            .content(objectMapper.writeValueAsString(new Teacher()))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Read all teachers")
    void testReadAll() throws Exception {
        List<Teacher> teachers = List.of(new Teacher());

        when(teacherService.readAll()).thenReturn(teachers);

        mockMvc.perform(get("/teachers"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(teachers)));
    }

    @Test
    @DisplayName("Read all teachers when no is present")
    void testReadAllFail() throws Exception {
        List<Teacher> teachers = Collections.emptyList();

        when(teacherService.readAll()).thenReturn(teachers);

        mockMvc.perform(get("/teachers"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Read one teacher")
    void testRead() throws Exception {
        Teacher teacher = new Teacher();

        when(teacherService.read(any())).thenReturn(teacher);

        mockMvc.perform(get("/teachers/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(teacher)));
    }

    @Test
    @DisplayName("Read non-existent teacher")
    void testReadFail() throws Exception {
        when(teacherService.read(any())).thenReturn(null);

        mockMvc.perform(get("/teachers/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Update teacher")
    void testUpdate() throws Exception {
        when(teacherService.update(any(), any())).thenReturn(true);

        mockMvc.perform(
                put("/teachers/1")
                        .content(objectMapper.writeValueAsString(new Teacher()))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Update non-existent teacher")
    void testUpdateFail() throws Exception {
        when(teacherService.update(any(), any())).thenReturn(false);

        mockMvc.perform(
                put("/teachers/1")
                        .content(objectMapper.writeValueAsString(new Teacher()))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Delete teacher")
    void testDelete() throws Exception {
        when(teacherService.delete(any())).thenReturn(true);

        mockMvc.perform(delete("/teachers/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete non-existent teacher")
    void testDeleteFail() throws Exception {
        when(teacherService.delete(any())).thenReturn(false);

        mockMvc.perform(delete("/teachers/1"))
                .andExpect(status().isNotModified());
    }



}
