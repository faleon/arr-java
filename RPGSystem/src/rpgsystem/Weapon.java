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
public class Weapon extends Item {

    private int powerValue;

//    public Weapon(int value, String name, int powerValue, boolean isEquipped) {
//        super(value, name, isEquipped, tier);
//        this.powerValue = powerValue;
//    }
    public Weapon(int value, String name, int powerValue, int tier) {
        super(value, name, tier);
        this.powerValue = powerValue;
    }

    public Weapon(Weapon weapon) {
        super(weapon.getValue(), weapon.getName(), weapon.getTier());
        this.powerValue = weapon.getPowerValue();
    }

    public Weapon() {
        powerValue = 0;
    }

    /**
     * @return the powerValue
     */
    public int getPowerValue() {
        return powerValue;
    }

    @Override
    public String toString() {
        return "Using " + getName() + " will increase your base power by " + getPowerValue() + ".";
    }
}
