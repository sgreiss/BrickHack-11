public class player {
    private static ArrayList<item> inventory;
    private static final HashMap<interactable, String> ALLHINTS = new HashMap();
    private static ArrayList<String> knownhints;


    public player(){
        inventory = new ArrayList<>();
        knownhints = new ArrayList<>();
    }

    public void addHint(interactable i)){
        knownhints.add(ALLHINTS.get(i));
        
    }

    
}