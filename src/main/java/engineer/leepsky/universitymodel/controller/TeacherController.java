package engineer.leepsky.universitymodel.controller;

import engineer.leepsky.universitymodel.model.Teacher;
import engineer.leepsky.universitymodel.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(value = "/teachers")
    public ResponseEntity<?> create(@RequestBody Teacher teacher) {
        return teacherService.create(teacher)
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/teachers")
    public ResponseEntity<List<Teacher>> readAll() {
        final List<Teacher> teacherEntities = teacherService.readAll();
        return teacherEntities != null && !teacherEntities.isEmpty()
                ? new ResponseEntity<>(teacherEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/teachers/{id}")
    public ResponseEntity<Teacher> read(@PathVariable Integer id) {

        final Teacher teacher = teacherService.read(id);

        return teacher != null
                ? new ResponseEntity<>(teacher, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/teachers/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Teacher teacher) {
        final boolean updated = teacherService.update(id, teacher);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/teachers/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        final boolean deleted = teacherService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
