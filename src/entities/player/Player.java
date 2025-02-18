package entities.player;

import entities.room.Room;
import entities.item.Item;
import java.util.*;

public class Player {
    private Room currentRoom;
    private List<Item> inventory;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You move " + direction + ".");
        } else {
            System.out.println("You can't go that way!");
        }
    }

    public void pickUp(String itemName) {
        List<Item> items = currentRoom.getItems();
        for (Item item : items) {
            if (item.toString().equalsIgnoreCase(itemName)) {
                inventory.add(item);
                currentRoom.removeItem(item);
                System.out.println("You pick up the " + itemName + ".");
                return;
            }
        }
        System.out.println("No item named " + itemName + " here!");
    }

    public void showInventory() {
        System.out.println("You are carrying: " + inventory);
    }
}
