/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgsystem;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Faleon
 */
public abstract class Actor implements Serializable {

    protected String name;
    protected int armor;
    protected int magicResist;
    protected int basePower;
    protected int magicPower;
    protected int healthPoints;
    protected int experiencePoints;
    protected int wallet;
    protected LinkedList<Item> items = new LinkedList<>();
    
    //CONSTRUCTORS;
    
    //CONSTRUCTORS
    public Actor() {
    }

    public Actor(int armor, int magicRes, int basePwr, int hp, int magicPwr,
            String name) {
        this.armor = armor;
        this.magicResist = magicRes;
        this.basePower = basePwr;
        this.healthPoints = hp;
        this.magicPower = magicPwr;
        this.name = name;
    }

    public Actor(int armor, int magicRes, int basePwr, int hp, int magicPwr,
            String name, int wallet) {
        this.armor = armor;
        this.magicResist = magicRes;
        this.basePower = basePwr;
        this.healthPoints = hp;
        this.magicPower = magicPwr;
        this.name = name;
        this.wallet = wallet;
    }
    //END CONSTRUCTORS

    //GET METHODS
    //return actor's name
    public String getName() {
        return name;
    }
    
    //return actor's armor
    public int getArmor() {
        return armor;
    }
    
    //return actor's magic resist
    public int getMagicResist() {
        return magicResist;
    }
    
    //return the amount an actor can hit for without any weapon
    public int getBasePower() {
        return basePower;
    }
    
    //return an actor's damage done for magic attacks
    public int getMagicPower() {
        return magicPower;
    }
    
    //return the actor's current health points
    public int getHealthPoints() {
        return healthPoints;
    }
    
    //return the actor's current experience points
    public int getExperiencePoints() {
        return experiencePoints;
    }
    
    //return the amount of money an actor has
    public int getWallet() {
        return wallet;
    }
    
    //return the inventory or items an acotr has
    public LinkedList<Item> getItems() {
        return items;
    }
    //END GET METHODS

    //SET METHODS
    //set items
    public void setItems(LinkedList<Item> items) {
        this.items = items;
    }
    
    //change an actor's armor amount
    public void setArmor(int armor) {
        if (armor > 0) {
            this.armor = armor;
        } else {
            this.armor = 0;
        }
    }
    
    //change an actor's magic resist
    public void setMagicResist(int magicResist) {
        if (magicResist > 0) {
            this.magicResist = magicResist;
        } else {
            this.magicResist = 0;
        }
    }
    
    //change an actor's base power
    public void setBasePower(int basePower) {
        if (basePower > 0) {
            this.basePower = basePower;
        } else {
            this.basePower = 0;
        }
    }
    
    //change an actor's magic power
    public void setMagicPower(int magicPower) {
        if (magicPower > 0) {
            this.magicPower = magicPower;
        } else {
            this.magicPower = 0;
        }
    }
    
    //change an actor's current health points
    public void setHealthPoints(int healthPoints) {
        if (healthPoints > 0) {
            this.healthPoints = healthPoints;
        } else {
            this.healthPoints = 0;
        }
    }
    
    //change an actor's wealth
    public void setWallet(int wallet) {
        if (wallet > 0) {
            this.wallet = wallet;
        } else {
            this.wallet = 0;
        }
    }
    //END SET METHODS

    //update stats after taking damage
    public void updateStats(int calculatedDamage) {
        setHealthPoints(healthPoints - calculatedDamage);
    }
    
    //add item to inventory
    public void addItem(Item item){
        items.add(item);
    }
}
