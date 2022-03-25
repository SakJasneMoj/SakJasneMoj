package sk.uniza.fri.game;

import sk.uniza.fri.enemy.ICreature;
import sk.uniza.fri.enemy.IDebufing;
import sk.uniza.fri.enemy.IHealOthers;
import sk.uniza.fri.items.IItem;
import sk.uniza.fri.maps.Room;
import sk.uniza.fri.player.Player;

import java.util.ArrayList;
import java.util.Random;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class BattleManager {

    private int round;
    private float shortTearmArmorDebufs;
    private ArrayList<ICreature> enemiesInRoom;
    private Player player;
    private Room room;


    private final ArrayList<IItem> rewards = new ArrayList<IItem>();

    public boolean startFight(Player player, Room room, Game game) {
        this.player = player;
        this.room = room;


        this.shortTearmArmorDebufs = 0;


        player.reduceCoolDownOfUseItems();

        // ziadny nepriatelia v miestnosti
        if (enemiesInRoom == null) {
            return player.isDead();
        }

        if (!this.enemiesInRoom.isEmpty()) {
        System.out.println(" [" + this.enemiesInRoom.size() + " nepriatelov v miestnosti]");
        }
        this.round = 0;


        return player.isDead();

    }

    public boolean fight() {
        this.enemiesInRoom = this.room.getEnemiesInRoom();

        if (!this.enemiesInRoom.isEmpty()) {
            // start of round
            this.round += 1;


            for (ICreature creature : this.enemiesInRoom) {
                if (creature.isDead()) {
                    continue;
                }
                if (this.player.isDead()) {
                    System.out.println("-----------------------");
                    System.out.println("You died.");
                    System.out.println("-----------------------");
                    return true;
                }


                this.player.doDamage(creature);
                creature.doDamage(this.player);

                if (creature instanceof IDebufing) {
                    ((IDebufing) creature).debuf(this.player, this.round);
                    this.shortTearmArmorDebufs = this.shortTearmArmorDebufs + ((IDebufing) creature).getAmount();

                }

                if (creature instanceof IDebufing) {
                    if (((IDebufing) creature).removeDebuf(this.player, this.round)) {
                        this.shortTearmArmorDebufs = this.shortTearmArmorDebufs - ((IDebufing) creature).getAmount();
                    }
                }

                if (creature instanceof IHealOthers) {
                    ((IHealOthers) creature).healCreatures(this.enemiesInRoom);
                }


            }

            this.enemiesInRoom = this.removeDeadEnemies(this.enemiesInRoom);
            this.printBattleSummaryAfterRound(this.enemiesInRoom, this.round, this.player);

            this.player.addArmorModifier(this.shortTearmArmorDebufs);
        }

        return this.player.isDead();
    }

    private ArrayList<ICreature> removeDeadEnemies(ArrayList<ICreature> enemiesInRoom) {
        ArrayList<ICreature> enemiesAlive = new ArrayList<ICreature>();
        for (ICreature creature : enemiesInRoom) {
            if (!creature.isDead()) {
                enemiesAlive.add(creature);
            }
        }
        return enemiesAlive;
    }

    private void printBattleSummaryAfterRound(ArrayList<ICreature> enemies, int round, Player player) {
        System.out.println("Round " + round + ": ");
        System.out.println(String.format("[Player] %.2f HP", player.getActualHealth()));
        int index = 0;
        for (ICreature enemy : enemies) {
            if (!enemy.isDead()) {
                String formatted = String.format("[Enemy %d] has %.2f HP, ", index, enemy.getActualHealth());
                System.out.print(formatted);
            } else {
                System.out.print("[Enemy " + index + "] is dead, ");
            }
            index += 1;
        }
        System.out.println();
        System.out.println("--------------------------------");
    }

    private IItem getRandomReward() {
        Random rand = new Random();
        return this.rewards.get(rand.nextInt(0, this.rewards.size()));
    }
}
