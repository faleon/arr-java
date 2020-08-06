/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgsystem;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author huazhong
 */
public class Profession implements Serializable {

    private String title;
    private LinkedList<Attack> attacks = new LinkedList<>();
    private int baseArmor;
    private int baseMagicResist;
    private int initialPower;
    private int baseMagicPower;
    private int baseHP;
    private int baseMP;

    //CONSTRUCTORS
    public Profession() {
    }
    
    public Profession(String title, int armor, int magicResist, int power,
            int magicPower, int hp, int mp){
        this.title = title;
        this.baseArmor = armor;
        this.baseMagicResist = magicResist;
        this.initialPower = power;
        this.baseMagicPower = magicPower;
        this.baseHP = hp;
        this.baseMP = mp;
    }
    //END CONSTRUCTORS

    public void addAttack(Attack attack) {
        attacks.add(attack);
    }

    public LinkedList<Attack> getAttacks() {
        return attacks;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the baseArmor
     */
    public int getBaseArmor() {
        return baseArmor;
    }

    /**
     * @return the baseMagicResist
     */
    public int getBaseMagicResist() {
        return baseMagicResist;
    }

    /**
     * @return the initialPower
     */
    public int getInitialPower() {
        return initialPower;
    }

    /**
     * @return the baseMagicPower
     */
    public int getBaseMagicPower() {
        return baseMagicPower;
    }

    /**
     * @return the baseHP
     */
    public int getBaseHP() {
        return baseHP;
    }

    /**
     * @return the baseMP
     */
    public int getBaseMP() {
        return baseMP;
    }
}
