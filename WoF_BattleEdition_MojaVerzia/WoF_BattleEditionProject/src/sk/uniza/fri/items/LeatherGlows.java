package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class LeatherGlows implements IItem, IGear {

    private static final String usableName = "LeatherGlows";
    private static final String position = "glows";
    private static final float bonus = 1;

    // setting bonuses of item on to player
    @Override
    public void equip(Player player) {
        player.addArmorModifier(this.bonus);
        System.out.println("U equipped leather glows");
    }

    // removing bonuses of item on to player if he wears given item
    @Override
    public void unEquip(Player player) {
        player.removeArmorModifier(this.bonus);
        System.out.println("U unequipped leather glows");
    }

    // return where is item weared
    @Override
    public String getPosition() {
        return this.position;
    }

    // return showcase name
    @Override
    public String getName() {
        return "Leather glows";
    }

    // return effects of item
    @Override
    public String getDescription() {
        return "This glows grand it wearer 1 armor";
    }

    //return name witch is use in methods to compare of player input
    @Override
    public String getUseName() {
        return this.usableName;
    }
}
