package engineer.leepsky.universitymodel.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "number")
    private String number;

    @Column(name = "responsible_person_id")
    private int responsiblePerson;

    public Room() { }

    public Room(String number, int responsiblePerson) {
        this.number = number;
        this.responsiblePerson = responsiblePerson;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(int responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return responsiblePerson == room.responsiblePerson && Objects.equals(number, room.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, responsiblePerson);
    }

    @Override
    public String toString() {
        return "Room{" +
                "number='" + number + '\'' +
                ", responsiblePerson=" + responsiblePerson +
                '}';
    }
}
