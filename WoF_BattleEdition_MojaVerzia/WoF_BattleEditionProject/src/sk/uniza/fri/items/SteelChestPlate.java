package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class SteelChestPlate implements IItem,IGear{

    private static final String usableName = "SteelChestPlate";
    private static final String pozition = "chestArmor";
    private static final float bonus = 3;

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
