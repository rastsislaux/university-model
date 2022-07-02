package engineer.leepsky.universitymodel.model;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Student model")
class StudentModelTest {

    @Test
    @DisplayName("Parameterless constructor")
    void testConstructorNoArgs() {
        Student student = new Student();

        assertEquals(0, student.getId());
        assertNull(student.getName());
        assertEquals(0, student.getGroupId());
    }

    @Test
    @DisplayName("Parametrized constructor")
    void testConstructorWithArgs() {
        Student student = new Student(1, "Name", 1219);

        assertEquals(1, student.getId());
        assertEquals("Name", student.getName());
        assertEquals(1219, student.getGroupId());
    }

    @Test
    @DisplayName("Getters and setters")
    void testGettersAndSetters() {
        Student student = new Student();

        student.setId(191);
        assertEquals(191, student.getId());

        student.setName("testName");
        assertEquals("testName", student.getName());

        student.setGroupId(1000);
        assertEquals(1000, student.getGroupId());
    }

    @Test
    @DisplayName("Equality")
    void testEquality() {
        Student student = new Student(1, "Name", 2);
        Student student2 = new Student(1, "Name", 2);

        assertEquals(student, student2);

        student2.setId(2);
        assertNotEquals(student, student2);

        student2.setId(1);
        student2.setName("Name2");
        assertNotEquals(student, student2);

        student2.setName("Name");
        student2.setGroupId(3);
        assertNotEquals(student, student2);
    }

    @Test
    @DisplayName("Hash")
    void testHash() {
        Student student = new Student(1, "Name", 2);
        Student student2 = new Student(1, "Name", 2);

        assertEquals(student.hashCode(), student2.hashCode());
    }

    @Test
    @DisplayName("To string")
    void testToString() {
        ToStringVerifier.forClass(Student.class)
                .verify();
    }

}
