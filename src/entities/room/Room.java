package entities.room;

import entities.item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Room {
    private String name;
    private String description;
    private List<Item> items;
    private Map<String, Room> exits;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.exits = new HashMap<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    @Override
    public String toString() {
        return name;
    }

    public void describe() {
        System.out.println("Room: " + name + " - " + description);
        System.out.println("Items here: " + items);
        System.out.println("Exits: " + exits.keySet());
    }
}
