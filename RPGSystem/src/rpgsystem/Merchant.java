/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgsystem;

import java.util.LinkedList;

/**
 *
 * @author huazhong
 */
public class Merchant {

    private String name;
    private LinkedList<Item> items;

    public Merchant() {
    }

    public Merchant(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
    public LinkedList<Item> getItems() {
        return items;
    }

    public void setItems(LinkedList<Item> items) {
        this.items = items;
    }
}
