package src;
import src.interactables.Hint;
import src.interactables.Interactable;
import src.items.Item;

import java.util.*;

public class Player {
    private static Item[] inventory;
    private ArrayList<String> notebook;
    private static boolean[] known_hints;


    public Player() {
        inventory = new Item[6];
        notebook = new ArrayList<>();
    }

    public void addItem(Item i) {
        for (int j = 0; j < inventory.length; j++) {
            if (inventory[j] == null) {
                inventory[j] = i;
                break;
            }
        }
    }
    public void writeInNotebook(Hint hint) {
        notebook.add(hint.getContents());
    }   
}
