package engineer.leepsky.universitymodel;

import engineer.leepsky.universitymodel.controller.*;
import engineer.leepsky.universitymodel.repository.*;
import engineer.leepsky.universitymodel.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UniversityModelApplicationTests {

    @Autowired
    private GroupController groupController;

    @Autowired
    private LessonController lessonController;

    @Autowired
    private RoomController roomController;

    @Autowired
    private StudentController studentController;

    @Autowired
    private SubjectController subjectController;

    @Autowired
    private TeacherController teacherController;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private GroupService groupService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TeacherService teacherService;

    @Test
    @DisplayName("Context loads")
    void contextLoads() {
        assertNotNull(groupController);
        assertNotNull(lessonController);
        assertNotNull(roomController);
        assertNotNull(studentController);
        assertNotNull(subjectController);
        assertNotNull(teacherController);

        assertNotNull(groupRepository);
        assertNotNull(lessonRepository);
        assertNotNull(roomRepository);
        assertNotNull(studentRepository);
        assertNotNull(subjectRepository);
        assertNotNull(teacherRepository);

        assertNotNull(groupService);
        assertNotNull(lessonService);
        assertNotNull(roomService);
        assertNotNull(studentService);
        assertNotNull(subjectService);
        assertNotNull(teacherService);
    }

}
