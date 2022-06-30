package engineer.leepsky.universitymodel.controller;

import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping(value = "/lessons")
    public ResponseEntity<?> create(@RequestBody Lesson lesson) {
        return lessonService.create(lesson)
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/lessons")
    public ResponseEntity<List<Lesson>> readAll() {
        final List<Lesson> lessonEntities = lessonService.readAll();
        return lessonEntities != null && !lessonEntities.isEmpty()
                ? new ResponseEntity<>(lessonEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/lessons/{id}")
    public ResponseEntity<Lesson> read(@PathVariable int id) {

        final Lesson lesson = lessonService.read(id);

        return lesson != null
                ? new ResponseEntity<>(lesson, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/lessons/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Lesson lesson) {
        final boolean updated = lessonService.update(id, lesson);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/lessons/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        final boolean deleted = lessonService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
