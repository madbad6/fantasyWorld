package com.madbad;

public class Hero {
    private String name;
    private int health;
    private int gold;
    private int experience;
    private int power;
    private int skill;

    public Hero(String name, int health, int gold, int experience, int power, int skill) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.experience = experience;
        this.power = power;
        this.skill = skill;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }


    @Override
    public String toString() {
        return
                name +
                        "здоровье:" + health +
                        ", золото:" + gold +
                        ", опыт:" + experience +
                        ", сила:" + power +
                        ", ловкость:" + skill;
    }
}