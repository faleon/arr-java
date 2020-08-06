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
public class Magical extends Attack{
    private final int magicPointCost;
    
    Magical(int baseDamage, String name, int magicCost){
        super(baseDamage,name);
        this.magicPointCost = magicCost;
    }
    
    public int getMagicPointCost(){
        return magicPointCost;
    }
}
