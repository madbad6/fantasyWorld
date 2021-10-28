package com.madbad;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Player("Player's name", 100, 5, 100, 50, 50);
        Hero skeleton = new Skeleton("Скелетон", 100, 3, 10, 20, 50);
        Hero goblin = new Goblin("Гоблин", 100, 2, 10, 30, 20);
        Hero[] heroesArray = new Hero[2];
        heroesArray[0] = skeleton;
        heroesArray[1] = goblin;
        Battle battle = new Battle();
        Market market = new Market();
        Random random = new Random();
        boolean isFinish = false;

        System.out.println("Добро пожаловать в игру!\n" +
                "Введите своё имя:");
        Scanner scanner = new Scanner(System.in);
        hero.setName(scanner.next());
        System.out.println("В нашем мире появился " + hero);
        do {
            System.out.println(hero.getName() + ", выберите действие:\n" +
                    "1. К торговцу\n" +
                    "2. В тёмный лес\n" +
                    "3. На выход\n");
            char operation = scanner.next().charAt(0);
            switch (operation) {
                case '1':
                    market.toShopping(hero);
                    break;
                case '2':
                    Hero ActiveEnemy = heroesArray[random.nextInt(2)];
                    System.out.println("На дороге встретился " + ActiveEnemy.getName() + ".\n" +
                            hero + "\n" +
                            ActiveEnemy + "\n" +
                            "И завязался бой не на жизнь, а на смерть!");
                    if (battle.fighting(hero, ActiveEnemy)) {
                        System.out.println("Жизнь прекрасна!");
                    } else {
                        System.out.println("Конец игры");
                        isFinish = true;
                    }
                    System.out.println("==============================================================");
                    break;
                case '3':
                    System.out.println("До свидания!");
                    isFinish = true;
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        }
        while (!isFinish);
    }
}