package engineer.leepsky.universitymodel.controller;

import engineer.leepsky.universitymodel.model.Subject;
import engineer.leepsky.universitymodel.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping(value = "/subjects")
    public ResponseEntity<?> create(@RequestBody Subject subject) {
        return subjectService.create(subject)
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/subjects")
    public ResponseEntity<List<Subject>> readAll() {
        final List<Subject> subjectEntities = subjectService.readAll();
        return subjectEntities != null && !subjectEntities.isEmpty()
                ? new ResponseEntity<>(subjectEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/subjects/{id}")
    public ResponseEntity<Subject> read(@PathVariable Integer id) {

        final Subject subject = subjectService.read(id);

        return subject != null
                ? new ResponseEntity<>(subject, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/subjects/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Subject subject) {
        final boolean updated = subjectService.update(id, subject);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/subjects/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        final boolean deleted = subjectService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
