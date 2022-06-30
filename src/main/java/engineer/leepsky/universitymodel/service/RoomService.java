package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.model.Room;

import java.sql.Date;
import java.util.List;

public interface RoomService {

    /**
     * Creates a new room
     * @param room - room to be created
     * @return - true if room was created, false otherwise
     */
    boolean create(Room room);

    /**
     * Returns a list of all rooms
     * @return list of rooms
     */
    List<Room> readAll();

    /**
     * Return a room with given ID
     * @param id - room ID
     * @return - room object with given ID
     */
    Room read(String id);

    /**
     * Update room with given ID
     * @param id  - ID of a room that must be updated
     * @param room - Room to replace an existing object
     * @return - true if room was updated, false otherwise
     */
    boolean update(String id, Room room);

    /**
     * Deletes a room with given ID
     * @param id - ID of a room that must be deleted
     * @return - true if room was deleted, false otherwise
     */
    boolean delete(String id);

}
