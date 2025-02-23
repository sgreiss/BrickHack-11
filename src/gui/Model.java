package src.gui;
import java.util.*;

import src.interactables.HintCarrier.h_type;
import src.items.*;
import src.Player;
import src.interactables.*;

public class Model {

    private Interactable focused;

    //Game Messages
    public static final String STARTMSG = "READ THE MESSAGE BELOW AND CLICK BUTTON TO START";
    public static final String WELCOME = "Welcome to the Escape Room!\nYou are trapped in a room and must find a way out.\nUse the items in the room to solve the puzzles and escape.\n\nPress ESC in-game to view keybinds.";
    public static final String UNUSABLE = "This item has no use anymore.";
    public static final String UNDISCOVERED = "No use for this yet.";
    public static final String LOCKED = "This item is locked.";
    public static final String UNLOCKFAIL = "Failed to unlock this item.";

    
    //create player
    Player player = new Player();

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
    private final LockKey GOLDKEY = new LockKey("Gold Key"); //FINAL GOAL
    //2 other items
    private final Screwdriver SCREWDRIVER = new Screwdriver("Screwdriver");
    private final Banana BANANA = new Banana();

    //9 HINTS TOTAL: Cabinet, Drawer, Briefcase, Red Book, Blue Book, Screwdriver, Painting, Receipt1, Receipt2
    private final Hint HINTCAB = new Hint("Hint 0", "2 _ _ _");
    private final Hint HINTDRA = new Hint("Hint 1", "_ 6 _ _");
    private final Hint HINTBRI = new Hint("Hint 2", "_ _ _ 0");
    private final Hint HINTRED = new Hint("Hint 3", "_ _ 2 _");
    private final Hint HINTBLU = new Hint("Hint 4", "My head's getting cold...");
    private final Hint HINTSCR = new Hint("Hint 5", "Could this unscrew something?");
    private final Hint HINTPAI = new Hint("Hint 6", "It's really pouring outside...");
    private final Hint HINTRC1 = new Hint("Hint 7", "He has a bowl for just a single banana?");
    private final Hint HINTRC2 = new Hint("Hint 8", "A receipt for only a single flower?");    

    //13 HINTHOLDERS TOTAL
    private final HintCarrier VENT = new HintCarrier(h_type.LOCK, "Vent", VENTSCREW);
    private final HintCarrier REDBOOK = new HintCarrier(h_type.LOCK, "Red Book", REDLOCK);
    private final HintCarrier CABINET = new HintCarrier(h_type.LOCK, "Dresser Cabinet", GREENLOCK);
    private final HintCarrier DRAWER = new HintCarrier(h_type.LOCK, "Dresser Drawer", BLUELOCK);
    private final HintCarrier BRIEFCASE = new HintCarrier(h_type.LOCK, "Briefcase", PURPLELOCK);
    private final HintCarrier SAFE = new HintCarrier(h_type.LOCK, "Safe", COMBOLOCK);
    private final HintCarrier RECEIPT1 = new HintCarrier(h_type.NOLOCK, "Grocery Receipt", null);
    private final HintCarrier RECEIPT2 = new HintCarrier(h_type.NOLOCK, "Florist Receipt", null);
    private final HintCarrier BLUEBOOK = new HintCarrier(h_type.NOLOCK, "Blue Book", null);
    private final HintCarrier FLOWERPOT = new HintCarrier(h_type.NOLOCK, "Flower Pot", null);
    private final HintCarrier BANANABOWL = new HintCarrier(h_type.NOLOCK, "Banana Bowl", null);
    private final HintCarrier COATRACK = new HintCarrier(h_type.NOLOCK, "Coat Rack", null);
    private final HintCarrier UMBRELLAHOLDER = new HintCarrier(h_type.NOLOCK, "Umbrella Holder", null);
    private final HintCarrier PAINTING = new HintCarrier(h_type.NOLOCK, "Painting", null);
    private final HintCarrier FPAINTING = new HintCarrier(h_type.NOLOCK, "Herring Painting", null);

    //2 Tables
    private final Table TABLE = new Table("Table1");
    private final Table TABLE2 = new Table("Table2");

    //Current screen
    private static int currentscreen;


    //Observers
    private final List<Observer<Model, String>> observers;

    public Model() {
        this.observers = new ArrayList<>();
        init();
    }
    public void addObserver(Observer<Model, String> observer) {
        this.observers.add(observer);
    }
    public void ready(){
        notifyObservers(STARTMSG);
    }
    private void notifyObservers(String message) {
        for (Observer<Model, String> observer : observers) {
            observer.update(this, message);
        }
    }

    public void init() {
        currentscreen = 0;
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
        FPAINTING.setHint(new Hint("Fake Hint", "This painting seems completely normal"));
        
        TABLE.placeOnTop(RECEIPT1);
        TABLE.placeOnTop(RECEIPT2);
        TABLE2.placeOnTop(BANANABOWL);
        
        ready();
    }
    public boolean isFinished(){
        return GOLDLOCK.isOpen();
    }

    public void turn(int direction){
        currentscreen+=direction;
        if(currentscreen < 0) currentscreen = 3;
        else if(currentscreen > 3) currentscreen = 0;
        notifyObservers(String.format("Turned to screen %d", currentscreen));
    }
    public void advance(Interactable i){
        focused = i;
        notifyObservers(String.format("Advanced to ", focused.getName()));
    }
    public void retreat(){
        focused = null;
        notifyObservers(String.format("Turned to screen %d", currentscreen));
    }
    public boolean useItem(Interactable i){
        if (player.getEquipped() == null) {
            notifyObservers("No item equipped.");
            return false;
        }
        if (i instanceof Screw){
            return ((Screw)i).unscrew(player.getEquipped());
        }
        else if (i instanceof Lock){
            return ((Lock)i).keyUnlock(player.getEquipped());
        }
        else{
            notifyObservers("This item cannot be used here.");
            return false;
        }

    }

}
