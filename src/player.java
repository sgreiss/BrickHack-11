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
        // known_hints.add(ALLHINTS.get(i));
    }
    public String list_inv(){
        StringBuilder str = new StringBuilder("(");
        for (item i : inventory){
            str.append(i.getName() + ", ");

        }
        str.append(")");
        return str.toString();
    }
}