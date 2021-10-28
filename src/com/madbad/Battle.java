package com.madbad;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Battle {
    public boolean fighting(Hero aPlayer, Hero aEnemy) {
        boolean isOdd = false;

        while ((aPlayer.getHealth() > 0) && (aEnemy.getHealth() > 0)) {
            System.out.println("*****");
            System.out.printf("Здоровье: %s:%d, %s:%d\n", aEnemy.getName(), aEnemy.getHealth(), aPlayer.getName(), aPlayer.getHealth());
            try {
                if (isOdd) {
                    logicBattle(aPlayer, aEnemy);
                } else {
                    logicBattle(aEnemy, aPlayer);
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            isOdd = !isOdd;
        }
        if (aPlayer.getHealth() > 0) {
            aPlayer.setGold(aPlayer.getGold() + aEnemy.getGold());
            aPlayer.setExperience(aPlayer.getExperience() + aEnemy.getExperience());
            System.out.printf("Мы отбили у %sа %d золотых и повысили свой опыт на %d до %d\n", aEnemy.getName(), aEnemy.getGold(), aEnemy.getExperience(), aPlayer.getExperience());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (aEnemy instanceof Skeleton) {
                aEnemy.setHealth(100);
                aEnemy.setGold(3);
                aEnemy.setExperience(10);
            } else {
                aEnemy.setHealth(100);
                aEnemy.setGold(2);
                aEnemy.setExperience(10);
            }
            return true;
        } else {
            aEnemy.setGold(aEnemy.getGold() + aPlayer.getGold());
            aEnemy.setExperience(aEnemy.getExperience() + aPlayer.getExperience());
            System.out.printf("%s убил вас и забрал всё, чтобы было нажито непосильным трудном - %d золотых\n", aEnemy.getName(), aPlayer.getGold());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public void logicBattle(Hero hero1, Hero hero2) throws InterruptedException {
        Random random = new Random();
        System.out.print(hero1.getName() + " нанёс удар и ...");
        TimeUnit.SECONDS.sleep(4);
        if (random.nextBoolean()) {
            if ((hero1.getSkill() * 3) > random.nextInt(100)) {
                System.out.println(" ЗАЦЕПИЛ!");
                hero2.setHealth(hero2.getHealth() - hero1.getPower());
                TimeUnit.SECONDS.sleep(2);
                System.out.printf("%s нанёс урон здоровью -%d\n", hero1.getName(), hero1.getPower());
            } else {
                System.out.println(" промахнулся!");
            }
        } else {
            System.out.println(" промахнулся!");
        }
        TimeUnit.SECONDS.sleep(2);
    }
}
