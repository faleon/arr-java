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
public class Attack implements Serializable {
    private int baseDamage;
    private String name;
    
    public Attack(int baseDamage, String name){
        this.name = name;
        this.baseDamage = baseDamage;
    }
    
    public Attack(){
    }
    
    public String getAttackName(){
        return name;
    }
    
    public int getAttackPower(){
        return baseDamage;
    }
}
