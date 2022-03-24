package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class PotionOfHealtSmall implements IItem, IConsumable {

    private static final float healthBack = 20;
    private static final String useableName = "HealthPotionSmall";

    @Override
    public void consume(Player player) {
        player.heal(this.healthBack);
        System.out.println("using potion of healing");

    }

    @Override
    public String getName() {
        return "Small potion of healing";
    }

    @Override
    public String getDescription() {
        return "Heals 20 health";
    }

    @Override
    public String getUseName() {
        return this.useableName;
    }


}
