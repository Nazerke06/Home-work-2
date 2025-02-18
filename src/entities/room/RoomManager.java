package entities.room;

import java.util.HashMap;
import java.util.Map;

public class RoomManager {
    private Map<String, Room> rooms;

    public RoomManager() {
        rooms = new HashMap<>();
    }

    public void addRoom(String name, String description) {
        rooms.put(name, new Room(name, description));
    }

    public Room getRoom(String name) {
        return rooms.get(name);
    }

    public void setRoomExit(String roomName, String direction, String targetRoomName) {
        Room room = rooms.get(roomName);
        Room targetRoom = rooms.get(targetRoomName);
        if (room != null && targetRoom != null) {
            room.setExit(direction, targetRoom);
        } else {
            System.out.println("Error: Room not found!");
        }
    }
}
