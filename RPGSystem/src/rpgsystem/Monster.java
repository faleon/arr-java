/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgsystem;

import java.util.LinkedList;

/**
 *
 * @author Faleon
 */
public class Monster extends Actor {

    private int tier;
    private Attack[] attacks = new Attack[3];
    private int maxHp;

    public Monster() {
    }

    ;
    
    public Monster(int armor, int magicRes, int basePwr, int hp,
            String name, int xp, int tier, int wallet) {
        super(armor, magicRes, basePwr, hp, 0, name, wallet);
        experiencePoints = xp;
        this.tier = tier;
        maxHp = healthPoints;
    }

    public Attack decideAttack() {
        int randNum = RPGSystem.getRandomNum(attacks.length);
        if (attacks[randNum] != null) {
            return attacks[randNum];
        } else {
            return null;
        }
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    @Override
    public void setHealthPoints(int healthPoints) {
        if (healthPoints > 0 && healthPoints <= maxHp) {
            this.healthPoints = healthPoints;
        } else if (healthPoints <= 0) {
            this.healthPoints = 0;
        } else {
            this.healthPoints = maxHp;
        }
    }

    public void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }

    public int getAttacksLimit() {
        return attacks.length;
    }

    public void resetStatus() {
        healthPoints = maxHp;
        attacks = new Attack[3];
        items = new LinkedList<>();
    }
}
