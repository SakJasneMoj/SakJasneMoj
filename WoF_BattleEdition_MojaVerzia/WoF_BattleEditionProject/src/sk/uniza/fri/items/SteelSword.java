package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class SteelSword implements IItem,IGear {

    private static final String usableName = "SteelSword";
    private static final String pozition = "sword";
    private static final float bonus = 10;

    @Override
    public void eguip(Player player) {

    }

    @Override
    public void unEquip(Player player) {

    }

    @Override
    public String getPozition() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getUseName() {
        return null;
    }
}
