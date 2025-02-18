package controller;

import entities.player.Player;
import java.util.Scanner;

public class MUDController {
    private Player player;
    private boolean running;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the MUD game! Type 'help' for a list of commands.");

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            handleInput(input);
        }

        scanner.close();
        System.out.println("Game over. Thanks for playing!");
    }

    private void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = (parts.length > 1) ? parts[1] : "";

        switch (command) {
            case "look":
                player.getCurrentRoom().describe();
                break;
            case "move":
                if (!argument.isEmpty()) {
                    player.move(argument);
                } else {
                    System.out.println("Move where? Example: move north");
                }
                break;
            case "pick":
                if (argument.startsWith("up ")) {
                    player.pickUp(argument.substring(3));
                } else {
                    System.out.println("Invalid command! Use: pick up <item>");
                }
                break;
            case "inventory":
                player.showInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            default:
                System.out.println("Unknown command. Type 'help' for available commands.");
        }
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("  look - Describe the current room");
        System.out.println("  move <direction> - Move in a specified direction");
        System.out.println("  pick up <item> - Pick up an item from the room");
        System.out.println("  inventory - List items you are carrying");
        System.out.println("  help - Show this help message");
        System.out.println("  quit / exit - End the game");
    }
}
