package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class HelmOfHealth implements IItem, IGear {
    private static final String usableName = "HelmOfHealth";
    private static final String pozition = "helm";
    private static final float bonus = 20;

    // setting bonuses of item on to player
    @Override
    public void equip(Player player) {
        player.setMaximumHealth(player.getMaximumHealth() + this.bonus);
        System.out.println("u equipped Helm of Health");
    }

    // removing bonuses of item on to player if he wears given item
    @Override
    public void unEquip(Player player) {
        player.setMaximumHealth(player.getMaximumHealth() - this.bonus);

        if (player.getActualHealth() > player.getMaximumHealth()) {
            player.setActualHealth(player.getMaximumHealth());
        }

        System.out.println("U unequipped Helm of Health");

    }

    // return where is item weared
    @Override
    public String getPosition() {
        return this.pozition;
    }

    // return showcase name
    @Override
    public String getName() {
        return "Helm of Health";
    }

    // return effects of item
    @Override
    public String getDescription() {
        return "This helm grand it wearer 20 maximum hp";
    }

    //return name witch is use in methods to compare of player input
    @Override
    public String getUseName() {
        return this.usableName;
    }
}