package src;
import src.interactables.Interactable;
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
        // known_hints.add(ALLHINTS.get(i));
    }
    public String list_inv(){
        StringBuilder str = new StringBuilder("(");
        for (Item i : inventory){
            str.append(i.getName() + ", ");

        }
        str.append(")");
        return str.toString();
    }
}