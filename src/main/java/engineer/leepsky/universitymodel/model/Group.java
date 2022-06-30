package engineer.leepsky.universitymodel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "curator_id")
    private int curatorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(int curatorId) {
        this.curatorId = curatorId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", curatorId=" + curatorId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id && curatorId == group.curatorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, curatorId);
    }
}
