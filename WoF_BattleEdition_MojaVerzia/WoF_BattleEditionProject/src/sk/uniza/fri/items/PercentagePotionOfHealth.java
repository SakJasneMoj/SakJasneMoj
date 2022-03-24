package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class PercentagePotionOfHealth implements IConsumable, IItem{
    @Override
    public void consume(Player player) {

        player.heal(player.getMaximuHealth()/20);
    }

    @Override
    public String getName() {
        return "Small percentage potion of healing";
    }

    @Override
    public String getDescription() {
        return "Heals 20% health";
    }

    @Override
    public String getUseName() {
        return null;
    }
}
