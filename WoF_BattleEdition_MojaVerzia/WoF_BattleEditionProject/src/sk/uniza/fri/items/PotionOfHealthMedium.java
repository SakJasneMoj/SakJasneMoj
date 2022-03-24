package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class PotionOfHealthMedium implements IItem , IConsumable{

    private static final float healthBack = 40;
    private static final String useableName = "HealthPotionMedium";

    @Override
    public void consume(Player player) {
        player.heal(this.healthBack);
        System.out.println("using potion of healing");

    }

    @Override
    public String getName() {
        return "Medium potion of healing";
    }

    @Override
    public String getDescription() {
        return "Heals 40 health";
    }

    @Override
    public String getUseName() {
        return this.useableName;
    }
}
