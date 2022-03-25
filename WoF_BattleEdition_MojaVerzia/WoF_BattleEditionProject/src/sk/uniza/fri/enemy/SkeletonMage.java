package sk.uniza.fri.enemy;

import java.util.ArrayList;

public class SkeletonMage extends Skeleton implements IHealOthers {

    private int roundCounter = 0;
    private static final float DAMAGE = 50;
    private String name = "SkeletonMage";

    // change health of creature
    public SkeletonMage() {
        super.health = 20;
    }

    // modified to do damage every 3th round
    public void doDamage(ICreature creature) {

        if (this.roundCounter >= 2) {
            creature.takeDamage(this.DAMAGE);
            super.doDamage(creature);
            this.roundCounter = 0;
        } else {
            this.roundCounter += 1;
        }
    }

    // returns name of creature
    @Override
    public String getName() {
        return name;
    }

    // heal this creature and all others in room
    @Override
    public void healCreatures(ArrayList<ICreature> creatures) {
        float healAmount = 10;

        for (ICreature creature: creatures) {

            if (!creature.isDead()) {
                creature.heal(healAmount);
            }
        }
    }
}
