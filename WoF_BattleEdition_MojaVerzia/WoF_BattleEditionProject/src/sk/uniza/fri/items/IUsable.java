package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public interface IUsable {

    void use(Player player);
    void loverCooldown();
    int getActualCooldown();
    void endBonuses(Player player);
    int getActualdurationInRooms();
    void setActualdurationInRooms(int actualdurationInRooms);
    int getDurationsInRooms();
}
