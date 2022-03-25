package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class SteelPants implements IItem,IGear{

    private static final String usableName = "SteelPants";
    private static final String position = "pants";
    private static final float bonus = 2;

    // setting bonuses of item on to player
    @Override
    public void equip(Player player) {
        player.addArmorModifier(this.bonus);
        System.out.println("U equipped steel pants");
    }

    // removing bonuses of item on to player if he wears given item
    @Override
    public void unEquip(Player player) {
        player.removeArmorModifier(this.bonus);
        System.out.println("U unequipped steel pants");
    }

    // return where is item weared
    @Override
    public String getPosition() {
        return this.position;
    }

    // return showcase name
    @Override
    public String getName() {
        return "Steel pants";
    }

    // return effects of item
    @Override
    public String getDescription() {
        return "This pants grand it wearer 2 armor";
    }

    //return name witch is use in methods to compare of player input
    @Override
    public String getUseName() {
        return this.usableName;
    }
}
