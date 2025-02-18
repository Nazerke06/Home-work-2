package game;

import entities.room.RoomManager;
import entities.player.Player;
import controller.MUDController;

public class MainGame {
    public static void main(String[] args) {
        RoomManager roomManager = new RoomManager();
        roomManager.addRoom("Hall", "A large hall with a chandelier.");
        roomManager.addRoom("Library", "A quiet room filled with books.");
        roomManager.setRoomExit("Hall", "north", "Library");
        roomManager.setRoomExit("Library", "south", "Hall");

        Player player = new Player(roomManager.getRoom("Hall"));
        MUDController controller = new MUDController(player);
        controller.runGameLoop();
    }
}
