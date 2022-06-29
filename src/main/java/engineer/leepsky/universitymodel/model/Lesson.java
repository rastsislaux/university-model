package engineer.leepsky.universitymodel.model;

import java.util.Objects;

public class Lesson {

    public Lesson(Type type, Subject subject, Teacher teacher, Room room) {
        this.type = type;
        this.subject = subject;
        this.teacher = teacher;
        this.room = room;
    }

    enum Type {
        LABORATORY,
        PRACTICAL,
        LECTURE
    }

    private Type type;

    private Subject subject;

    private Teacher teacher;

    private Room room;

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "type=" + type +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", room=" + room +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return type == lesson.type && Objects.equals(subject, lesson.subject) && Objects.equals(teacher, lesson.teacher) && Objects.equals(room, lesson.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, subject, teacher, room);
    }
}
