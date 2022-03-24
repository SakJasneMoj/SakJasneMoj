package sk.uniza.fri.enemy;

import java.util.ArrayList;

public class SkeletonMage extends Skeleton implements IHealOthers {

    private int roundCounter = 0;
    private static final float DAMAGE = 50;
    private String name = "SkeletonMage";

    public SkeletonMage() {
        super.health = 20;
    }

    public void doDamage(ICreature creature) {
        if (this.roundCounter >= 2) {
            creature.takeDamage(this.DAMAGE);
            super.doDamage(creature);
            this.roundCounter = 0;
        } else {
            this.roundCounter += 1;
        }
    }

    @Override
    public String getName() {
        return name;
    }



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
