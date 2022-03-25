package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class SteelSword implements IItem,IGear {

    private static final String usableName = "SteelSword";
    private static final String position = "sword";
    private static final float bonus = 10;

    // setting bonuses of item on to player
    @Override
    public void equip(Player player) {
        player.addDamageModifier(this.bonus);
        System.out.println("U took steel sword to ur main hand");
    }

    // removing bonuses of item on to player if he wears given item
    @Override
    public void unEquip(Player player) {
        player.removeDamageModifier(this.bonus);
        System.out.println("U dropped steel sword from ur main hand ");
    }

    // return where is item weared
    @Override
    public String getPosition() {
        return this.position;
    }

    // return showcase name
    @Override
    public String getName() {
        return "Steel sword";
    }

    // return effects of item
    @Override
    public String getDescription() {
        return "This sword grand it wearer 10 damage";
    }

    //return name witch is use in methods to compare of player input
    @Override
    public String getUseName() {
        return this.usableName;
    }}
