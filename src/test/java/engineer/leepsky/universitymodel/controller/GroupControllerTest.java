package engineer.leepsky.universitymodel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import engineer.leepsky.universitymodel.model.Group;
import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.service.GroupService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GroupController.class)
@DisplayName("Group Controller")
class GroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroupService groupService;

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

        when (groupService.getLessons(any())).thenReturn(lessons);

        mockMvc.perform(get("/groups/1919/schedule"))
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

        when (groupService.getLessonsOnDate(any(), any())).thenReturn(lessons);

        mockMvc.perform(get("/groups/1919/schedule/2022-09-09"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(lessons)));
    }

    @Test
    @DisplayName("Create a group with a new ID")
    void testCreate() throws Exception {
        when(groupService.create(any())).thenReturn(true);

        mockMvc.perform(
                    post("/groups")
                            .content(objectMapper.writeValueAsString(new Group(1, 1)))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Create a group with taken ID")
    void testCreateFail() throws Exception {
        when(groupService.create(any())).thenReturn(false);

        mockMvc.perform(
                    post("/groups")
                            .content(objectMapper.writeValueAsString(new Group(1, 1)))
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotModified());
    }

    @Test
    @DisplayName("Read all groups")
    void testReadAll() throws Exception {
        List<Group> groups = List.of(new Group(1, 1));

        when(groupService.readAll()).thenReturn(groups);

        mockMvc.perform(get("/groups"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(groups)));
    }

    @Test
    @DisplayName("Read all groups when no is present")
    void testReadAllFail() throws Exception {
        List<Group> groups = Collections.emptyList();

        when(groupService.readAll()).thenReturn(groups);

        mockMvc.perform(get("/groups"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Read one group")
    void testRead() throws Exception {
        Group group = new Group(1, 1);

        when(groupService.read(any())).thenReturn(group);

        mockMvc.perform(get("/groups/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(group)));
    }



}
