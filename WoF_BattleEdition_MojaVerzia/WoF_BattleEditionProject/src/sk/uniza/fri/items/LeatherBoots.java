package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class LeatherBoots implements IItem,IGear{

    private static final String usableName = "LeatherBoots";
    private static final String pozition = "boots";
    private static final float bonus = 1;

    @Override
    public void eguip(Player player) {

        player.setMaximuHealth(player.getMaximuHealth() + this.bonus);
        System.out.println("u equipd HealmOfHealth");

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
