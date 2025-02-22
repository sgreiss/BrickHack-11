import java.util.*;

public class player {
    private static ArrayList<item> inventory;
    private static final HashMap<interactable, String> ALLHINTS = new HashMap<>();
    private static ArrayList<String> knownhints;
    private item equipped;


    public player(){
        inventory = new ArrayList<>();
        knownhints = new ArrayList<>();
    }

    public void addHint(interactable i){
        knownhints.add(ALLHINTS.get(i));
        
    }
    public void equip(int i){
        if (inventory.get(i) != null){
            equipped = inventory.get(i);
        }
    }



    
}