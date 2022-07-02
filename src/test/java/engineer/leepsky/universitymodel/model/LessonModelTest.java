package engineer.leepsky.universitymodel.model;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lesson model")
class LessonModelTest {

    @Test
    @DisplayName("Parameterless constructor")
    void testConstructorNoArgs() {
        Lesson lesson = new Lesson();

        assertEquals(0, lesson.getId());
        assertEquals(0, lesson.getSubjectId());
        assertEquals(0, lesson.getGroupId());
        assertEquals(0, lesson.getTeacherId());
        assertNull(lesson.getRoomId());
        assertNull(lesson.getDate());
    }

    @Test
    @DisplayName("Parametrized constructor")
    void testConstructorWithArgs() {
        Lesson lesson = new Lesson(1, 1, 1, "room", 1, Date.valueOf("2022-02-02"));

        assertEquals(1, lesson.getId());
        assertEquals(1, lesson.getSubjectId());
        assertEquals(1, lesson.getTeacherId());
        assertEquals("room", lesson.getRoomId());
        assertEquals(1, lesson.getGroupId());
        assertEquals(Date.valueOf("2022-02-02"), lesson.getDate());
    }

    @Test
    @DisplayName("Getters and setters")
    void testGettersAndSetters() {
        Lesson lesson = new Lesson();

        lesson.setId(191);
        assertEquals(191, lesson.getId());

        lesson.setSubjectId(123);
        assertEquals(123, lesson.getSubjectId());

        lesson.setTeacherId(124);
        assertEquals(124, lesson.getTeacherId());

        lesson.setRoomId("room-test");
        assertEquals("room-test", lesson.getRoomId());

        lesson.setGroupId(199);
        assertEquals(199, lesson.getGroupId());

        lesson.setDate(Date.valueOf("1999-02-09"));
        assertEquals(Date.valueOf("1999-02-09"), lesson.getDate());
    }

    @Test
    @DisplayName("Equality")
    void testEquality() {
        Lesson lesson = new Lesson(1, 1, 1, "room", 1, Date.valueOf("2022-02-02"));
        Lesson lesson2 = new Lesson(1, 1, 1, "room", 1, Date.valueOf("2022-02-02"));

        assertEquals(lesson, lesson2);

        lesson2.setId(2);
        assertNotEquals(lesson, lesson2);

        lesson2.setId(1);
        lesson2.setSubjectId(2);
        assertNotEquals(lesson, lesson2);

        lesson2.setSubjectId(1);
        lesson2.setTeacherId(2);
        assertNotEquals(lesson, lesson2);

        lesson2.setTeacherId(1);
        lesson2.setRoomId("other");
        assertNotEquals(lesson, lesson2);

        lesson2.setRoomId("room");
        lesson2.setGroupId(2);
        assertNotEquals(lesson, lesson2);

        lesson2.setGroupId(1);
        lesson2.setDate(Date.valueOf("2011-11-11"));
        assertNotEquals(lesson, lesson2);
    }

    @Test
    @DisplayName("Hash")
    void testHash() {
        Lesson lesson = new Lesson(1, 1, 1, "room", 1, Date.valueOf("2022-02-02"));
        Lesson lesson2 = new Lesson(1, 1, 1, "room", 1, Date.valueOf("2022-02-02"));

        assertEquals(lesson.hashCode(), lesson2.hashCode());
    }

    @Test
    @DisplayName("To string")
    void testToString() {
        ToStringVerifier.forClass(Lesson.class)
                .verify();
    }

}
