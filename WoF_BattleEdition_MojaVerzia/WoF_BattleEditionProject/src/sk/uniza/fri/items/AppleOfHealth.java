package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class AppleOfHealth implements IItem, IUsable {

    private static final String usableName = "AppleOfHealt";
    private static final float HEALTH_ADD = 1;
    private static final int cooldown = 3;
    private int actualCooldown = 0;
    private boolean wasUsed = false;
    private static final int durationInRooms = 1;
    private int actualdurationInRooms = 0;


    public int getDurationInRooms() {
        return this.durationInRooms;
    }

    @Override
    public String getName() {
        return "Apple of health";
    }

    @Override
    public String getDescription() {
        return "Each round add 1 HP";
    }

    @Override
    public String getUseName() {
        return this.usableName;
    }

    @Override
    public void use(Player player) {


        if (!this.wasUsed) {
            if (this.actualCooldown < 1) {
                player.heal(this.HEALTH_ADD);
                System.out.println("Used apple of health");
                this.actualCooldown = this.cooldown;
                this.wasUsed = true;
            }
        }
        System.out.println("this iteam is on cooldown " + this.actualCooldown);

    }

    @Override
    public void loverCooldown() {
        this.actualCooldown = this.actualCooldown - 1;
        if (this.actualCooldown < 0) {
            this.wasUsed = false;
        }
    }

    @Override
    public int getActualCooldown() {
        return this.actualCooldown;
    }

    @Override
    public void endBonuses(Player player) {

    }

    @Override
    public int getActualdurationInRooms() {
        return this.actualdurationInRooms;
    }

    @Override
    public void setActualdurationInRooms(int actualdurationInRooms) {
        this.actualdurationInRooms = actualdurationInRooms;
    }

    @Override
    public int getDurationsInRooms() {
        return this.durationInRooms;
    }
}
