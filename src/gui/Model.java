package src.gui;

import java.net.HttpURLConnection;
import java.util.*;

import src.Item;
import src.Item.item_type;
import src.interactables.ComboLock;
import src.interactables.HintHolder;
import src.interactables.HintHolder.h_type;
import src.interactables.Lock;
import src.interactables.Screw;

public class Model {
    //Game states
    private enum game_state {
        START, PLAY, END;
    }

    //Game Messages
    public static final String UNUSABLE = "This item has no use anymore.";
    public static final String UNDISCOVERED = "No use for this yet.";
    public static final String LOCKED = "This item is locked.";
    public static final String UNLOCKFAIL = "Failed to unlock this item.";

    
    
    //5 locks
    private final Lock REDLOCK = new Lock("Red Lock","Red Key");
    private final Lock BLUELOCK = new Lock("Blue Lock","Blue Key");
    private final Lock GREENLOCK = new Lock("Green Lock","Green Key");
    private final Lock PURPLELOCK = new Lock("Purple Lock","Purple Key");
    private final Lock GOLDLOCK = new Lock("Gold Lock","Gold Key");
    private final ComboLock COMBOLOCK = new ComboLock("Combo Lock", 2620);
    //one screw
    private final Screw VENTSCREW = new Screw("Vent Screw");
    //5 keys
    private final Item REDKEY = new Item(item_type.KEY, "Red Key");
    private final Item BLUEKEY = new Item(item_type.KEY, "Blue Key");
    private final Item GREENKEY = new Item(item_type.KEY, "Green Key");
    private final Item PURPLEKEY = new Item(item_type.KEY, "Purple Key");
    private final Item GOLDKEY = new Item(item_type.KEY, "Gold Key");
    private final Item SCREWDRIVER = new Item(item_type.SCREWDRIVER, "Screwdriver");
    private final Item BANANA = new Item(item_type.BANANA, "Banana");

    private final HintHolder VENT = new HintHolder(h_type.LOCK, "Vent", VENTSCREW);
    private final HintHolder DOOR = new HintHolder(h_type.LOCK, "Door", GOLDLOCK);
    private final HintHolder REDBOOK = new HintHolder(h_type.LOCK, "Red Book", REDLOCK);
    private final HintHolder DRESSERCABINET = new HintHolder(h_type.LOCK, "Dresser Cabinet", GREENLOCK);
    private final HintHolder DRESSERDRAWER = new HintHolder(h_type.LOCK, "Dresser Drawer", BLUELOCK);
    private final HintHolder BRIEFCASE = new HintHolder(h_type.LOCK, "Briefcase", PURPLELOCK);
    private final HintHolder SAFE = new HintHolder(h_type.LOCK, "Safe", COMBOLOCK);
    private final HintHolder FLOWERPOT = new HintHolder(h_type.NOLOCK, "Flower Pot", null);
    private final HintHolder BANANABOWL = new HintHolder(h_type.NOLOCK, "Banana Bowl", null);
    private final HintHolder COATRACK = new HintHolder(h_type.NOLOCK, "Coat Rack", null);
    private final HintHolder UMBRELLAHOLDER = new HintHolder(h_type.NOLOCK, "Umbrella Holder", null);
    private final HintHolder BOOKSHELF = new HintHolder(h_type.NOLOCK, "Bookshelf", null);
    private final HintHolder PAINTING = new HintHolder(h_type.NOLOCK, "Painting", null);
    

    //1 door, 1 coatrack, 1 vent, 1 flowerpot, 1 bananabowl, 1 safe, 1 table, 1 umbrella holder, 1 dresser, 1 bookshelf, 1 briefcase, 2 paintings, 1 screwdriver.
    public static final int DIM = -1;
    private String[][] screen;
    private int screenNum;


    //Observers
    private final List<Observer<Model, String>> observers;

    public Model() {
        this.observers = new ArrayList<>();
        init();
    }

    public void init() {
        screen = new String[DIM][DIM];
        UMBRELLAHOLDER.setItem(SCREWDRIVER);
        FLOWERPOT.setItem(REDKEY);
        COATRACK.setItem(BLUEKEY);
        VENT.setItem(GREENKEY);
        //Purple key needs a separate interaction
        SAFE.setItem(GOLDKEY);
        BANANABOWL.setItem(BANANA);
    
        
    }

}
