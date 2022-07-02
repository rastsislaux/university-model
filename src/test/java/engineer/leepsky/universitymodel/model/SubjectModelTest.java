package engineer.leepsky.universitymodel.model;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Subject model")
class SubjectModelTest {

    @Test
    @DisplayName("Parameterless constructor")
    void testConstructorNoArgs() {
        Subject subject = new Subject();

        assertEquals(0, subject.getId());
        assertNull(subject.getName());
    }

    @Test
    @DisplayName("Parametrized constructor")
    void testConstructorWithArgs() {
        Subject subject = new Subject(1, "Name");

        assertEquals(1, subject.getId());
        assertEquals("Name", subject.getName());
    }

    @Test
    @DisplayName("Getters and setters")
    void testGettersAndSetters() {
        Subject subject = new Subject();

        subject.setId(191);
        assertEquals(191, subject.getId());

        subject.setName("testName");
        assertEquals("testName", subject.getName());
    }

    @Test
    @DisplayName("Equality")
    void testEquality() {
        Subject subject = new Subject(1, "Name");
        Subject subject2 = new Subject(1, "Name");

        assertEquals(subject, subject2);

        subject2.setId(2);
        assertNotEquals(subject, subject2);

        subject2.setId(1);
        subject2.setName("Name2");
        assertNotEquals(subject, subject2);
    }

    @Test
    @DisplayName("Hash")
    void testHash() {
        Subject subject = new Subject(1, "Name");
        Subject subject2 = new Subject(1, "Name");

        assertEquals(subject.hashCode(), subject2.hashCode());
    }

    @Test
    @DisplayName("To string")
    void testToString() {
        ToStringVerifier.forClass(Subject.class)
                .verify();
    }

}
