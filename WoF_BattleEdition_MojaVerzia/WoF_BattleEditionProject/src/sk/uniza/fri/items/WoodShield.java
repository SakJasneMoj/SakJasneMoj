package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class WoodShield implements IItem, IGear {

    private static final String usableName = "WoodShield";
    private static final String position = "shield";
    private static final float bonus = 5;

    // setting bonuses of item on to player
    @Override
    public void equip(Player player) {
        player.addArmorModifier(this.bonus);
        System.out.println("U equipped wooden shield onto ur off hand");
    }

    // removing bonuses of item on to player if he wears given item
    @Override
    public void unEquip(Player player) {
        player.removeArmorModifier(this.bonus);
        System.out.println("U unequipped wooden shield onto ur off hand");
    }

    // return where is item weared
    @Override
    public String getPosition() {
        return this.position;
    }

    // return showcase name
    @Override
    public String getName() {
        return "Wooden shield";
    }

    // return effects of item
    @Override
    public String getDescription() {
        return "This shield grand it wearer 5 armor";
    }

    //return name witch is use in methods to compare of player input
    @Override
    public String getUseName() {
        return this.usableName;
    }
}
