package engineer.leepsky.universitymodel.model;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teacher model")
class TeacherModelTest {

    @Test
    @DisplayName("Parameterless constructor")
    void testConstructorNoArgs() {
        Teacher teacher = new Teacher();

        assertEquals(0, teacher.getId());
        assertNull(teacher.getName());
    }

    @Test
    @DisplayName("Parametrized constructor")
    void testConstructorWithArgs() {
        Teacher teacher = new Teacher(1, "Name");

        assertEquals(1, teacher.getId());
        assertEquals("Name", teacher.getName());
    }

    @Test
    @DisplayName("Getters and setters")
    void testGettersAndSetters() {
        Teacher teacher = new Teacher();

        teacher.setId(191);
        assertEquals(191, teacher.getId());

        teacher.setName("testName");
        assertEquals("testName", teacher.getName());
    }

    @Test
    @DisplayName("Equality")
    void testEquality() {
        Teacher teacher = new Teacher(1, "Name");
        Teacher teacher2 = new Teacher(1, "Name");

        assertEquals(teacher, teacher2);

        teacher2.setId(2);
        assertNotEquals(teacher, teacher2);

        teacher2.setId(1);
        teacher2.setName("Name2");
        assertNotEquals(teacher, teacher2);
    }

    @Test
    @DisplayName("Hash")
    void testHash() {
        Teacher teacher = new Teacher(1, "Name");
        Teacher teacher2 = new Teacher(1, "Name");

        assertEquals(teacher.hashCode(), teacher2.hashCode());
    }

    @Test
    @DisplayName("To string")
    void testToString() {
        ToStringVerifier.forClass(Teacher.class)
                .verify();
    }

}
