package engineer.leepsky.universitymodel.model;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Room model")
class RoomModelTest {

    @Test
    @DisplayName("Parameterless constructor")
    void testConstructorNoArgs() {
        Room room = new Room();

        assertNull(room.getNumber());
        assertEquals(0, room.getResponsiblePerson());
    }

    @Test
    @DisplayName("Parametrized constructor")
    void testConstructorWithArgs() {
        Room room = new Room("404-4", 1);

        assertEquals("404-4", room.getNumber());
        assertEquals(1, room.getResponsiblePerson());
    }

    @Test
    @DisplayName("Getters and setters")
    void testGettersAndSetters() {
        Room room = new Room();

        room.setNumber("102-4");
        assertEquals("102-4", room.getNumber());

        room.setResponsiblePerson(2);
        assertEquals(2, room.getResponsiblePerson());
    }

    @Test
    @DisplayName("Equality")
    void testEquality() {
        Room room = new Room("404-4", 2);
        Room room2 = new Room("404-4", 2);

        assertEquals(room, room2);

        room2.setNumber("404-5");
        assertNotEquals(room, room2);

        room2.setNumber("404-4");
        room2.setResponsiblePerson(3);
        assertNotEquals(room, room2);
    }

    @Test
    @DisplayName("Hash")
    void testHash() {
        Room room = new Room("404-4", 2);
        Room room2 = new Room("404-4", 2);

        assertEquals(room.hashCode(), room2.hashCode());
    }

    @Test
    @DisplayName("To string")
    void testToString() {
        ToStringVerifier.forClass(Room.class)
                .verify();
    }

}
