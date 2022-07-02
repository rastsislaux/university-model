package engineer.leepsky.universitymodel.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "room_id")
    private String roomId;

    @Column(name = "group_id")
    private int groupId;

    @Column(name = "date")
    private Date date;

    public Lesson() { }

    public Lesson(int id, int subjectId, int teacherId, String roomId, int groupId, Date date) {
        this.id = id;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.roomId = roomId;
        this.groupId = groupId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id == lesson.id && subjectId == lesson.subjectId && teacherId == lesson.teacherId && groupId == lesson.groupId && Objects.equals(roomId, lesson.roomId) && Objects.equals(date, lesson.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectId, teacherId, roomId, groupId, date);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", teacherId=" + teacherId +
                ", roomId='" + roomId + '\'' +
                ", groupId=" + groupId +
                ", date='" + date + '\'' +
                '}';
    }
}
