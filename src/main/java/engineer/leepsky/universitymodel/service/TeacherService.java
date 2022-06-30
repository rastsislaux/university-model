package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Teacher;

import java.util.List;

public interface TeacherService {

    /**
     * Creates a new teacher
     * @param teacher - teacher to be created
     * @return - true if teacher was created, false otherwise
     */
    boolean create(Teacher teacher);

    /**
     * Returns a list of all teachers
     * @return list of teachers
     */
    List<Teacher> readAll();

    /**
     * Return a teacher with given ID
     * @param id - teacher ID
     * @return - teacher object with given ID
     */
    Teacher read(Integer id);

    /**
     * Update teacher with given ID
     * @param id  - ID of a teacher that must be updated
     * @param teacher - Teacher to replace an existing object
     * @return - true if teacher was updated, false otherwise
     */
    boolean update(Integer id, Teacher teacher);

    /**
     * Deletes a teacher with given ID
     * @param id - ID of a teacher that must be deleted
     * @return - true if teacher was deleted, false otherwise
     */
    boolean delete(Integer id);

}
