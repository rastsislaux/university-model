package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Group;
import engineer.leepsky.universitymodel.model.Lesson;

import java.sql.Date;
import java.util.List;

public interface GroupService {

    /**
     * Creates a new group
     * @param group - group to be created
     * @return - true if group was created, false otherwise
     */
    boolean create(Group group);

    /**
     * Returns a list of all groups
     * @return list of groups
     */
    List<Group> readAll();

    /**
     * Return a group with given ID
     * @param id - group ID
     * @return - group object with given ID
     */
    Group read(Integer id);

    /**
     * Update group with given ID
     * @param id  - ID of a group that must be updated
     * @param group - group to replace an existing object
     * @return - true if group was updated, false otherwise
     */
    boolean update(Integer id, Group group);

    /**
     * Deletes a group with given ID
     * @param id - ID of a group that must be deleted
     * @return - true if group was deleted, false otherwise
     */
    boolean delete(Integer id);

    /**
     * Returns a list of lessons
     * @param id - ID of a group
     * @return - list of lessons on the given date
     */
    List<Lesson> getLessons(Integer id);

    /**
     * Returns a list of lessons on a given date
     * @param id - ID of a group
     * @param date - date
     * @return - list of lessons on the given date
     */
    List<Lesson> getLessonsOnDate(Integer id, Date date);

}
