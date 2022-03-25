package sk.uniza.fri.player;

import sk.uniza.fri.items.*;

import java.util.ArrayList;

public class Inventory {

    private int itemCount;
    private ArrayList<IItem> inventoryUsable = new ArrayList<IItem>();
    private ArrayList<IItem> inventoryConsumable = new ArrayList<IItem>();
    private ArrayList<IItem> inventoryGear = new ArrayList<IItem>();
    private ArrayList<IItem> inventoryPasive = new ArrayList<IItem>();


    public void addItem(IItem item) {

        if (item == null) {
            return;
        }

        if (item instanceof IConsumable) {
            this.inventoryConsumable.add(item);
            return;
        } else if (item instanceof IUsable) {
            this.inventoryUsable.add(item);
            return;
        } else if (item instanceof IGear) {
            this.inventoryGear.add(item);
            return;
        } else if (item instanceof IPassive) {
            this.inventoryPasive.add(item);
            return;
        }
    }

    public void removeItem(IItem item) {

        if (item == null) {
            return;
        }

        if (this.inventoryUsable.contains(item)) {
            this.inventoryUsable.remove(item);
            return;
        }

        if (this.inventoryConsumable.contains(item)) {
            this.inventoryConsumable.remove(item);
            return;
        }

        if (this.inventoryGear.contains(item)) {
            this.inventoryGear.remove(item);
            return;
        }

        if (this.inventoryPasive.contains(item)) {
            this.inventoryPasive.remove(item);
            return;
        }
    }


    public void showItems() {
        System.out.println("Consumable items");

        for (IItem item : this.inventoryConsumable) {
            String itemText = String.format("[%s] : %s", item.getName(), item.getDescription());
            System.out.println(itemText);
        }

        System.out.println("Usable items");

        for (IItem item : this.inventoryUsable) {
            String itemText = String.format("[%s] : %s", item.getName(), item.getDescription());
            System.out.println(itemText);
        }

        System.out.println("Gear items");

        for (IItem item : this.inventoryGear) {
            String itemText = String.format("[%s] : %s", item.getName(), item.getDescription());
            System.out.println(itemText);
        }

        System.out.println("Pasive items");

        for (IItem item : this.inventoryPasive) {
            String itemText = String.format("[%s] : %s", item.getName(), item.getDescription());
            System.out.println(itemText);
        }

    }

    public ArrayList<IItem> getUsableItems() {
        return this.inventoryUsable;
    }

    public ArrayList<IItem> getConsumableItems() {
        return this.inventoryConsumable;
    }

    public ArrayList<IItem> getGearItems() {
        return this.inventoryGear;
    }
}



