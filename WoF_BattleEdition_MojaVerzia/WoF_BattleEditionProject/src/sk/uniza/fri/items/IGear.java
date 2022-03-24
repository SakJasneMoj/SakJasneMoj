package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public interface IGear {

    void eguip(Player player);
    void unEquip(Player player);
    String getPozition();
}
