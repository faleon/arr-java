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
public class Potion extends Item {

    private String type;
    private int recoverAmount;

    public Potion(int value, String name, String type, int recoverAmount, int tier) {
        super(value, name, tier);
        this.type = type;
        this.recoverAmount = recoverAmount;
    }

    public Potion() {
        super(-1, "Error", -1);
        type = "Error";
        recoverAmount = 0;
    }

    public String getType() {
        return type;
    }

    public int getRecoverAmount() {
        return recoverAmount;
    }

    @Override
    public String toString() {
        if (this.type.equals("hp")) {
            return "Drinking "
                    + getName()
                    + " will recover your hp by 1/"
                    + getRecoverAmount()
                    + " of your max health.";
        } else {
            return "Drinking "
                    + getName()
                    + " will recover your mp by 1/"
                    + getRecoverAmount()
                    + " of your max magic points.";
        }
    }
}
