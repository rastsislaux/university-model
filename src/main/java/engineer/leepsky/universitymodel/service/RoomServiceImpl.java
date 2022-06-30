package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.model.Room;
import engineer.leepsky.universitymodel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public boolean create(Room room) {
        if (!roomRepository.existsById(room.getNumber())) {
            roomRepository.save(room);
            return true;
        }
        return false;
    }

    @Override
    public List<Room> readAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room read(String id) {
        Optional<Room> room = roomRepository.findById(id);
        return room.orElse(null);
    }

    @Override
    public boolean update(String id, Room room) {
        if (roomRepository.existsById(id)) {
            room.setNumber(id);
            roomRepository.save(room);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
