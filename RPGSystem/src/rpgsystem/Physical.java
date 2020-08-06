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
public class Physical extends Attack {

    private final int criticalStrikeChance;

    public Physical(int baseDamage, String name, int criticalChance) {
        super(baseDamage, name);
        this.criticalStrikeChance = criticalChance;
    }

    @Override
    public int getAttackPower() {
        if (RPGSystem.getRandomNum() <= criticalStrikeChance) {
            ((CombatGUI) RPGSystem.getCombatMenu()).updateWorldTextArea("Critical strike!\n");
            return super.getAttackPower() * 2;
        } else {
            return super.getAttackPower();
        }
    }
}