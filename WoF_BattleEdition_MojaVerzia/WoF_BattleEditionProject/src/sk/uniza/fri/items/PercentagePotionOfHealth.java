package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class PercentagePotionOfHealth implements IConsumable, IItem{

    // effect when player consume item
    @Override
    public void consume(Player player) {
        player.heal(player.getMaximumHealth()/20);
    }

    // return name of item
    @Override
    public String getName() {
        return "Small percentage potion of healing";
    }

    // return description of item
    @Override
    public String getDescription() {
        return "Heals 20% health";
    }

    // return name used in comparing
    @Override
    public String getUseName() {
        return null;
    }
}
