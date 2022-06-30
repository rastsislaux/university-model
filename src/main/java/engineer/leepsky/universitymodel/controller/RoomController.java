package engineer.leepsky.universitymodel.controller;

import engineer.leepsky.universitymodel.model.Room;
import engineer.leepsky.universitymodel.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping(value = "/rooms")
    public ResponseEntity<?> create(@RequestBody Room room) {
        return roomService.create(room)
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/rooms")
    public ResponseEntity<List<Room>> readAll() {
        final List<Room> roomEntities = roomService.readAll();
        return roomEntities != null && !roomEntities.isEmpty()
                ? new ResponseEntity<>(roomEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/rooms/{id}")
    public ResponseEntity<Room> read(@PathVariable String id) {

        final Room room = roomService.read(id);

        return room != null
                ? new ResponseEntity<>(room, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/rooms/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Room room) {
        final boolean updated = roomService.update(id, room);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/rooms/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        final boolean deleted = roomService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
