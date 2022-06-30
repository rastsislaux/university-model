package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Lesson;

import java.util.List;

public interface LessonService {

    /**
     * Creates a new lesson
     * @param lesson - lesson to be created
     * @return - true if lesson was created, false otherwise
     */
    boolean create(Lesson lesson);

    /**
     * Returns a list of all lessons
     * @return list of lessons
     */
    List<Lesson> readAll();

    /**
     * Return a lesson with given ID
     * @param id - lesson ID
     * @return - lesson object with given ID
     */
    Lesson read(Integer id);

    /**
     * Update lesson with given ID
     * @param id  - ID of a lesson that must be updated
     * @param lesson - Lesson to replace an existing object
     * @return - true if lesson was updated, false otherwise
     */
    boolean update(Integer id, Lesson lesson);

    /**
     * Deletes a lesson with given ID
     * @param id - ID of a lesson that must be deleted
     * @return - true if lesson was deleted, false otherwise
     */
    boolean delete(Integer id);
    
}
