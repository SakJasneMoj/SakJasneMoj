package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class PotionOfHealthLarge implements IItem,IConsumable{

    private static final float healthBack = 60;
    private static final String useableName = "HealthPotionLarge";

    @Override
    public void consume(Player player) {
        player.heal(this.healthBack);
        System.out.println("using potion of healing");

    }

    @Override
    public String getName() {
        return "large potion of healing";
    }

    @Override
    public String getDescription() {
        return "Heals 60 health";
    }

    @Override
    public String getUseName() {
        return this.useableName;
    }
}
