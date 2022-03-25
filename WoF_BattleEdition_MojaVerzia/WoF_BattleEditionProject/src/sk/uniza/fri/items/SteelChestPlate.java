package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class SteelChestPlate implements IItem,IGear{

    private static final String usableName = "SteelChestPlate";
    private static final String position = "chestArmor";
    private static final float bonus = 3;

    // setting bonuses of item on to player
    @Override
    public void equip(Player player) {
        player.addArmorModifier(this.bonus);
        System.out.println("U equipped steel chest plate");
    }

    // removing bonuses of item on to player if he wears given item
    @Override
    public void unEquip(Player player) {
        player.removeArmorModifier(this.bonus);
        System.out.println("U equipped steel chest plate");
    }

    // return where is item weared
    @Override
    public String getPosition() {
        return this.position;
    }

    // return showcase name
    @Override
    public String getName() {
        return "Steel plate chest";
    }

    // return effects of item
    @Override
    public String getDescription() {
        return "This plate grand it wearer 3 armor";
    }

    //return name witch is use in methods to compare of player input
    @Override
    public String getUseName() {
        return this.usableName;
    }
}
