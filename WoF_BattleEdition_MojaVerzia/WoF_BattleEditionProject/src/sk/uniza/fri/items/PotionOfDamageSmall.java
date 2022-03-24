package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class PotionOfDamageSmall implements IItem,IConsumable,IConsumableWhitDurationEfect{

    private static final float damageBonus = 5;
    private static final String useableName = "DamagePotionSmall";

    private static final int durationInRounds = 2;
    private int actualdurationInRounds = 0;


    @Override
    public void consume(Player player) {

    }

    @Override
    public void getDuration() {

    }

    @Override
    public void getActualDuration() {

    }

    @Override
    public void removeEffect() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "this potion grads 5 dmg for 2 rounds";
    }

    @Override
    public String getUseName() {
        return this.useableName;
    }
}
