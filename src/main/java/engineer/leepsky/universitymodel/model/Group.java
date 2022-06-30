package engineer.leepsky.universitymodel.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Group {

    private String id;
    private Teacher curator;
    private List<Student> students;
    private Schedule schedule;

    public Group(String id, Teacher curator, List<Student> students, Schedule schedule) {
        this.id = id;
        this.curator = curator;
        this.students = students;
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", curator=" + curator +
                ", students=" + students +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
