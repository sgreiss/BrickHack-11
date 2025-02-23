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

    public void addItem(Item i) {
        for (int j = 0; j < inventory.length; j++) {
            if (inventory[j] == null) {
                inventory[j] = i;
                break;
            }
        }
    }
    public void equipItem(int index) {
        equipped = inventory[index];
    }
    public void writeInNotebook(Hint hint) {
        String str = hint.getContents();
        notebook.add(str);
        known_hints[Integer.parseInt(str.substring(str.length() - 1))] = true;
    }   
}
