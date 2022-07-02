package engineer.leepsky.universitymodel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.service.LessonService;
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

@WebMvcTest(LessonController.class)
@DisplayName("Lesson Controller")
class LessonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LessonService lessonService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Create a lesson with a new ID")
    void testCreate() throws Exception {
        when(lessonService.create(any())).thenReturn(true);

        mockMvc.perform(
                    post("/lessons")
                            .content(objectMapper.writeValueAsString(new Lesson()))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Create a lesson with taken ID")
    void testCreateFail() throws Exception {
        when(lessonService.create(any())).thenReturn(false);

        mockMvc.perform(
                    post("/lessons")
                            .content(objectMapper.writeValueAsString(new Lesson()))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Read all lessons")
    void testReadAll() throws Exception {
        List<Lesson> lessons = List.of(new Lesson());

        when(lessonService.readAll()).thenReturn(lessons);

        mockMvc.perform(get("/lessons"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(lessons)));
    }

    @Test
    @DisplayName("Read all lessons when no is present")
    void testReadAllFail() throws Exception {
        List<Lesson> lessons = Collections.emptyList();

        when(lessonService.readAll()).thenReturn(lessons);

        mockMvc.perform(get("/lessons"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Read one lesson")
    void testRead() throws Exception {
        Lesson lesson = new Lesson();

        when(lessonService.read(any())).thenReturn(lesson);

        mockMvc.perform(get("/lessons/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(lesson)));
    }

    @Test
    @DisplayName("Read non-existent lesson")
    void testReadFail() throws Exception {
        when(lessonService.read(any())).thenReturn(null);

        mockMvc.perform(get("/lessons/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Update lesson")
    void testUpdate() throws Exception {
        when(lessonService.update(any(), any())).thenReturn(true);

        mockMvc.perform(
                put("/lessons/1")
                        .content(objectMapper.writeValueAsString(new Lesson()))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Update non-existent lesson")
    void testUpdateFail() throws Exception {
        when(lessonService.update(any(), any())).thenReturn(false);

        mockMvc.perform(
                put("/lessons/1")
                        .content(objectMapper.writeValueAsString(new Lesson()))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Delete lesson")
    void testDelete() throws Exception {
        when(lessonService.delete(any())).thenReturn(true);

        mockMvc.perform(delete("/lessons/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete non-existent lesson")
    void testDeleteFail() throws Exception {
        when(lessonService.delete(any())).thenReturn(false);

        mockMvc.perform(delete("/lessons/1"))
                .andExpect(status().isNotModified());
    }



}
