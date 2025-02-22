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

    public void addHint(interactable i)){
        knownhints.add(ALLHINTS.get(i));
        
    }

    
}