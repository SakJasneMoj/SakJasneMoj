package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class PotionOfDamageSmall implements IItem,IConsumable,IConsumableWhitDurationEfect{

    // basic stats of item
    private static final float damageBonus = 5;
    private static final String useableName = "DamagePotionSmall";
    private static final int durationInRounds = 2;
    private int actualdurationInRounds = 0;

    // effect when player consume item
    @Override
    public void consume(Player player) {

    }

    // return duration of effect
    @Override
    public void getDuration() {

    }

    //get how much remains of cool down
    @Override
    public void getActualDuration() {

    }

    // remove effect
    @Override
    public void removeEffect() {

    }

    // return name of item
    @Override
    public String getName() {
        return "Potion of damage small";
    }

    // return description of item
    @Override
    public String getDescription() {
        return "this potion grads 5 dmg for 2 rounds";
    }

    // return name used in comparing
    @Override
    public String getUseName() {
        return this.useableName;
    }
}
