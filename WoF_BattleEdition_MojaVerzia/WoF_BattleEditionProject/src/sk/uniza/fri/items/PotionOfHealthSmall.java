package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class PotionOfHealthSmall implements IItem, IConsumable {

    // basic stats of item
    private static final float healthBack = 20;
    private static final String useableName = "HealthPotionSmall";

    // effect when player consume item
    @Override
    public void consume(Player player) {
        player.heal(this.healthBack);
        System.out.println("using potion of healing");
    }

    // return name of item
    @Override
    public String getName() {
        return "Small potion of healing";
    }

    // return description of item
    @Override
    public String getDescription() {
        return "Heals 20 health";
    }

    // return name used in comparing
    @Override
    public String getUseName() {
        return this.useableName;
    }
}
