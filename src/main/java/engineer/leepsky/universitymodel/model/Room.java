package engineer.leepsky.universitymodel.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "number")
    private String number;

    @Column(name = "responsible_person_id")
    private int responsiblePerson;

}
