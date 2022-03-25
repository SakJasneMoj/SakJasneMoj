package sk.uniza.fri.maps;

import sk.uniza.fri.items.SteelChestPlate;
import sk.uniza.fri.player.Player;

import java.util.Scanner;

public class TrapRoom extends Room{
    private float amountOfDamageTaken = 10;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne
     * charakterizuje.
     *
     * @param popis text popisu miestnosti.
     */

    public TrapRoom(String popis) {
        super(popis);
    }

    // trap witch force player to do something (write in this case) and do dmg if he dont do it
    // and rewards him if he answers right
    public boolean putTrap(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("pe? (0.00) ");
        String input = scanner.nextLine();

        if (input.equals("3.14")) {
            System.out.println("gj");
            player.addItemToInventory(new SteelChestPlate());
            return true;
        }else {
            player.setActualHealth(player.getActualHealth() - this.amountOfDamageTaken);
            return false;

        }
    }

    // returns damage of trap
    public float getAmountOfDamageTaken() {
        return amountOfDamageTaken;
    }
}
