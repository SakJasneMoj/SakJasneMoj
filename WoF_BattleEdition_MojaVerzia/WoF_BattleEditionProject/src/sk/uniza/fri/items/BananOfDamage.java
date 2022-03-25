package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class BananOfDamage implements IItem, IUsable {

    private static final String usableName = "BananaOfDamage";
    private static final float DAMAGE_MODIFIER = 5;
    private boolean wasUsed = false;
    private static final int cooldown = 2;
    private int actualCooldown = 0;
    private static final int durationInRooms = 1;
    private int actualdurationInRooms = 0;

    // returns cool down effect counted in moving through rooms
    public int getActualDurationInRooms() {
        return this.actualdurationInRooms;
    }

    //
    public void setActualDurationInRooms(int actualDurationInRooms) {
        this.actualdurationInRooms = actualDurationInRooms;
    }

    @Override
    public int getDurationsInRooms() {
        return this.durationInRooms;
    }


    @Override
    public String getName() {
        return "Banana of Damage";
    }

    @Override
    public String getDescription() {
        return String.format("For next fight player has %.1f damage!", this.DAMAGE_MODIFIER);
    }

    @Override
    public String getUseName() {
        return this.usableName;
    }

    @Override
    public void use(Player player) {

        if (!this.wasUsed) {
            if (this.actualCooldown < 1) {
                player.addDamageModifier(this.DAMAGE_MODIFIER);
                System.out.println("Used banana of damage");
                this.actualCooldown = this.cooldown;
                this.wasUsed = true;
                return;
            }
        }

        System.out.println("This item is on cool down effect " + this.actualCooldown);
    }

    @Override
    public void loverCoolDown() {
        this.actualCooldown = this.actualCooldown - 1;

        if (this.actualCooldown < 0) {
            this.wasUsed = false;
        }
    }

    @Override
    public int getActualCoolDown() {
        return this.actualCooldown;
    }

    @Override
    public void endBonuses(Player player) {
        player.addDamageModifier(-(this.DAMAGE_MODIFIER));
    }
}








