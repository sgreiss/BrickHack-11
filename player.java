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
        // known_hints[]
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