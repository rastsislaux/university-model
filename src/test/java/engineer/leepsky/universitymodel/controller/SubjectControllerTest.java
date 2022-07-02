package engineer.leepsky.universitymodel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import engineer.leepsky.universitymodel.model.Subject;
import engineer.leepsky.universitymodel.service.SubjectService;
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

@WebMvcTest(SubjectController.class)
@DisplayName("Subject Controller")
class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Create a subject with a new ID")
    void testCreate() throws Exception {
        when(subjectService.create(any())).thenReturn(true);

        mockMvc.perform(
                    post("/subjects")
                            .content(objectMapper.writeValueAsString(new Subject()))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Create a subject with taken ID")
    void testCreateFail() throws Exception {
        when(subjectService.create(any())).thenReturn(false);

        mockMvc.perform(
                    post("/subjects")
                            .content(objectMapper.writeValueAsString(new Subject()))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Read all subjects")
    void testReadAll() throws Exception {
        List<Subject> subjects = List.of(new Subject());

        when(subjectService.readAll()).thenReturn(subjects);

        mockMvc.perform(get("/subjects"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(subjects)));
    }

    @Test
    @DisplayName("Read all subjects when no is present")
    void testReadAllFail() throws Exception {
        List<Subject> subjects = Collections.emptyList();

        when(subjectService.readAll()).thenReturn(subjects);

        mockMvc.perform(get("/subjects"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Read one subject")
    void testRead() throws Exception {
        Subject subject = new Subject();

        when(subjectService.read(any())).thenReturn(subject);

        mockMvc.perform(get("/subjects/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(subject)));
    }

    @Test
    @DisplayName("Read non-existent subject")
    void testReadFail() throws Exception {
        when(subjectService.read(any())).thenReturn(null);

        mockMvc.perform(get("/subjects/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Update subject")
    void testUpdate() throws Exception {
        when(subjectService.update(any(), any())).thenReturn(true);

        mockMvc.perform(
                put("/subjects/1")
                        .content(objectMapper.writeValueAsString(new Subject()))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Update non-existent subject")
    void testUpdateFail() throws Exception {
        when(subjectService.update(any(), any())).thenReturn(false);

        mockMvc.perform(
                put("/subjects/1")
                        .content(objectMapper.writeValueAsString(new Subject()))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Delete subject")
    void testDelete() throws Exception {
        when(subjectService.delete(any())).thenReturn(true);

        mockMvc.perform(delete("/subjects/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete non-existent subject")
    void testDeleteFail() throws Exception {
        when(subjectService.delete(any())).thenReturn(false);

        mockMvc.perform(delete("/subjects/1"))
                .andExpect(status().isNotModified());
    }



}
