package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class WoodShield implements IItem,IGear{

    private static final String usableName = "WoodShield";
    private static final String pozition = "shield";
    private static final float bonus = 5;



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
