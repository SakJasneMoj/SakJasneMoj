package sk.uniza.fri.enemy;

import sk.uniza.fri.player.Player;

public interface IDebufing {

    float getAmmount();
    void debuf(Player player, int round);
    String getClassOfDebuf();
    boolean removeDebuf(Player player, int round);

}
