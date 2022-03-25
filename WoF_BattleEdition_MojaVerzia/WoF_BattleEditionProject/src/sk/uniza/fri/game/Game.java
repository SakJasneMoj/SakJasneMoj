package sk.uniza.fri.game;

import sk.uniza.fri.items.*;
import sk.uniza.fri.maps.BattleMap;
import sk.uniza.fri.maps.Room;
import sk.uniza.fri.maps.Shop;
import sk.uniza.fri.maps.TrapRoom;
import sk.uniza.fri.player.Player;
import sk.uniza.fri.userInteraction.Command;
import sk.uniza.fri.userInteraction.Parser;

import java.util.ArrayList;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class Game {
    private final Parser parser;
    private final BattleMap battleMap;
    private final BattleManager battleManager;
    private Room currentRoom;
    private Player player;

    public Game() {
        this.battleMap = new BattleMap();
        this.currentRoom = this.battleMap.createMap(this);
        this.parser = new Parser();
        this.battleManager = new BattleManager();
        this.player = new Player(100, 10, 8);
        this.player.addItemToInventory(new BananOfDamage());
    }

    public void play() {
        this.printInvitation();

        boolean isEnd = false;

        do {
            Command command = this.parser.getCommandFromInput();
            isEnd = this.performCommand(command);
            // Start battle if there are enemies in room
            if (!isEnd && this.currentRoom.getEnemiesInRoom() != null) {
                isEnd = battleManager.startFight(this.player, this.currentRoom, this);

            }

            if (!isEnd && this.currentRoom.getEnemiesInRoom() == null && this.currentRoom instanceof TrapRoom) {
             ((TrapRoom) this.currentRoom).putTrap(this.player);
            }

            if (!isEnd && this.currentRoom.getEnemiesInRoom() == null && this.currentRoom instanceof Shop) {
                ((TrapRoom) this.currentRoom).putTrap(this.player);
            }


            if (!isEnd) {
                player.printInfo();
                if (!this.isLastRoom(currentRoom)) {
                    this.printRooms();
                } else {
                    System.out.println("YOU WON!");
                    isEnd = true;
                }
            }
        } while (!isEnd);
    }

    // TODO rework. This is not optimal
    private boolean isLastRoom(Room currentRoom) {
        if (currentRoom.getLeftExit() == null) {
            if (currentRoom.getMiddleExit() == null) {
                if (currentRoom.getRightExit() == null) {
                    // no more exits, we are at the end
                    return true;
                }
            }
        }
        // still has exits
        return false;
    }

    // spracovanie prikazov
    private boolean performCommand(Command command) {

        if (command.isUnknown()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }

        String commandName = command.getName();

        switch (commandName) {
            case "help":
                this.printHelp();
                return false;
            case "go":
                this.moveToRoom(command);
                return false;
            case "end":
                return this.endGame(command);
            case "show":
                this.show(command);
                return false;
            case "use":
                this.use(command);
                return false;
            case "equip":
                this.equip(command);
                return false;
            case "unequip":
                this.unequip(command);
                return false;
            case "fight":
                this.fight(command);
                return false;
            default:
                return false;
        }
    }

    private void fight(Command command) {

    this.battleManager.fight();

    }

    private void equip(Command command) {

        if (!command.hasParameter()) {
            System.out.println("Equip what ?");
            return;
        }

        ArrayList<IItem> inventory = this.player.getInventory().getGearItems();

        for (IItem gear : inventory) {

            if (command.getParameter().equals(gear.getUseName())) {
                if (gear.getUseName().equals(command.getParameter())) {
                    ((IGear)gear).equip(this.player);
                    inventory.remove(gear);
                    this.player.getInventory().removeItem(gear);
                    this.player.getEquippedGear().add(gear);
                    return;
                }
            }
        }

        System.out.println("Neviem aky item");
    }

    private void unequip(Command command) {

        if (!command.hasParameter()) {
            System.out.println("UnEguip what ?");
            return;
        }

        ArrayList<IItem> inventory = this.player.getEquippedGear();
        for (IItem gear : inventory) {

            if (command.getParameter().equals(gear.getUseName())) {
                System.out.println("som v casti 1");
                if (gear.getUseName().equals(command.getParameter())) {
                    System.out.println("som v casti 2");
                    ((IGear)gear).unEquip(this.player);
                    inventory.add(gear);
                    this.player.getInventory().addItem(gear);
                    this.player.getEquippedGear().remove(gear);
                    System.out.println("som hotovy");
                    return;
                }
            }
        }
        System.out.println("Neviem aky item");
    }

    private void use(Command command) {

        if (!command.hasParameter()) {
            System.out.println("Use what ?");
            return;
        }
        if (!command.hasSecondParameter()) {
            System.out.println("Use what ?");
            return;
        }

        switch (command.getParameter()) {
            case "consumable":
                ArrayList<IItem> inventory = this.player.getInventory().getConsumableItems();
                for (IItem consumable : inventory) {
                    if (consumable.getUseName().equals(command.getSecondParameter())) {
                        ((IConsumable) consumable).consume(this.player);
                        this.player.getInventory().removeItem(consumable);
                        return;
                    }
                }
            case "usable":
                //System.out.println("Dostal som sa k switchus usable v game");
                ArrayList<IItem> inventoryUsable = this.player.getInventory().getUsableItems();
                for (IItem usable : inventoryUsable) {
                    //System.out.println("som v foreach v game");
                    System.out.println("toto je actualne meno itemu " + usable.getUseName());
                    if (usable.getUseName().equals(command.getSecondParameter())) {

                       // System.out.println("som v ife v game");
                        player.useItems((usable));
                       // System.out.println("Skoncil som switch usable v game");
                        return;
                    }
                }
                //System.out.println("nepresiel som switchom usable v game");
                return;

        }
    }

    private void show(Command command) {
        if (!command.hasParameter()) {
            System.out.println("Show what ?");
            return;
        }
        //chceck obiect to show
        switch (command.getParameter()) {
            case "inventory":
                //get invetory from palyer
                //show itmes
                this.player.getInventory().showItems();
            case "equipedGear":
                System.out.println("u have equipd: ");
                for (IItem gear : this.player.getEquippedGear()) {

                    System.out.println(gear.getName());
                }

        }
    }

    // ukoncenie hry
    // prikaz nema ziadny parameter
    // ak je prikaz naozaj ukonci  vratime false a ukoncime cyklus
    private boolean endGame(Command command) {
        if (command.hasParameter()) {
            System.out.println("Ukonci, co?");
            return false;
        } else {
            return true;
        }
    }

    private void moveToRoom(Command command) {
        if (!command.hasParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String direction = command.getParameter();

        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        Room newRoom = null;

        switch (direction) {
            case "left":
                newRoom = this.currentRoom.getLeftExit();
                break;
            case "middle":
                newRoom = this.currentRoom.getRightExit();
                break;
            case "right":
                newRoom = this.currentRoom.getMiddleExit();
                break;
        }

        if (newRoom == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.currentRoom = newRoom;
            this.printRooms();
        }
    }

    // Vypis info o miestnosti a o hre
    private void printRooms() {
        System.out.println("Teraz si v miestnosti " + this.currentRoom.getDescription());
        System.out.print("Vychody: ");
        if (this.currentRoom.getLeftExit() != null) {
            System.out.print("left ");
        }
        if (this.currentRoom.getRightExit() != null) {
            System.out.print("middle ");
        }
        if (this.currentRoom.getMiddleExit() != null) {
            System.out.print("right ");
        }
        System.out.println();
    }

    private void printInvitation() {
        System.out.println();
        System.out.println("Vitaj v hre World of FRI!");
        System.out.println("World of FRI - Battle Edition je bojova verzia byvalej adventuri.");
        System.out.println("Cielom hry je prebojovat sa na koniec pevnosti a porazit bossa.");
        System.out.println("Zadaj 'help' ak potrebujes pomoc.");
        System.out.println("Prikazy: 'go' 'help' 'end' 'show' 'use' 'equip' 'unequip'");
        System.out.println();
        this.printRooms();
    }

    private void printHelp() {
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.println("   chod ukonci pomoc");
    }


}
