package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

import java.util.ArrayList;

public class HealmOfHealth implements IItem, IGear{
    private static final String usableName = "HealmOfHealt";
    private static final String pozition = "helm";
    private static final float bonus = 20;




    @Override
    public void eguip(Player player) {

        player.setMaximuHealth(player.getMaximuHealth() + this.bonus);
        System.out.println("u equipd HealmOfHealth");
    }

    @Override
    public void unEquip(Player player) {

        player.setMaximuHealth(player.getMaximuHealth() - this.bonus);
        if (player.getActualHealth() > player.getMaximuHealth()){
         player.setActualHealth(player.getMaximuHealth());
        }
        System.out.println("U unequipd HealmOfHealth");

    }

    @Override
    public String getPozition() {
     return this.pozition;
    }

    @Override
    public String getName() {
        return "HealmOfHealt";
    }

    @Override
    public String getDescription() {
        return "this helm grand it wearer 20 maximum hp";
    }

    @Override
    public String getUseName() {
        return this.usableName;
    }
}
   /* ArrayList<IGear> inventory = player.getEquipdGear();
       for (IGear gerIteam: inventory) {
            System.out.println("snazis sa obliect si nieco");
            if (gerIteam.getPozition().equals(null)) {
                inventory.add(this);
                player.setMaximuHealth(player.getMaximuHealth() + this.bonus);
                player.setEquipdGear(inventory);
                System.out.println("U equipd " + this.usableName);

            }

            if (gerIteam.getPozition().equals(this.pozition)) {
                gerIteam.unEquip(player);
                inventory.remove(gerIteam);
                inventory.add(this);
                player.setMaximuHealth(player.getMaximuHealth()- this.bonus);
                player.setEquipdGear(inventory);
                System.out.println("U equipd " + this.usableName);

            }
        }*/