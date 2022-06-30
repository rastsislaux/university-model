package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Student;

import java.util.List;

public interface StudentService {

    /**
     * Creates a new student
     * @param student - student to be created
     */
    boolean create(Student student);

    /**
     * Returns a list of all students
     * @return list of students
     */
    List<Student> readAll();

    /**
     * Return a student with given ID
     * @param id - student ID
     * @return - student object with given ID
     */
    Student read(Integer id);

    /**
     * Update student with given ID
     * @param id  - ID of a student that must be updated
     * @param student - Student to replace an existing object
     * @return - true if student was updated, false otherwise
     */
    boolean update(Integer id, Student student);

    /**
     * Deletes a student with given ID
     * @param id - ID of a student that must be deleted
     * @return - true if student was deleted, false otherwise
     */
    boolean delete(Integer id);

}
