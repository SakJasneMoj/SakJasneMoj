package sk.uniza.fri.player;

import sk.uniza.fri.enemy.ICreature;
import sk.uniza.fri.items.*;

import java.util.ArrayList;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class
Player implements ICreature {

    //basic values
    private float maximuHealth;
    private float actualHealth;
    private float damage;
    private float armor;

    //name of creature
    private String name = "PLAYER";

    // list of equiped items
    private ArrayList<IItem> equipdGear = new ArrayList<IItem>();

    // Inventory
    //private ArrayList<IItem> inventory = new ArrayList<>();
    private Inventory inventory = new Inventory();

    //modifiers
    private float damageModifier;
    private float armorModifier;

    public Player(float health, float damage, float armor) {
        this.maximuHealth = health;
        this.actualHealth = health;
        this.damage = damage;
        this.armor = armor;
    }

    public float getDamage() {
        return damage;
    }

    public float getArmor() {
        return armor;
    }

    public float getMaximuHealth() {
        return maximuHealth;
    }

    @Override
    public float getActualHealth() {
        return this.actualHealth;
    }

    @Override
    public String getName() {
        return name;
    }

    public void doDamage(ICreature creature) {
        // TODO
        // calculate damage
        creature.takeDamage(this.damage + this.damageModifier);
    }

    // Take damage from other creatures of effects
    public void takeDamage(float damage) {
        float totalDamage = damage - this.armor;

        if (totalDamage > 0) {
            this.actualHealth -= totalDamage;
            //System.out.println("Player took " + totalDamage + " from attack.");
        }
    }

    public void printInfo() {
        System.out.println("-----------------------");
        System.out.println("Player current stats: ");
        System.out.print("Health: " + this.actualHealth);
        System.out.print(" Damage: " + (this.damage + this.damageModifier));
        System.out.print(" Armor: " + (this.armor + this.armorModifier));
        System.out.println();
        System.out.println("-----------------------");
    }

    // check if player is dead
    public boolean isDead() {
        return this.actualHealth <= 0;
    }

    // Modifiers for damage, health and armor
    public void addDamageModifier(float damageModifier) {
        this.damageModifier = this.damageModifier + damageModifier;
    }

    public void removeDamageModifier(float damageModifier) {
        this.damageModifier = this.damageModifier - damageModifier;
    }

    public void addArmorModifier(float armorModifier) {
        this.armorModifier = this.armorModifier + armorModifier;
    }

    public void removeArmorModifier(float armorModifier) {
        this.armorModifier = this.armorModifier - armorModifier;
    }

    public void useItems(IItem usableItem) {
        //System.out.println("som v metode useIteam v player");
        // TODO
        for (IItem item : this.inventory.getUsableItems()) {
            if (item instanceof IUsable) {
                if (item.getUseName().equals(usableItem.getUseName())) {
                    if (((IUsable) item).getActualCooldown() < 1) {
                        ((IUsable) item).use(this);
                       // System.out.println("skoncil some metodu useIteam v player");
                        return;
                    } else {
                        System.out.println("this iteam is on cooldown " + ((IUsable) item).getActualCooldown());
                    }

                }

            }
            //System.out.println("nepresiel som metodou useItem v player");
        }

    }

    public void reduceCooldownOfUseItems() {

        for (IItem item : this.inventory.getUsableItems()) {
            if (((IUsable) item).getActualCooldown() > 0) {
                ((IUsable) item).loverCooldown();

            }
            if (((IUsable) item).getActualdurationInRooms() < ((IUsable) item).getDurationsInRooms() ){
                ((IUsable) item).setActualdurationInRooms(((IUsable) item).getActualdurationInRooms()+1);
            }
            if (((IUsable) item).getActualdurationInRooms() > ((IUsable) item).getDurationsInRooms() ){
                ((IUsable) item).endBonuses(this);
            }
        }

    }

    public void addItemToInventory(BananOfDamage bananOfDamage) {
        if (bananOfDamage != null) {
            this.inventory.addItem(bananOfDamage);
            this.inventory.addItem(new PotionOfHealtSmall());
            this.inventory.addItem(new HealmOfHealth());
        }
    }

    public void heal(float healthAdd) {

        this.actualHealth += healthAdd;
        if (this.actualHealth > this.maximuHealth) {
            this.actualHealth = this.maximuHealth;

        }
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void useConsumable() {
        for (IItem item : this.inventory.getConsumableItems()) {
            if (item instanceof IConsumable) {
                ((IConsumable) item).consume(this);
            }
        }

    }

    public void setMaximuHealth(float maximuHealth) {
        this.maximuHealth = maximuHealth;
    }

    public ArrayList<IItem> getEquipdGear() {
        return equipdGear;
    }

    public void setEquipdGear(ArrayList<IItem> equipdGear) {
        this.equipdGear = equipdGear;
    }


    public void setActualHealth(float actualHealth) {
        this.actualHealth = actualHealth;
    }

    public float getDamageModifier() {
        return damageModifier;
    }

    public float getArmorModifier() {
        return armorModifier;
    }

    public void setDebufs(float ammount, String classOfDebuf) {
        switch (classOfDebuf) {
            case "armor":
                this.addArmorModifier(-(ammount));
        }
    }

    public void removeDebufs(float ammount, String classOfDebuf) {
        switch (classOfDebuf) {
            case "armor":
                this.addArmorModifier(+(ammount));
        }
    }

}











