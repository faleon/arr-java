/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgsystem;

import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Faleon
 */
public abstract class RPGSystem {

    private static LinkedList<Actor> monsters = new LinkedList<>();
    private static LinkedList<Attack> monsterAttacks = new LinkedList<>();
    private static LinkedList<JFrame> activeMenus = new LinkedList<>();
    private static ArrayList<String> names = new ArrayList<>();
    private static LinkedList<Item> items = new LinkedList<>();

    private static Character activeCharacter;
    private static Monster activeMonster;
    private static Merchant activeMerchant;

    public static void setActiveCharacter(Character character) {
        activeCharacter = character;
    }

    public static Character getActiveCharacter() {
        return activeCharacter;
    }

    public static Monster getActiveMonster() {
        return activeMonster;
    }

    public static Merchant getActiveMerchant() {
        return activeMerchant;
    }

    public static void determineEncounter() {
        int num = getRandomNum();
        if (num <= 3) {
            spawnMerchant();
            updateWorldLog("Merchant "
                    + activeMerchant.getName()
                    + " has appeared and has some goods for sale."
                    + "\n \"Buy something you fool\" "
                    + activeMerchant.getName()
                    + " mutters.\n");
            ShopGUI shopMenu = new ShopGUI();
            addGUI(shopMenu);
            shopMenu.setLocationRelativeTo(null);
            shopMenu.setVisible(true);
        } else {
            spawnMonster();
            updateWorldLog("A monster blocks your path!\n"
                    + activeMonster.getName()
                    + " challenges you to fight!");
            EncounterGUI encounterMenu = new EncounterGUI();
            encounterMenu.setLocationRelativeTo(null);
            encounterMenu.setVisible(true);
        }
    }

    //generate random number 1 - 10
    public static int getRandomNum() {
        Random randomNum = new Random();
        return randomNum.nextInt(11);
    }

    public static int getRandomNum(int max) {
        Random randomNum = new Random();
        return randomNum.nextInt(max);
    }

    //calculate damage based on actor's stats
    private static int calculateDamage(int attackDmg, int actorPwr,
            int armor, int magicRes) {
        if (((attackDmg + actorPwr) - (armor + magicRes)) >= 0) {
            return ((attackDmg + actorPwr) - (armor + magicRes));
        } else {
            return 0;
        }
    }

    public static boolean tryToRun() {
        return getRandomNum() >= 5;
    }

    public static void updateWorldLog(String message) {
        message += "\n";
        if (getDungeonMenu() != null) {
            DungeonGUI temp = (DungeonGUI) getDungeonMenu();
            temp.updateWorldTextArea(message);
        }
        if (getInventoryMenu() != null) {
            InventoryGUI temp = (InventoryGUI) getInventoryMenu();
            temp.updateWorldTextArea(message);
        }
        if (getShopMenu() != null) {
            ShopGUI temp = (ShopGUI) getShopMenu();
            temp.updateWorldTextArea(message);
        }
        if (getCombatMenu() != null) {
            CombatGUI temp = (CombatGUI) getCombatMenu();
            temp.updateWorldTextArea(message);
        }
    }

    //execute the player's attack
    public static void performAction(Attack attack, Actor target) {
        //determine damage done
        int damage;
        if (target instanceof Monster) {
            if (attack instanceof Magical) {
                damage = calculateDamage(attack.getAttackPower(), activeCharacter.getBasePower(),
                        0, activeMonster.getMagicResist());
                RPGSystem.getActiveCharacter().setMagicPoints(RPGSystem.getActiveCharacter().getMagicPoints() - ((Magical) attack).getMagicPointCost());
            } else {
                damage = calculateDamage(attack.getAttackPower(), activeCharacter.getBasePower(),
                        activeMonster.getArmor(), 0);
            }
            activeMonster.updateStats(damage);
        } else {
            if (attack instanceof Magical) {
                damage = calculateDamage(attack.getAttackPower(), activeMonster.getBasePower(),
                        0, activeCharacter.getMagicResist());
            } else {
                damage = calculateDamage(attack.getAttackPower(), activeMonster.getBasePower(),
                        activeCharacter.getArmor(), 0);
            }
            activeCharacter.updateStats(damage);
        }

    }

    //try to equip/unequip an item
    public static void performAction(Item item, boolean action) {
        //true means to equip
        //false means to unequip
        if (item instanceof Armor || item instanceof Weapon) {
            if (action == true && item.getIsEquipped() == false) {
                activeCharacter.equipItem(item);
            } else if (action == false && item.getIsEquipped() == true) {
                activeCharacter.unequipItem(item);
            } else if (action == true && item.getIsEquipped() == true) {
                updateWorldLog(item.getName() + " is already equipped.");
            } else {
                updateWorldLog("You're not using " + item.getName() + ".");
            }
        }
    }

    //create a merchant with a random name
    //item tiers: 0-6, 7-13, 14-20
    private static void spawnMerchant() {
        activeMerchant = new Merchant(names.get(getRandomNum(names.size())));
        LinkedList<Item> forSale = new LinkedList<>();
        int randomNum = 0;
        if (activeCharacter.getLevel() <= 5) {
            while (forSale.size() < 5) {
                forSale.add(items.get(getRandomNum(7)));
            }
        } else if (activeCharacter.getLevel() <= 10) {
            while (forSale.size() < 5) {
                while (randomNum < 8) {
                    randomNum = getRandomNum(14);
                }
                forSale.add(items.get(randomNum));
                randomNum = 0;
            }
        } else {
            while (forSale.size() < 5) {
                while (randomNum < 14) {
                    randomNum = getRandomNum(21);
                }
                forSale.add(items.get(randomNum));
                randomNum = 0;
            }
        }
        activeMerchant.setItems(forSale);
    }

    //create a monster from the monster list
    //loot tiers: 0-6, 7-13, 14-20
    //monster tiers: 0-4, 5-9, 10-14
    //attack tiers: 0-2, 3-5, 6-8
    private static void spawnMonster() {
        LinkedList<Item> loot = new LinkedList<>();
        int randomNum = 0;
        if (activeCharacter.getLevel() <= 5) {
            while (loot.size() < 5) {
                loot.add(items.get(getRandomNum(7)));
            }
            activeMonster = (Monster) monsters.get(getRandomNum(5));
        } else if (activeCharacter.getLevel() <= 10) {
            while (loot.size() < 5) {
                while (randomNum < 7) {
                    randomNum = getRandomNum(14);
                }
                loot.add(items.get(randomNum));
                randomNum = 0;
            }
            randomNum = 0;
            while (randomNum < 5) {
                randomNum = getRandomNum(10);
            }
            activeMonster = (Monster) monsters.get(randomNum);
        } else {
            while (loot.size() < 5) {
                while (randomNum < 14) {
                    randomNum = getRandomNum(21);
                }
                loot.add(items.get(randomNum));
                randomNum = 0;
            }
            randomNum = 0;
            while (randomNum < 10) {
                randomNum = getRandomNum(15);
            }
            activeMonster = (Monster) monsters.get(randomNum);
        }
        activeMonster.setItems(loot);

        randomNum = 0;
        Attack[] attacks = new Attack[activeMonster.getAttacksLimit()];
        if (activeCharacter.getLevel() <= 5) {
            for (int i = 0; i < attacks.length; i++) {
                attacks[i] = monsterAttacks.get(getRandomNum(3));
            }
        } else if (activeCharacter.getLevel() <= 10) {
            for (int i = 0; i < attacks.length; i++) {
                while (randomNum < 3) {
                    randomNum = getRandomNum(6);
                }
                attacks[i] = monsterAttacks.get(randomNum);
                randomNum = 0;
            }
        } else {
            for (int i = 0; i < attacks.length; i++) {
                while (randomNum < 6) {
                    randomNum = getRandomNum(9);
                }
                attacks[i] = monsterAttacks.get(randomNum);
                randomNum = 0;
            }
        }
        activeMonster.setAttacks(attacks);
    }

    //save character
    public static void saveCharacter() {
        try (FileOutputStream fos = new FileOutputStream("saves/"
                + activeCharacter.getName() + ".sav");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(activeCharacter);
        } catch (Exception ex) {

        }
    }

    //load items: potions.txt, armor.txt, weapons.txt
    private static void loadItems() {
        File potionsFile = new File("potions.txt");
        File weaponsFile = new File("weapons.txt");
        File armorFile = new File("armor.txt");

        try (Scanner potionsInput = new Scanner(potionsFile);
                Scanner weaponsInput = new Scanner(weaponsFile);
                Scanner armorInput = new Scanner(armorFile);) {

            int potionCount = 0;
            int potionMax = 2;
            int armorCount = 0;
            int armorMax = 3;
            int weaponCount = 0;
            int weaponMax = 2;
            int tierCount = 3;

            //load by tier
            for (int i = 0; i < tierCount; i++) {
                //potions
                while (potionsInput.hasNext() && potionCount < potionMax) {
                    String[] line = potionsInput.nextLine().split(",");
                    items.add(new Potion(Integer.parseInt(line[0]),
                            line[1],
                            line[2],
                            Integer.parseInt(line[3]),
                            Integer.parseInt(line[4])));
                    potionCount++;
                }
                potionMax += 2;

                //weapons
                while (weaponsInput.hasNext() && weaponCount < weaponMax) {
                    String[] line = weaponsInput.nextLine().split(",");
                    items.add(new Weapon(Integer.parseInt(line[0]),
                            line[1],
                            Integer.parseInt(line[2]),
                            Integer.parseInt(line[3])));
                    weaponCount++;
                }
                weaponMax += 2;

                //armor
                while (armorInput.hasNext() && armorCount < armorMax) {
                    String[] line = armorInput.nextLine().split(",");
                    items.add(new Armor(Integer.parseInt(line[0]),
                            line[1],
                            Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]),
                            line[4],
                            Integer.parseInt(line[5])));
                    armorCount++;
                }
                armorMax += 3;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    //load monster attacks
    private static void loadMonsterAttacks() {
        File file = new File("monsterAttacks.txt");
        String[] line;
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                line = input.nextLine().split(",");
                monsterAttacks.add(new Attack(Integer.parseInt(line[0]),
                        line[1]));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    //load monsters
    private static void loadMonsters() {
        File file = new File("monsters.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String[] line = input.nextLine().split(",");
                monsters.add(new Monster(Integer.parseInt(line[0]),
                        Integer.parseInt(line[1]),
                        Integer.parseInt(line[2]),
                        Integer.parseInt(line[3]),
                        line[4],
                        Integer.parseInt(line[5]),
                        Integer.parseInt(line[6]),
                        Integer.parseInt(line[7])));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    //load names
    private static void loadNames() {
        File file = new File("names.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                names.add(input.nextLine());
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //FILE CHECK
        //check for save directory
        if (!new File("saves").exists()) {
            new File("saves").mkdir();
        }

        //check for professionAttacks directory
        if (!new File("professionAttacks").exists()) {
            new File("professionAttacks").mkdir();
        }

        //check for armor file
        if (!new File("armor.txt").exists()) {
            JOptionPane.showMessageDialog(null,
                    "Missing \"/armor.txt\" in local folder.\n"
                    + "Contact game authors to fix.", "MISSING FILE",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        //check for weapons file
        if (!new File("weapons.txt").exists()) {
            JOptionPane.showMessageDialog(null,
                    "Missing \"/weapons.txt\" in local folder.\n"
                    + "Contact game authors to fix.", "MISSING FILE",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        //check for monsters file
        if (!new File("monsters.txt").exists()) {
            JOptionPane.showMessageDialog(null,
                    "Missing \"/monsters.txt\" in local folder.\n"
                    + "Contact game authors to fix.", "MISSING FILE",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        //check for name file
        if (!new File("names.txt").exists()) {
            JOptionPane.showMessageDialog(null,
                    "Missing \"/names.txt\" in local folder.\n"
                    + "Contact game authors to fix.", "MISSING FILE",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        //check for professions file
        if (!new File("professions.txt").exists()) {
            JOptionPane.showMessageDialog(null,
                    "Missing \"/professions.txt\" in local folder.\n"
                    + "Contact game authors to fix.", "MISSING FILE",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        //check for monster attacks file
        if (!new File("monsterAttacks.txt").exists()) {
            JOptionPane.showMessageDialog(null,
                    "Missing \"/monsterAttacks.txt\" in local folder.\n"
                    + "Contact game authors to fix.", "MISSING FILE",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        //check for profession attacks files
        //warrior
        if (!new File("professionAttacks/warrior.txt").exists()) {
            JOptionPane.showMessageDialog(null,
                    "Missing \"/professionAttacks/warrior.txt\" in local folder."
                    + "\nContact game authors to fix.", "MISSING FILE",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        //barbarian
        if (!new File("professionAttacks/barbarian.txt").exists()) {
            JOptionPane.showMessageDialog(null,
                    "Missing \"/professionAttacks/barbarian.txt\" in local folder."
                    + "\nContact game authors to fix.", "MISSING FILE",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        //archer
        if (!new File("professionAttacks/archer.txt").exists()) {
            JOptionPane.showMessageDialog(null,
                    "Missing \"/professionAttacks/archer.txt\" in local folder."
                    + "\nContact game authors to fix.", "MISSING FILE",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        //wizard
        if (!new File("professionAttacks/wizard.txt").exists()) {
            JOptionPane.showMessageDialog(null,
                    "Missing \"/professionAttacks/wizard.txt\" in local folder."
                    + "\nContact game authors to fix.", "MISSING FILE",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        //END FILE CHECK

        //LOAD RESOURCES
        loadItems();
        loadMonsters();
        loadMonsterAttacks();
        loadNames();
        //END LOAD RESOURCES

        //create main menu GUI
        MainMenuGUI mainMenu = new MainMenuGUI();
        mainMenu.setLocationRelativeTo(null);
        addGUI(mainMenu);
        mainMenu.setVisible(true);
    }

    //GUI RELATED METHODS
    //add GUI to GUI list
    public static void addGUI(JFrame window) {
        activeMenus.add(window);
    }

    //remove the GUI from GUI list
    public static void removeGUI(JFrame window) {
        for (int i = 0; i < activeMenus.size(); i++) {
            if (window.getName().equals(activeMenus.get(i).getName())) {
                activeMenus.remove(i);
                return;
            }
        }
    }

    //return main menu
    public static JFrame getMainMenu() {
        for (int i = 0; i < activeMenus.size(); i++) {
            if (activeMenus.get(i).getName().equals("MainMenu")) {
                return activeMenus.get(i);
            }
        }
        return null;
    }

    //return dungeon menu
    public static JFrame getDungeonMenu() {
        for (int i = 0; i < activeMenus.size(); i++) {
            if (activeMenus.get(i).getName().equals("DungeonMenu")) {
                return activeMenus.get(i);
            }
        }
        return null;
    }

    //return inventory menu
    public static JFrame getInventoryMenu() {
        for (int i = 0; i < activeMenus.size(); i++) {
            if (activeMenus.get(i).getName().equals("InventoryMenu")) {
                return activeMenus.get(i);
            }
        }
        return null;
    }

    //return combat menu
    public static JFrame getCombatMenu() {
        for (int i = 0; i < activeMenus.size(); i++) {
            if (activeMenus.get(i).getName().equals("CombatMenu")) {
                return activeMenus.get(i);
            }
        }
        return null;
    }

    public static JFrame getShopMenu() {
        for (int i = 0; i < activeMenus.size(); i++) {
            if (activeMenus.get(i).getName().equals("ShopMenu")) {
                return activeMenus.get(i);
            }
        }
        return null;
    }
}
