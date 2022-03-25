package sk.uniza.fri.enemy;

import sk.uniza.fri.player.Player;

public class SkeletonArcher implements IDebufing {

    private String debufing = "armor";
    private int durationOfDebuf = 1;
    private float ammount = 1;
    private int counter = 0;
    private int round;

    public float getAmount() {
        return ammount;
    }

    // add debuf onto player
    @Override
    public void debuf(Player player, int round) {
        player.setDebuff(this.ammount, this.debufing);
        this.round = round;
        this.counter = this.counter + 1;
    }

    // return what we debufing on player
    @Override
    public String getClassOfDebuf() {
        return debufing;
    }

    // removes debuf from player
    @Override
    public boolean removeDebuf(Player player, int round) {

        if (this.counter == 0) {
            return false;
        }

        if (this.counter > 0) {
            this.counter = this.counter - 1;
        }

        if (this.counter <= 0 && this.round != round) {
            player.removeDebuff(this.ammount, this.debufing);
            return true;
        }

        return false;
    }
}
