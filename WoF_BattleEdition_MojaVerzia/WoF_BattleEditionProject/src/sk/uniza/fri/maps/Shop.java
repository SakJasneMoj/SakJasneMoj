package sk.uniza.fri.maps;

import sk.uniza.fri.items.*;
import sk.uniza.fri.player.Player;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Shop extends Room {

    Scanner scanner = new Scanner(System.in);
    private HashMap<IItem, Float> tradeGoods = new HashMap<IItem, Float>();

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne
     * charakterizuje.
     *
     * @param popis text popisu miestnosti.
     */

    public Shop(String popis) {
        super(popis);
    }

    // constructor add inventory of shop and ask player if he wants to interact
    public void putShop(Player player) {
        this.tradeGoods = new HashMap<IItem, Float>();
        this.add();
        System.out.println("Do u wnat to buy somethihng");
        System.out.println("'yes' 'no'");
        String input = this.scanner.nextLine();

        if (input.equals("no")) {
            return;
        }

        this.buyWhat(player);
    }

    // add item to shop hash map inventory
    private void add() {
        this.tradeGoods.put(new BananOfDamage(), 20f);
        this.tradeGoods.put(new AppleOfHealth(), 10f);
        this.tradeGoods.put(new PotionOfHealthLarge(), 10f);
        return;
    }

    // compare input whit shop items and if it matches give player item and he pays with his actual health
    private void buyWhat(Player player) {
        Random random = new Random();
        System.out.println();

        for (IItem item : this.tradeGoods.keySet()) {
            String info = String.format("[%s] %.1f ", item.getName(), this.tradeGoods.get(item));
            System.out.println(info);
        }

        String input = this.scanner.nextLine();

        for (IItem item : this.tradeGoods.keySet()) {

            if (item.equals(input)) {
                player.addItemToInventory(item);
                player.takeDamage(this.tradeGoods.get(item));
                System.out.println("U bought " + item.getName());
            }
        }
    }
}
