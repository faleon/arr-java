/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgsystem;

import java.util.*;

/**
 *
 * @author Faleon
 */
public class Character extends Actor {
    
    private int level = 1;
    private int magicPoints;
    private int maxHp;
    private int maxMp;
    private Profession profession;

    //CONSTRUCTORS
    public Character() {
    }

    //normal mode constructor
    public Character(String name, Profession profession) {
        super(profession.getBaseArmor(),
                profession.getBaseMagicResist(),
                profession.getInitialPower(),
                profession.getBaseHP(),
                profession.getBaseMagicPower(),
                name);
        magicPoints = profession.getBaseMP();
        this.profession = profession;
        maxHp = healthPoints;
        maxMp = magicPoints;
    }

    //cheater constructor
    public Character(int armor, int magicRes, int basePwr, int hp, int magicPwr,
            String name, int wallet, int mp, Profession profession) {
        super(armor, magicRes, basePwr, hp, magicPwr, name, wallet);
        magicPoints = mp;
        this.profession = profession;
        maxHp = healthPoints;
        maxMp = magicPoints;
    }
    //END CONSTRUCTORS

    //GET METHODS
    //return level
    public int getLevel() {
        return level;
    }

    //return amount of magic points character has
    public int getMagicPoints() {
        return magicPoints;
    }

    //return character's max hit points
    public int getMaxHp() {
        return maxHp;
    }

    //return character's max magic points
    public int getMaxMp() {
        return maxMp;
    }

    //return the character's profession
    public Profession getProfession() {
        return profession;
    }

    //return all of the character's usable items(potions)
    public LinkedList<Item> getUsableItems() {
        LinkedList<Item> usableItems = new LinkedList<>();
        if (items != null) {                                   //added by Yuan, otherwise nullpointerexception
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) instanceof Potion) {
                    usableItems.add(items.get(i));
                }
            }
        }
        return usableItems;
        
    }

    //return all of the character's available attacks
    public LinkedList<Attack> getUsableAttacks() {
        LinkedList<Attack> allAttacks = profession.getAttacks();
        if (level <= 10) {
            LinkedList<Attack> attacksToReturn = new LinkedList<>();
            for (int i = level - 1; i >= 0; i--) {
                attacksToReturn.add(allAttacks.get(i));
            }
            return attacksToReturn;
        } else {
            return allAttacks;
        }
    }

    //return all of character's weapons
    public LinkedList<Weapon> getWeapons() {
        LinkedList<Weapon> weapons = new LinkedList<>();
        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) instanceof Weapon) {
                    weapons.add((Weapon) items.get(i));
                }
            }
        }
        return weapons;
    }

    //return all of character's armors
    public LinkedList<Armor> getArmors() {
        LinkedList<Armor> armors = new LinkedList<>();
        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) instanceof Armor) {
                    armors.add((Armor) items.get(i));
                }
            }
        }
        return armors;
    }
    //END GET METHODS

    //SET METHODS
    //change a character's current health points
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

    //change a character's current magic points
    public void setMagicPoints(int magicPoints) {
        if (magicPoints > 0 && magicPoints <= maxMp) {
            this.magicPoints = magicPoints;
        } else if (magicPoints < 0) {
            this.magicPoints = 0;
        } else {
            this.magicPoints = maxMp;
        }
    }
    //END SET METHODS

    //check experience points and level up character
    public void levelUp() {
        if (experiencePoints >= 500 && level <= 5) {
            level++;
            maxHp += 10;
            maxMp += 5;
            magicPoints = maxMp;
            healthPoints = maxHp;
            basePower += 3;
            magicPower +=3;
            magicResist += 2;
            armor += 1;
            
            experiencePoints -= 500;
        } else if (experiencePoints >= 1000 && level <= 10) {
            level++;
            maxHp += 15;
            maxMp += 10;
            magicPoints = maxMp;
            healthPoints = maxHp;
            basePower += 5;
            magicPower +=5;
            magicResist += 3;
            armor += 2;
            
            experiencePoints -= 1000;
            
            if (level == 10) {
            WinMessageGUI winMenu = new WinMessageGUI();
            winMenu.setLocationRelativeTo(null);
            winMenu.setVisible(true);
        }
        } else if (experiencePoints >= 2000) {
            level++;
            maxHp += 20;
            maxMp += 15;
            magicPoints = maxMp;
            healthPoints = maxHp;
            basePower += 6;
            magicPower +=6;
            magicResist += 5;
            armor += 3;
            
            experiencePoints -= 2000;
        }
    }

    //recover health points or magic points
    public void updateStats(int amountRecovered, String type) {
        if (type.equals("hp")) {
            setHealthPoints(healthPoints + (maxHp / amountRecovered));
        } else {
            setMagicPoints(magicPoints + (maxMp / amountRecovered));
        }
    }

    //use a potion
    public void drinkPotion(Potion potion) {
        updateStats(potion.getRecoverAmount(), potion.getType());

        //search for potion in inventory
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Potion) {
                Potion potionInInventory = (Potion) (items.get(i));

                //remove potion if names are the same
                if ((potion.getName()).equals(potionInInventory.getName())) {
                    items.remove(i);
                    return;
                }
            }
        }
    }

//    //use a potion when given a potion name, Potion potion for storing reference
//    public void drinkPotion(String pName, Potion potion) {
//        for (int i = 0; i < items.size(); i++) {
//            if (items.get(i) instanceof Potion) {
//                potion = (Potion) (items.get(i));
//                if ((potion.getName()).equals(pName)) {
//                    updateStats(potion.getRecoverAmount(), potion.getType());
//                    items.remove(i);
//                }
//            }
//        }
//    }
    //add experience and try to level character up
    public void addExperiencePoints(int experiencePoints) {
        this.experiencePoints += experiencePoints;
        levelUp();
    }

    //equip an item
    public void equipItem(Item item) {
        if (item instanceof Armor) {
            Armor armorItem = (Armor) item;
            this.armor += armorItem.getArmorValue();
            this.magicResist += armorItem.getMagicResistValue();
            armorItem.setIsEquipped(true);
            
        } else {
            Weapon weapon = (Weapon) item;
            this.basePower += weapon.getPowerValue();
            weapon.setIsEquipped(true);
        }
    }

//    //equip a weapon given name, Weapon weapon is for storing reference
//    public void equipWeapon(String name, Weapon weapon) {
//        for (int i = 0; i < items.size(); i++) {
//            if (items.get(i).getName().equals(name)) {
//                weapon = (Weapon) (items.get(i));
//                basePower += weapon.getPowerValue();
//                weapon.setIsEquipped(true);
//            }
//        }
//    }
//
//    //equip an armor given name, Armor armor is for storing reference
//    public void equipArmor(String name, Armor armor) {
//        for (int i = 0; i < items.size(); i++) {
//            if (items.get(i).getName().equals(name)) {
//                armor = (Armor) (items.get(i));
//                this.armor += armor.getArmorValue();
//                this.magicResist += armor.getMagicResistValue();
//                armor.setIsEquipped(true);
//            }
//        }
//    }
    //unequip an item
    public void unequipItem(Item item) {
        if (item instanceof Armor) {
            Armor armorItem = (Armor) item;
            this.armor -= armorItem.getArmorValue();
            this.magicResist -= armorItem.getMagicResistValue();
            armorItem.setIsEquipped(false);
            
        } else {
            Weapon weapon = (Weapon) item;
            this.basePower -= weapon.getPowerValue();
            weapon.setIsEquipped(false);
        }
    }

    //purchase item
    public boolean purchaseItem(Item item) {
        if (this.wallet < item.getValue()) {
            return false;
        } else {
            this.wallet -= item.getValue();
            if (item instanceof Armor) {
                return this.items.add(new Armor((Armor) item));
            } else if (item instanceof Weapon) {
                return this.items.add(new Weapon((Weapon) item));
            } else {
                return this.items.add(item);
            }
        }
    }
}
