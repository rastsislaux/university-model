package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Subject;

import java.util.List;

public interface SubjectService {

    /**
     * Creates a new subject
     * @param subject - subject to be created
     * @return - true if subject was created, false otherwise
     */
    boolean create(Subject subject);

    /**
     * Returns a list of all subjects
     * @return list of subjects
     */
    List<Subject> readAll();

    /**
     * Return a subject with given ID
     * @param id - subject ID
     * @return - subject object with given ID
     */
    Subject read(Integer id);

    /**
     * Update subject with given ID
     * @param id  - ID of a subject that must be updated
     * @param subject - Subject to replace an existing object
     * @return - true if subject was updated, false otherwise
     */
    boolean update(Integer id, Subject subject);

    /**
     * Deletes a subject with given ID
     * @param id - ID of a subject that must be deleted
     * @return - true if subject was deleted, false otherwise
     */
    boolean delete(Integer id);

}
