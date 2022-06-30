package engineer.leepsky.universitymodel.model;

import java.util.Objects;

public class Room {

    String number;

    Teacher responsiblePerson;

    public Room(String number, Teacher responsiblePerson) {
        this.number = number;
        this.responsiblePerson = responsiblePerson;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setResponsiblePerson(Teacher responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Teacher getResponsiblePerson() {
        return responsiblePerson;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number='" + number + '\'' +
                ", responsiblePerson=" + responsiblePerson +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(number, room.number) && Objects.equals(responsiblePerson, room.responsiblePerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, responsiblePerson);
    }
}
