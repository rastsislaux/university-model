package engineer.leepsky.universitymodel.controller;

import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.model.Student;
import engineer.leepsky.universitymodel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students/{id}/schedule")
    public ResponseEntity<?> readLessons(@PathVariable int id) {
        List<Lesson> lessons = studentService.readLessons(id);
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}/schedule/{date}")
    public ResponseEntity<?> readLessonsOnDate(@PathVariable int id, @PathVariable Date date) {
        List<Lesson> lessons = studentService.readLessonsOnDate(id, date);
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @PostMapping(value = "/students")
    public ResponseEntity<?> create(@RequestBody Student student) {
        return studentService.create(student)
            ? new ResponseEntity<>(HttpStatus.CREATED)
            : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> readAll() {
        final List<Student> studentEntities = studentService.readAll();
        return studentEntities != null && !studentEntities.isEmpty()
                ? new ResponseEntity<>(studentEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> read(@PathVariable int id) {

        final Student student = studentService.read(id);

        return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/students/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Student student) {
        final boolean updated = studentService.update(id, student);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        final boolean deleted = studentService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
