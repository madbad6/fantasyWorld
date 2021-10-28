package com.madbad;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Market {
    public void toShopping(Hero aPlayer) {
        System.out.printf("ТОРГОВЕЦ: %s, добро пожаловать! Что ты хочешь от скромного торговца за свои %d золотых?\n",
                aPlayer.getName(), aPlayer.getGold());
        System.out.println(aPlayer.getName() + ", выберите действие:\n" + "1. Поправить здоровье (+10 за 1 монету)\n" +
                "2. Купить абонемент в фитнес (+5 силы и +5 ловкости за 1 монету)\n" + "3. Вернуться в город\n");
        Scanner scanner = new Scanner(System.in);
        char operation = scanner.next().charAt(0);
        switch (operation) {
            case '1':
                System.out.printf("ТОРГОВЕЦ: Сколько дней будем лечиться, %s? День отдыха (+10 к здоровью) за 1 монету.\n" +
                        "Введите количество монет (остаток монет = %d):", aPlayer.getName(), aPlayer.getGold());
                Integer gold1 = scanner.nextInt();
                toChange(aPlayer, "HealthForGold", gold1);
                break;
            case '2':
                System.out.printf("ТОРГОВЕЦ: Сколько дней будем тренироваться, %s? День тренировок за 1 монету +5 к силе и +5 к ловкости.\n" +
                        "Введите количество монет (остаток монет = %d):", aPlayer.getName(),aPlayer.getGold());
                Integer gold2 = scanner.nextInt();
                toChange(aPlayer, "PowerAndSkillForGold", gold2);
                break;
            case '3':
                break;
            default:
                System.out.println("Некорректный выбор");
        }
    }

    public void toChange(Hero aPlayer, String aType, Integer aGold) {
        switch (aType) {
            case "HealthForGold":
                if (aPlayer.getGold() >= aGold) {
                    aPlayer.setGold(aPlayer.getGold() - aGold);
                    System.out.printf("ТОРГОВЕЦ: %s,будем прокапываться с Вами %d д. \n", aPlayer.getName(), aGold);
                    aPlayer.setHealth(aPlayer.getHealth() + 10 * aGold);
                    for (int i = 1; i <= aGold; i++) {
                        System.out.printf("%d день лечения...\n", i);
                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.printf("ТОРГОВЕЦ: Уровень здоровья после лечения = %d, а золотых монет = %d\n\n", aPlayer.getHealth(), aPlayer.getGold());
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("ТОРГОВЕЦ: У вас нет столько монет! Можете заработать на убийстве тварей в лесу\n" + aPlayer);
                }
                break;
            case "PowerAndSkillForGold":
                if (aPlayer.getGold() >= aGold) {
                    aPlayer.setGold(aPlayer.getGold() - aGold);
                    System.out.printf("ТОРГОВЕЦ: %s, будем тренироваться с Вами %d д. \n", aPlayer.getName(), aGold);
                    aPlayer.setPower(aPlayer.getPower() + 5 * aGold);
                    aPlayer.setSkill(aPlayer.getSkill() + 5 * aGold);
                    for (int i = 1; i <= aGold; i++) {
                        System.out.printf("%dй день тренировок...\n", i);
                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.printf("ТОРГОВЕЦ: После тренировок сила = %d, ловкость = %d, а золотых монет = %d\nДо встречи!\n",
                            aPlayer.getPower(), aPlayer.getSkill(), aPlayer.getGold());
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("ТОРГОВЕЦ: У вас нет столько монет! Можете заработать на убийстве тварей в лесу.\nДо встречи!\n");
                }
                break;
            default:
                System.out.println("Некорректный ввод");
        }
    }
}
