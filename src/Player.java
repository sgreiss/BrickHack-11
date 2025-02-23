package src;
import src.interactables.*;
import src.items.Item;

import java.util.*;

public class Player {
    private static Item[] inventory;
    private Item equipped;
    private ArrayList<String> notebook; //access discovered hints
    private static boolean[] known_hints; //keeps track of discovered hints


    public Player() {
        inventory = new Item[6];
        notebook = new ArrayList<>();
        known_hints = new boolean[]{false, false, false, false, false, false, false, false, false};
    }

    /*
     * adds an item to the player's inventory
     * @param i the item to be added to the inventory
     */
    public void addItem(Item i) {
        for (int j = 0; j < inventory.length; j++) {
            if (inventory[j] == null) {
                inventory[j] = i;
                break;
            }
        }
    }
    /*
     * equips an item from the player's inventory
     * @param index the index of the item to be equipped
     */
    public void equipItem(int index) {
        equipped = inventory[index];
    }
    /*
     * Adds a hint to the player's notebook and updates the known_hints array
     * @param hint the hint to be added to the notebook
     */
    public void writeInNotebook(Hint hint) {
        String str = hint.getContents();
        notebook.add(str);
        known_hints[Integer.parseInt(str.substring(str.length() - 1))] = true;
    }   
    public Item getEquipped() {
        return equipped;
    }
}
