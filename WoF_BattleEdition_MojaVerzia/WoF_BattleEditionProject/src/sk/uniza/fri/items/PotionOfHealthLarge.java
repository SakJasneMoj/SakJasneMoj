package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class PotionOfHealthLarge implements IItem,IConsumable{

    // basic stats of item
    private static final float healthBack = 60;
    private static final String useableName = "HealthPotionLarge";

    // effect when player consume item
    @Override
    public void consume(Player player) {
        player.heal(this.healthBack);
        System.out.println("using potion of healing");
    }

    // return name of item
    @Override
    public String getName() {
        return "large potion of healing";
    }

    // return description of item
    @Override
    public String getDescription() {
        return "Heals 60 health";
    }

    // return name used in comparings
    @Override
    public String getUseName() {
        return this.useableName;
    }
}
