package src.gui;

import java.net.HttpURLConnection;
import java.security.Key;
import java.util.*;

import src.interactables.HintHolder.h_type;
import src.items.*;
import src.interactables.*;

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
    private final LockKey REDKEY = new LockKey("Red Key");
    private final LockKey BLUEKEY = new LockKey("Blue Key");
    private final LockKey GREENKEY = new LockKey("Green Key");
    private final LockKey PURPLEKEY = new LockKey("Purple Key");
    private final LockKey GOLDKEY = new LockKey("Gold Key");
    //2 other items
    private final Screwdriver SCREWDRIVER = new Screwdriver("Screwdriver");
    private final Banana BANANA = new Banana();

    //9 HINTS TOTAL: Cabinet, Drawer, Briefcase, Red Book, Blue Book, Screwdriver, Painting, Receipt1, Receipt2
    private final Hint HINTCAB = new Hint("Hint 1", "2 _ _ _");
    private final Hint HINTDRA = new Hint("Hint 2", "_ 6 _ _");
    private final Hint HINTBRI = new Hint("Hint 3", "_ _ _ 0");
    private final Hint HINTRED = new Hint("Hint 4", "_ _ 2 _");
    private final Hint HINTBLU = new Hint("Hint 5", "My head's getting cold...");
    private final Hint HINTSCR = new Hint("Hint 6", "Could this unscrew something?");
    private final Hint HINTPAI = new Hint("Hint 7", "It's really pouring outside...");
    private final Hint HINTRC1 = new Hint("Hint 8", "He has a bowl for just a single banana?");
    private final Hint HINTRC2 = new Hint("Hint 9", "A receipt for only a single flower?");    

    //13 HINTHOLDERS TOTAL
    private final HintHolder VENT = new HintHolder(h_type.LOCK, "Vent", VENTSCREW);
    private final HintHolder REDBOOK = new HintHolder(h_type.LOCK, "Red Book", REDLOCK);
    private final HintHolder CABINET = new HintHolder(h_type.LOCK, "Dresser Cabinet", GREENLOCK);
    private final HintHolder DRAWER = new HintHolder(h_type.LOCK, "Dresser Drawer", BLUELOCK);
    private final HintHolder BRIEFCASE = new HintHolder(h_type.LOCK, "Briefcase", PURPLELOCK);
    private final HintHolder SAFE = new HintHolder(h_type.LOCK, "Safe", COMBOLOCK);
    private final HintHolder RECEIPT1 = new HintHolder(h_type.NOLOCK, "Grocery Receipt", null);
    private final HintHolder RECEIPT2 = new HintHolder(h_type.NOLOCK, "Florist Receipt", null);
    private final HintHolder BLUEBOOK = new HintHolder(h_type.NOLOCK, "Blue Book", null);
    private final HintHolder FLOWERPOT = new HintHolder(h_type.NOLOCK, "Flower Pot", null);
    private final HintHolder BANANABOWL = new HintHolder(h_type.NOLOCK, "Banana Bowl", null);
    private final HintHolder COATRACK = new HintHolder(h_type.NOLOCK, "Coat Rack", null);
    private final HintHolder UMBRELLAHOLDER = new HintHolder(h_type.NOLOCK, "Umbrella Holder", null);
    private final HintHolder PAINTING = new HintHolder(h_type.NOLOCK, "Painting", null);

    //2 Tables
    private final Table TABLE = new Table("Table1");
    private final Table TABLE2 = new Table("Table2");

    //FINAL GOAL
    private final HintHolder DOOR = new HintHolder(h_type.LOCK, "Door", GOLDLOCK);

    //Screen dimensions
    public static final int DIM = -1;
    private String[][] screen;
    private int screenNum;


    //Observers
    private final List<Observer<Model, String>> observers;

    public Model() {
        this.observers = new ArrayList<>();
        init();
    }
    public void addObserver(Observer<Model, String> observer) {
        this.observers.add(observer);
    }

    public void init() {
        screen = new String[DIM][DIM];
        UMBRELLAHOLDER.setItem(SCREWDRIVER);
        FLOWERPOT.setItem(REDKEY);
        COATRACK.setItem(BLUEKEY);
        VENT.setItem(GREENKEY);
        BANANA.setKey(PURPLEKEY);
        SAFE.setItem(GOLDKEY);
        
        BANANABOWL.setItem(BANANA);
        CABINET.setHint(HINTCAB);
        DRAWER.setHint(HINTDRA);
        BRIEFCASE.setHint(HINTBRI);
        REDBOOK.setHint(HINTRED);
        BLUEBOOK.setHint(HINTBLU);
        PAINTING.setHint(HINTPAI);
        RECEIPT1.setHint(HINTRC1);
        RECEIPT2.setHint(HINTRC2);
        UMBRELLAHOLDER.setHint(HINTSCR);
        
        TABLE.placeOnTop(RECEIPT1);
        TABLE.placeOnTop(RECEIPT2);
        TABLE2.placeOnTop(BANANABOWL);
        
    }

}
