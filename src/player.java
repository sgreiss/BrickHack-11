package src;
import src.Interactables.Interactable;
import java.util.*;

public class Player {
    private static Item[] inventory;
    private static final HashMap<Interactable, String> ALLHINTS = new HashMap<>(){

    };
    private static boolean[] known_hints;


    public Player() {
        inventory = new Item[6];
        known_hints = new boolean[ALLHINTS.size()];
    }

    public void addHint(Interactable i) {
        for (int j = 0; j < known_hints.length; j++) {
            if (known_hints[j] == false) {
                known_hints[j] = true;
                break;
            }
        }
    }

    public void addItem(Item i) {
        for (int j = 0; j < inventory.length; j++) {
            if (inventory[j] == null) {
                inventory[j] = i;
                break;
            }
        }
    }    
}