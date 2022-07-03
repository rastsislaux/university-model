package engineer.leepsky.universitymodel.controller;

import engineer.leepsky.universitymodel.model.Group;
import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "/groups/{id}/schedule")
    public ResponseEntity<?> readLessons(@PathVariable int id) {
        List<Lesson> lessons = groupService.readLessons(id);
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @GetMapping(value = "/groups/{id}/schedule/{date}")
    public ResponseEntity<?> readLessonsOnDate(@PathVariable int id, @PathVariable Date date) {
        List<Lesson> lessons = groupService.readLessonsOnDate(id, date);
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @PostMapping(value = "/groups")
    public ResponseEntity<?> create(@RequestBody Group group) {
        return groupService.create(group)
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/groups")
    public ResponseEntity<?> readAll() {
        final List<Group> groups = groupService.readAll();
        return groups != null && !groups.isEmpty()
                ? new ResponseEntity<>(groups, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/groups/{id}")
    public ResponseEntity<?> read(@PathVariable int id) {
        final Group group = groupService.read(id);

        return group != null
                ? new ResponseEntity<>(group, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/groups/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Group group) {
        return groupService.update(id, group)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/groups/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        return groupService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
