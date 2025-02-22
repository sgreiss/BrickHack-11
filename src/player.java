package src;
import src.interactables.interactable;
import java.util.*;

public class player {
    private static item[] inventory;
    private static final HashMap<interactable, String> ALLHINTS = new HashMap<>(){

    };
    private static boolean[] known_hints;


    public player() {
        inventory = new item[6];
        known_hints = new boolean[ALLHINTS.size()];
    }

    public void addHint(interactable i) {
        for (int j = 0; j < known_hints.length; j++) {
            if (known_hints[j] == false) {
                known_hints[j] = true;
                break;
            }
        }
    }

    public void addItem(item i) {
        for (int j = 0; j < inventory.length; j++) {
            if (inventory[j] == null) {
                inventory[j] = i;
                break;
            }
        }
    }    
}