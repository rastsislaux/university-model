package engineer.leepsky.universitymodel.model;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Group model")
class GroupModelTest {

    @Test
    @DisplayName("Parameterless constructor")
    void testConstructorNoArgs() {
        Group group = new Group();

        assertEquals(0, group.getId());
        assertEquals(0, group.getCuratorId());
    }

    @Test
    @DisplayName("Parametrized constructor")
    void testConstructorWithArgs() {
        Group group = new Group(1, 1);

        assertEquals(1, group.getId());
        assertEquals(1, group.getCuratorId());
    }

    @Test
    @DisplayName("Getters and setters")
    void testGettersAndSetters() {
        Group group = new Group();

        group.setId(191);
        assertEquals(191, group.getId());

        group.setCuratorId(112);
        assertEquals(112, group.getCuratorId());
    }

    @Test
    @DisplayName("Equality")
    void testEquality() {
        Group group = new Group(1, 2);
        Group group2 = new Group(1, 2);

        assertEquals(group, group2);

        group2.setId(2);
        assertNotEquals(group, group2);

        group2.setId(1);
        group2.setCuratorId(4);
        assertNotEquals(group, group2);
    }

    @Test
    @DisplayName("Hash")
    void testHash() {
        Group group = new Group(1, 2);
        Group group2 = new Group(1, 2);

        assertEquals(group.hashCode(), group2.hashCode());
    }

    @Test
    @DisplayName("To string")
    void testToString() {
        ToStringVerifier.forClass(Group.class)
                .verify();
    }

}
