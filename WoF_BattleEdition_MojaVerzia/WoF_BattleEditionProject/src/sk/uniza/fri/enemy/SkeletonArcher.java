package sk.uniza.fri.enemy;

import sk.uniza.fri.player.Player;

public class SkeletonArcher implements IDebufing {

    private String debufing = "armor";
    private int durationOfDebuf = 1;
    private float ammount = 1;
    private int counter = 0;
    private int round;

    public float getAmmount() {
        return ammount;
    }

    @Override
    public void debuf(Player player, int round) {
        player.setDebufs(this.ammount, this.debufing);
        this.round = round;
        this.counter = this.counter + 1;
    }

    @Override
    public String getClassOfDebuf() {
        return debufing;
    }

    @Override
    public boolean removeDebuf(Player player, int round) {
        if (this.counter == 0) {
            return false;
        }
        if (this.counter > 0) {
            this.counter = this.counter - 1;
        }
        if (this.counter <= 0 && this.round != round) {
            player.removeDebufs(this.ammount, this.debufing);
            return true;
        }
        return false;
    }
}
