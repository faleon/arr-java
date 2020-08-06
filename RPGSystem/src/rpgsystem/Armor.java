/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgsystem;

/**
 *
 * @author Faleon
 */
public class Armor extends Item {

    private int armorValue;
    private int magicResistValue;
    private String type;

    //CONSTRUCTORS
//    public Armor(int value, String name, int armorValue, int magicResistValue, 
//            boolean isEquipped) {
//        super(value, name, isEquipped);
//        this.armorValue = armorValue;
//        this.magicResistValue = magicResistValue;
//    }
    public Armor(int value, String name, int armorValue, int magicResistValue,
            String type, int tier) {
        super(value, name, tier);
        this.armorValue = armorValue;
        this.magicResistValue = magicResistValue;
        this.type = type;
    }
    
    public Armor(Armor armor) {
        super(armor.getValue(),armor.getName(),armor.getTier());
        this.armorValue = armor.getArmorValue();
        this.magicResistValue = armor.getMagicResistValue();
        this.type = armor.getType();
    }

    public Armor() {
        armorValue = 0;
        magicResistValue = 0;
    }
    //END CONSTRUCTORS

    /**
     * @return the armorValue
     */
    public int getArmorValue() {
        return armorValue;
    }

    /**
     * @return the magicResistValue
     */
    public int getMagicResistValue() {
        return magicResistValue;
    }
    
    /**
     * @return the armor type
     */
    public String getType() {
        return type;
    }

    //description of the item
    @Override
    public String toString() {
        return "Wearing " + getName() + " will increase your Armor by " + getArmorValue()
                + " and Magic Resist by " + getMagicResistValue() + ".";
    }

}
