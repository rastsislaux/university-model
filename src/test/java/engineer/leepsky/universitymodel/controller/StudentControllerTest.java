package engineer.leepsky.universitymodel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import engineer.leepsky.universitymodel.model.Student;
import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
@DisplayName("Student Controller")
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Get lessons")
    void testReadLessons() throws Exception {

        List<Lesson> lessons = List.of(new Lesson(1, 1, 1, "test room", 1919,
                        Date.valueOf("2022-09-09")),
                new Lesson(2, 2, 2, "test room2", 1919,
                        Date.valueOf("2022-09-09")),
                new Lesson(3, 3, 3, "test room3", 1919,
                        Date.valueOf("2022-09-09")));

        when (studentService.readLessons(any())).thenReturn(lessons);

        mockMvc.perform(get("/students/1919/schedule"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(lessons)));
    }

    @Test
    @DisplayName("Get lessons on date")
    void testReadLessonsOnDate() throws Exception {

        List<Lesson> lessons = List.of(new Lesson(1, 1, 1, "test room", 1919,
                        Date.valueOf("2022-09-09")),
                new Lesson(2, 2, 2, "test room2", 1919,
                        Date.valueOf("2022-09-09")),
                new Lesson(3, 3, 3, "test room3", 1919,
                        Date.valueOf("2022-09-09")));

        when (studentService.readLessonsOnDate(any(), any())).thenReturn(lessons);

        mockMvc.perform(get("/students/1919/schedule/2022-09-09"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(lessons)));
    }

    @Test
    @DisplayName("Create a student with a new ID")
    void testCreate() throws Exception {
        when(studentService.create(any())).thenReturn(true);

        mockMvc.perform(
                    post("/students")
                            .content(objectMapper.writeValueAsString(new Student()))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Create a student with taken ID")
    void testCreateFail() throws Exception {
        when(studentService.create(any())).thenReturn(false);

        mockMvc.perform(
                    post("/students")
                            .content(objectMapper.writeValueAsString(new Student()))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Read all students")
    void testReadAll() throws Exception {
        List<Student> students = List.of(new Student());

        when(studentService.readAll()).thenReturn(students);

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(students)));
    }

    @Test
    @DisplayName("Read all students when no is present")
    void testReadAllFail() throws Exception {
        List<Student> students = Collections.emptyList();

        when(studentService.readAll()).thenReturn(students);

        mockMvc.perform(get("/students"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Read one student")
    void testRead() throws Exception {
        Student student = new Student();

        when(studentService.read(any())).thenReturn(student);

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(student)));
    }

    @Test
    @DisplayName("Read non-existent student")
    void testReadFail() throws Exception {
        when(studentService.read(any())).thenReturn(null);

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Update student")
    void testUpdate() throws Exception {
        when(studentService.update(any(), any())).thenReturn(true);

        mockMvc.perform(
                put("/students/1")
                        .content(objectMapper.writeValueAsString(new Student()))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Update non-existent student")
    void testUpdateFail() throws Exception {
        when(studentService.update(any(), any())).thenReturn(false);

        mockMvc.perform(
                put("/students/1")
                        .content(objectMapper.writeValueAsString(new Student()))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Delete student")
    void testDelete() throws Exception {
        when(studentService.delete(any())).thenReturn(true);

        mockMvc.perform(delete("/students/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete non-existent student")
    void testDeleteFail() throws Exception {
        when(studentService.delete(any())).thenReturn(false);

        mockMvc.perform(delete("/students/1"))
                .andExpect(status().isNotModified());
    }



}
