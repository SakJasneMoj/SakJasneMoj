package sk.uniza.fri.player;

import sk.uniza.fri.enemy.ICreature;
import sk.uniza.fri.items.*;

import java.util.ArrayList;

public class
Player implements ICreature {

    //basic values
    private float maximumHealth;
    private float actualHealth;
    private float damage;
    private float armor;

    //name of creature
    private String name = "PLAYER";

    // list of equipped items
    private ArrayList<IItem> equippedGear = new ArrayList<IItem>();

    // Inventory
    //private ArrayList<IItem> inventory = new ArrayList<>();
    private Inventory inventory = new Inventory();

    //modifiers
    private float damageModifier;
    private float armorModifier;

    //constructor for player
    public Player(float health, float damage, float armor) {
        this.maximumHealth = health;
        this.actualHealth = health;
        this.damage = damage;
        this.armor = armor;
    }

    //return hero damage whit ou modifiers
    public float getDamage() {
        return damage;
    }

    // return hero armor whit out modifiera
    public float getArmor() {
        return armor;
    }

    // returns hero maximum health
    public float getMaximumHealth() {
        return maximumHealth;
    }

    // return hero health
    @Override
    public float getActualHealth() {
        return this.actualHealth;
    }

    // return player name
    @Override
    public String getName() {
        return name;
    }

    // method where player do damage to other creatures
    public void doDamage(ICreature creature) {
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

    // give information about hero dmg,hp,armor + modifiers
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
    // end of modifiers for damage, health and armor

    // method where player can use IUsable items
    public void useItems(IItem usableItem) {
        for (IItem item : this.inventory.getUsableItems()) {

            if (item instanceof IUsable) {
                if (item.getUseName().equals(usableItem.getUseName())) {
                    if (((IUsable) item).getActualCoolDown() < 1) {
                        ((IUsable) item).use(this);
                        return;
                    } else {
                        System.out.println("this iteam is on cooldown " + ((IUsable) item).getActualCoolDown());
                    }
                }
            }
        }
    }

    // method reducing cool down of IUsable items
    public void reduceCoolDownOfUseItems() {

        for (IItem item : this.inventory.getUsableItems()) {

            if (((IUsable) item).getActualCoolDown() > 0) {
                ((IUsable) item).loverCoolDown();
            }

            if (((IUsable) item).getActualDurationInRooms() < ((IUsable) item).getDurationsInRooms()) {
                ((IUsable) item).setActualDurationInRooms(((IUsable) item).getActualDurationInRooms() + 1);
            }

            if (((IUsable) item).getActualDurationInRooms() > ((IUsable) item).getDurationsInRooms()) {
                ((IUsable) item).endBonuses(this);
            }
        }
    }

    //method for adding items to player inventory
    public void addItemToInventory(IItem item) {

        if (item != null) {
            this.inventory.addItem(new BananOfDamage());
            this.inventory.addItem(new PotionOfHealthSmall());
            this.inventory.addItem(new HelmOfHealth());
        }
    }

    // method to increase player actual health
    public void heal(float healthAdd) {
        this.actualHealth += healthAdd;

        if (this.actualHealth > this.maximumHealth) {
            this.actualHealth = this.maximumHealth;
        }
    }

    // return player inventory
    public Inventory getInventory() {
        return this.inventory;
    }

    // set player inventory
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    // consuming items of type IConsumable
    public void useConsumable() {

        for (IItem item : this.inventory.getConsumableItems()) {

            if (item instanceof IConsumable) {
                ((IConsumable) item).consume(this);
            }
        }
    }

    // used for increasing player maximum health
    public void setMaximumHealth(float maximumHealth) {
        this.maximumHealth = maximumHealth;
    }

    // return IGear items witch player actually using
    public ArrayList<IItem> getEquippedGear() {
        return equippedGear;
    }

    public void setActualHealth(float actualHealth) {
        this.actualHealth = actualHealth;
    }

    // returns player damage modifier
    public float getDamageModifier() {
        return damageModifier;
    }

    // returns player armor modifier
    public float getArmorModifier() {
        return armorModifier;
    }

    // adds debuff to player
        public void setDebuff(float ammount, String classOfDebuf) {

        switch (classOfDebuf) {
            case "armor":
                this.addArmorModifier(-(ammount));
        }
    }

    // remove debuff of player
    public void removeDebuff(float ammount, String classOfDebuf) {

        switch (classOfDebuf) {
            case "armor":
                this.addArmorModifier(+(ammount));
        }
    }
}











