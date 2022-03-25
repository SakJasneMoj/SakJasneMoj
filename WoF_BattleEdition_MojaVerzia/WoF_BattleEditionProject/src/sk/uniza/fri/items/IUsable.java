package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public interface IUsable {

    void use(Player player);

    void loverCoolDown();

    int getActualCoolDown();

    void endBonuses(Player player);

    int getActualDurationInRooms();

    void setActualDurationInRooms(int actualDurationInRooms);

    int getDurationsInRooms();
}
