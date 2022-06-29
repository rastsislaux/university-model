package engineer.leepsky.universitymodel.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Group {

    private String id;

    private Teacher curator;

    private List<Student> students;

    Schedule schedule;

    public Group(String id, Teacher curator, List<>)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Date, List<Lesson>> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<Date, List<Lesson>> schedule) {
        this.schedule = schedule;
    }
}
