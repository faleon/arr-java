/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgsystem;

import java.io.Serializable;

/**
 *
 * @author Faleon
 */
public abstract class Item implements Serializable {

    private int value;
    private String name;
    private boolean isEquipped;
    private int tier;

    //CONSTRUCTORS
//    public Item(int value, String name, boolean isEquipped) {
//        this(value, name);
//        this.isEquipped = isEquipped;
//    }
    public Item(int value, String name, int tier) {
        this.value = value;
        this.name = name;
        this.tier = tier;
    }

    public Item() {
    }
    //END CONSTRUCTORS

    //return the item's name 
    public String getName() {
        return name;
    }

    //return the item's worth 
    public int getValue() {
        return value;
    }
    
    //return tier
    public int getTier() {
        return tier;
    }

    //return the isEquipped state
    public boolean getIsEquipped() {
        return isEquipped;
    }

    //set the isEquipped boolean
    public void setIsEquipped(boolean bool) {
        isEquipped = bool;
    }
}
