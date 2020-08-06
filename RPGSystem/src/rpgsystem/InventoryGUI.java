/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgsystem;

import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author huazhong
 */
public class InventoryGUI extends javax.swing.JFrame {

//    private Weapon weaponEquipped = null;
//    private Armor chestEquipped = null;
//    private Armor helmetEquipped = null;
//    private Armor legsEquipped = null;
    private LinkedList<Item> inventory;
    private LinkedList<Armor> armor;
    private LinkedList<Weapon> weapons;
//    private Weapon weaponToEquip = null;
//    private Armor armorToEquip = null;
//    private Potion potion = null;

    /**
     * Creates new form InventoryGUI
     */
    public InventoryGUI() {
        initComponents();

        inventory = RPGSystem.getActiveCharacter().getItems();
        armor = RPGSystem.getActiveCharacter().getArmors();
        weapons = RPGSystem.getActiveCharacter().getWeapons();
        Character character = RPGSystem.getActiveCharacter();
        characterName.setText(character.getName());

        hpValue.setText(character.getHealthPoints() + "/" + character.getMaxHp());
        //set hp progress bar value
        updateHpProgress();

        mpValue.setText(character.getMagicPoints() + "/" + character.getMaxMp());
        //set mp progress bar value
        updateMpProgress();

        //add potions to potion list
        updatePotionList();

        //add armors
        updateArmorList();

        //add weapons
        updateWeaponList();

        //set equipped armor text
        for (int i = 0; i < character.getArmors().size(); i++) {
            if (this.armor.get(i).getIsEquipped()) {
                Armor equppedArmor = (Armor) (character.getArmors().get(i));
                if (equppedArmor.getType().equals("Helmet")) {
                    helmetTextField.setText(equppedArmor.getName());
//                    //store equipped helmet reference
//                    helmetEquipped = a;
                } else if (equppedArmor.getType().equals("Chest")) {
                    chestTextField.setText(equppedArmor.getName());
//                    //store equipped chest reference
//                    chestEquipped = a;
                } else {
                    legsTextField.setText(equppedArmor.getName());
//                    //store equipped legs reference
//                    legsEquipped = a;
                }
            }
//            } else {
//                //set text field blank
//                helmetTextField.setText("");
//                chestTextField.setText("");
//                legsTextField.setText("");
//            }
        }

        //set equipped weapon text
        for (int i = 0; i < weapons.size(); i++) {
            if (weapons.get(i).getIsEquipped()) {
                weaponTextField.setText(weapons.get(i).getName());
//                //store equipped weapon reference
//                weaponEquipped = w;
            }
        }

        //set wallet text
        walletLabel.setText(Integer.toString(
                RPGSystem.getActiveCharacter().getWallet()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        characterName = new javax.swing.JLabel();
        hp = new javax.swing.JLabel();
        hpValue = new javax.swing.JLabel();
        hpProgressBar = new javax.swing.JProgressBar();
        mp = new javax.swing.JLabel();
        mpValue = new javax.swing.JLabel();
        mpProgressBar = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        walletLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        helmetTextField = new javax.swing.JTextField();
        weaponTextField = new javax.swing.JTextField();
        chestTextField = new javax.swing.JTextField();
        legsTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        worldTextArea = new javax.swing.JTextArea();
        okButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        equipWeaponButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        useItemButton = new javax.swing.JButton();
        equipArmorButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        weaponList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        armorList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        potionList = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Inventory Menu");
        setName("InventoryMenu"); // NOI18N
        setResizable(false);

        characterName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        characterName.setText("Character Name");

        hp.setText("HP");

        hpValue.setText("100/100");

        hpProgressBar.setForeground(new java.awt.Color(0, 255, 0));

        mp.setText("MP");

        mpValue.setText("100/100");

        mpProgressBar.setForeground(new java.awt.Color(0, 255, 255));

        jLabel10.setText("Wallet");

        jLabel11.setText("$");

        walletLabel.setText("000000000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(characterName)
                    .addComponent(hpProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mpProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(hp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hpValue))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mpValue))
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(walletLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(characterName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hp)
                    .addComponent(hpValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hpProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mp)
                    .addComponent(mpValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mpProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(walletLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Equipped Helmet");

        jLabel2.setText("Equipped Weapon");

        jLabel3.setText("Equipped Chest Armor");

        jLabel4.setText("Equipped Leg Armor");

        helmetTextField.setEditable(false);

        weaponTextField.setEditable(false);
        weaponTextField.setToolTipText("");
        weaponTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        chestTextField.setEditable(false);

        legsTextField.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(legsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(chestTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(helmetTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weaponTextField, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weaponTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(helmetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(chestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(legsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        worldTextArea.setEditable(false);
        worldTextArea.setColumns(20);
        worldTextArea.setLineWrap(true);
        worldTextArea.setRows(5);
        worldTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(worldTextArea);

        okButton.setText("Exit Inventory Menu");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("World Log");

        equipWeaponButton.setText("Equip Selected Weapon");
        equipWeaponButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipWeaponButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Weapon");

        useItemButton.setText("Use Selected Item");
        useItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useItemButtonActionPerformed(evt);
            }
        });

        equipArmorButton.setText("Equip Selected Armor");
        equipArmorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipArmorButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Potions");

        weaponList.setModel(new DefaultListModel());
        weaponList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        weaponList.setMinimumSize(new java.awt.Dimension(175, 125));
        weaponList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                weaponListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(weaponList);

        armorList.setModel(new DefaultListModel());
        armorList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        armorList.setMinimumSize(new java.awt.Dimension(175, 125));
        armorList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                armorListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(armorList);

        potionList.setModel(new DefaultListModel());
        potionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        potionList.setMinimumSize(new java.awt.Dimension(175, 125));
        potionList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                potionListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(potionList);

        jLabel9.setText("Armor");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(useItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(equipWeaponButton, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(equipArmorButton, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(useItemButton)
                    .addComponent(equipWeaponButton)
                    .addComponent(equipArmorButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(okButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updatePotionList() {
        LinkedList<Item> potions = RPGSystem.getActiveCharacter().getUsableItems();
        DefaultListModel model = new DefaultListModel();
        if (potions != null) {
            for (Item r : potions) {
                model.addElement(r.getName());
            }
        }
        potionList.setModel(model);
    }

    private void updateWeaponList() {
        DefaultListModel model = new DefaultListModel();
        if (weapons != null) {
            for (int i = 0; i < weapons.size(); i++) {
                //if (!weapons.get(i).getIsEquipped()) {
                model.addElement(weapons.get(i).getName());
                //}
            }
        }
        weaponList.setModel(model);
    }

    private void updateArmorList() {
        DefaultListModel model = new DefaultListModel();
        if (armor != null) {
            for (int i = 0; i < armor.size(); i++) {
                //if (!armor.get(i).getIsEquipped()) {
                model.addElement(armor.get(i).getName());
                //}
            }
        }
        armorList.setModel(model);
    }

    private void updateHpProgress() {
        int hpPercentage = ((RPGSystem.getActiveCharacter().getHealthPoints() * 100))
                / (RPGSystem.getActiveCharacter().getMaxHp());
        hpProgressBar.setValue(hpPercentage);
    }

    private void updateMpProgress() {
        int mpPercentage = ((RPGSystem.getActiveCharacter().getMagicPoints() * 100))
                / (RPGSystem.getActiveCharacter().getMaxMp());
        mpProgressBar.setValue(mpPercentage);
    }

    public void updateWorldTextArea(String message) {
        worldTextArea.append(message);
    }

    private void useItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useItemButtonActionPerformed
        //use selected potion
        String name = potionList.getSelectedValue();
        Potion selectedPotion = null;
        for (Item item : inventory) {
            if (item instanceof Potion && item.getName().equals(name)) {
                selectedPotion = (Potion) item;
            }
        }

        if (name == null || selectedPotion == null) {
            JOptionPane.showMessageDialog(null, "You must select a potion.");
            return;
        } else {
            RPGSystem.getActiveCharacter().drinkPotion(selectedPotion);
        }

        //update list
        potionList.removeAll();
        updatePotionList();

        //update displayed stats
        hpValue.setText(RPGSystem.getActiveCharacter().getHealthPoints() + "/"
                + RPGSystem.getActiveCharacter().getMaxHp());
        updateHpProgress();

        mpValue.setText(RPGSystem.getActiveCharacter().getMagicPoints() + "/"
                + RPGSystem.getActiveCharacter().getMaxMp());
        updateMpProgress();

        //update world log
        if (selectedPotion.getType().equals("hp")) {
            RPGSystem.updateWorldLog(
                    RPGSystem.getActiveCharacter().getName()
                    + " has recovered "
                    + (RPGSystem.getActiveCharacter().getMaxHp() / selectedPotion.getRecoverAmount())
                    + " health points by drinking "
                    + selectedPotion.getName() + ".\n");
        } else {
            RPGSystem.updateWorldLog(
                    RPGSystem.getActiveCharacter().getName()
                    + " has recovered "
                    + (RPGSystem.getActiveCharacter().getMaxHp() / selectedPotion.getRecoverAmount())
                    + " magic points by drinking "
                    + selectedPotion.getName() + ".\n");
        }
    }//GEN-LAST:event_useItemButtonActionPerformed

    private void equipWeaponButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipWeaponButtonActionPerformed
        String selectedWeapon = weaponList.getSelectedValue();
        if (selectedWeapon == null) {
            JOptionPane.showMessageDialog(null, "You must select a weapon.");
            return;
        } else {
            //unequip weapons
            for (Weapon weapon : weapons) {
                if (weapon.getIsEquipped()) {
                    //unequip item
                    RPGSystem.getActiveCharacter().unequipItem(weapon);

                    //update text
                    updateWorldTextArea("You have unequipped "
                            + weaponTextField.getText() + ".\n");
                    weaponTextField.setText(null);

                    //stop method if unequipped item is the same as the selected item
                    if (weapon.getName().equals(selectedWeapon)) {
                        return;
                    }
                }
            }

            //equip selected weapon
            for (Weapon weapon : weapons) {
                if (!weapon.getIsEquipped()
                        && weapon.getName().equals(selectedWeapon)) {
                    RPGSystem.getActiveCharacter().equipItem(weapon);

                    updateWorldTextArea("You have equipped "
                            + weapon.getName() + ".\n"
                            + weapon.toString() + "\n");

                    weaponTextField.setText(selectedWeapon);
                    if (weapon.getName().equals(selectedWeapon)) {
                        return;
                    }
                }
            }
////            //unequip equipped weapon
////            if (weaponEquipped != null) {
////                RPGSystem.getActiveCharacter().unequipItem(weaponEquipped);
////
////                //update world log
////                updateWorldTextArea("You have unequipped "
////                        + weaponTextField.getText() + ".\n");
////            }
//
//            //equip selected weapon
//            RPGSystem.getActiveCharacter().equipItem(weaponToEquip);
//            weaponTextField.setText(selectedWeapon);
//
//            //update world log
//            updateWorldTextArea("You have equipped " + selectedWeapon + "."
//                    + weaponToEquip.toString() + "\n");
//
//            //set weaponEquipped to current equipped weapon
//            weaponEquipped = weaponToEquip;
        }
    }//GEN-LAST:event_equipWeaponButtonActionPerformed

    private void equipArmorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipArmorButtonActionPerformed
        String selectedArmorName = armorList.getSelectedValue();
        Armor selectedArmor = null;
        for (Armor armorPiece : armor) {
            if (armorPiece.getName().equals(selectedArmorName)) {
                selectedArmor = armorPiece;
            }
        }
        if (selectedArmorName == null) {
            JOptionPane.showMessageDialog(null, "You must select an armor.");
            return;
        } else {
            //unequip selected armor
            for (Armor armorPiece : armor) {
                if (selectedArmor.getType().equals(armorPiece.getType())
                        && armorPiece.getIsEquipped()) {
                    //unequip item
                    RPGSystem.getActiveCharacter().unequipItem(armorPiece);

                    //update text
                    if (armorPiece.getType().equals("Helmet")) {
                        updateWorldTextArea("You have unequipped "
                                + helmetTextField.getText() + ".\n");
                        helmetTextField.setText(null);
                    } else if (armorPiece.getType().equals("Chest")) {
                        updateWorldTextArea("You have unequipped "
                                + chestTextField.getText() + ".\n");
                        chestTextField.setText(null);
                    } else {
                        updateWorldTextArea("You have unequipped "
                                + legsTextField.getText() + ".\n");
                        legsTextField.setText(null);
                    }
                    //stop method if unequipped item is the same as the selected item
                    if (armorPiece.getName().equals(selectedArmorName)) {
                        return;
                    }
                }
            }

            //equip selected armor
            RPGSystem.getActiveCharacter().equipItem(selectedArmor);

            //update text
            if (selectedArmor.getType().equals("Helmet")) {
                helmetTextField.setText(selectedArmorName);
                updateWorldTextArea("You have equipped "
                        + helmetTextField.getText() + ".\n"
                        + selectedArmor.toString() + "\n");
            } else if (selectedArmor.getType().equals("Chest")) {
                chestTextField.setText(selectedArmorName);
                updateWorldTextArea("You have equipped "
                        + chestTextField.getText() + ".\n"
                        + selectedArmor.toString() + "\n");
            } else {
                legsTextField.setText(selectedArmorName);
                updateWorldTextArea("You have equipped "
                        + legsTextField.getText() + ".\n"
                        + selectedArmor.toString() + "\n");
            }

//            if (armorToEquip.getName().equals("Helmet")) {
//                if (helmetEquipped != null) {
//                    //unequipped current helmet equipped
//                    RPGSystem.getActiveCharacter().unequipItem(helmetEquipped);
//
//                    //update world log
//                    updateWorldTextArea("You have unequipped "
//                            + helmetTextField.getText() + ".\n");
//                }
//                //set helmet textfield
//                helmetTextField.setText(toEquip);
//
//                //set helmetEquipped to current helmet equipped
//                helmetEquipped = armorToEquip;
//
//            } else if (armorToEquip.getName().equals("Chest")) {
//                if (chestEquipped != null) {
//                    //unequipped current chest equipped
//                    RPGSystem.getActiveCharacter().unequipItem(chestEquipped);
//
//                    //update world log
//                    updateWorldTextArea("You have unequipped "
//                            + chestTextField.getText() + ".\n");
//                }
//                //set chest textfield
//                chestTextField.setText(toEquip);
//
//                //set chestEquipped to current chest equipped
//                chestEquipped = armorToEquip;
//            } else {
//                if (chestEquipped != null) {
//                    //unequipped current legs equipped
//                    RPGSystem.getActiveCharacter().unequipItem(legsEquipped);
//
//                    //update world log
//                    updateWorldTextArea("You have unequipped "
//                            + legsTextField.getText() + ".\n");
//                }
//                //set legs textfield
//                legsTextField.setText(toEquip);
//
//                //set legsEquipped to current legs equipped
//                legsEquipped = armorToEquip;
//            }
//            //update world log
//            updateWorldTextArea("You have equipped " + toEquip + "."
//                    + armorToEquip.toString() + "\n");
        }
    }//GEN-LAST:event_equipArmorButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        RPGSystem.removeGUI(this);
        ((DungeonGUI) RPGSystem.getDungeonMenu()).refreshInformation();
        RPGSystem.getDungeonMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void potionListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_potionListValueChanged
        if (!evt.getValueIsAdjusting()) {
            String selectedPotionName = potionList.getSelectedValue();
            for (Item item : inventory) {
                if (item.getName().equals(selectedPotionName)) {
                    updateWorldTextArea(item.toString() + "\n");
                    return;
                }
            }
        }
    }//GEN-LAST:event_potionListValueChanged

    private void weaponListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_weaponListValueChanged
        if (!evt.getValueIsAdjusting()) {
            String selectedWeaponName = weaponList.getSelectedValue();
            for (Item item : inventory) {
                if (item.getName().equals(selectedWeaponName)) {
                    updateWorldTextArea(item.toString() + "\n");
                    return;
                }
            }
        }
    }//GEN-LAST:event_weaponListValueChanged

    private void armorListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_armorListValueChanged
        if (!evt.getValueIsAdjusting()) {
            String selectedArmorName = armorList.getSelectedValue();
            for (Item item : inventory) {
                if (item.getName().equals(selectedArmorName)) {
                    updateWorldTextArea(item.toString() + "\n");
                    return;
                }
            }
        }
    }//GEN-LAST:event_armorListValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> armorList;
    private javax.swing.JLabel characterName;
    private javax.swing.JTextField chestTextField;
    private javax.swing.JButton equipArmorButton;
    private javax.swing.JButton equipWeaponButton;
    private javax.swing.JTextField helmetTextField;
    private javax.swing.JLabel hp;
    private javax.swing.JProgressBar hpProgressBar;
    private javax.swing.JLabel hpValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField legsTextField;
    private javax.swing.JLabel mp;
    private javax.swing.JProgressBar mpProgressBar;
    private javax.swing.JLabel mpValue;
    private javax.swing.JButton okButton;
    private javax.swing.JList<String> potionList;
    private javax.swing.JButton useItemButton;
    private javax.swing.JLabel walletLabel;
    private javax.swing.JList<String> weaponList;
    private javax.swing.JTextField weaponTextField;
    private javax.swing.JTextArea worldTextArea;
    // End of variables declaration//GEN-END:variables
}
