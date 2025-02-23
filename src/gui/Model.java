package src.gui;
import java.util.*;

import javafx.scene.image.Image;
import src.interactables.HintCarrier.h_type;
import src.items.*;
import src.Player;
import src.interactables.*;


public class Model {

    private Interactable focused;

    //Game Messages
    public static final String STARTMSG = "READ THE MESSAGE BELOW AND CLICK BUTTON TO START";
    public static final String WELCOME = "Welcome to the Escape Room!\nYou are trapped in a room and must find a way out.\nUse the items in the room to solve the puzzles and escape.\n\nPress ESC in-game to view keybinds.";
    public static final String CONTROLSMSG = "Game keybinds";
    public static final String CONTROLS = "Escape: Open/close this screen\nE: Open/close your inventory\nQ: Quit game";
    public static final String UNUSABLE = "This item has no use anymore.";
    public static final String UNDISCOVERED = "No use for this yet.";
    public static final String LOCKED = "This item is locked.";
    public static final String UNLOCKFAIL = "Failed to unlock this item.";

    
    //create player
    Player player = new Player();

    //5 locks
    public static final Lock REDLOCK = new Lock("Red Lock","Red Key");
    public static final Lock BLUELOCK = new Lock("Blue Lock","Blue Key");
    public static final Lock GREENLOCK = new Lock("Green Lock","Green Key");
    public static final Lock PURPLELOCK = new Lock("Purple Lock","Purple Key");
    public static final Lock GOLDLOCK = new Lock("Gold Lock","Gold Key");
    public static final ComboLock COMBOLOCK = new ComboLock("Combo Lock", 2620);
    //one screw
    private static final Screw VENTSCREW = new Screw("Vent Screw");
    //5 keys
    public static final LockKey REDKEY = new LockKey("Red Key");
    public static final LockKey BLUEKEY = new LockKey("Blue Key");
    public static final LockKey GREENKEY = new LockKey("Green Key");
    public static final LockKey PURPLEKEY = new LockKey("Purple Key");
    public static final LockKey GOLDKEY = new LockKey("Gold Key"); //FINAL GOAL
    //2 other items
    public static final Screwdriver SCREWDRIVER = new Screwdriver("Screwdriver");
    public static final Banana BANANA = new Banana();

    //9 HINTS TOTAL: Cabinet, Drawer, Briefcase, Red Book, Blue Book, Screwdriver, Painting, Receipt1, Receipt2
    public static final Hint HINTCAB = new Hint("Hint 0", "2 _ _ _");
    public static final Hint HINTDRA = new Hint("Hint 1", "_ 6 _ _");
    public static final Hint HINTBRI = new Hint("Hint 2", "_ _ _ 0");
    public static final Hint HINTRED = new Hint("Hint 3", "_ _ 2 _"); 
    public static final Hint HINTBLU = new Hint("Hint 4", "My head's getting cold...");
    public static final Hint HINTSCR = new Hint("Hint 5", "Could this unscrew something?");
    public static final Hint HINTPAI = new Hint("Hint 6", "It's really pouring outside...");
    public static final Hint HINTRC1 = new Hint("Hint 7", "He has a bowl for just a single banana?");
    public static final Hint HINTRC2 = new Hint("Hint 8", "A receipt for only a single flower?");
       

    //13 HINTHOLDERS TOTAL
    public static final HintCarrier VENT = new HintCarrier(h_type.LOCK, "Vent", VENTSCREW);
    public static final HintCarrier REDBOOK = new HintCarrier(h_type.LOCK, "Red Book", REDLOCK);
    public static final HintCarrier CABINET = new HintCarrier(h_type.LOCK, "Dresser Cabinet", GREENLOCK);
    public static final HintCarrier DRAWER = new HintCarrier(h_type.LOCK, "Dresser Drawer", BLUELOCK);
    public static final HintCarrier BRIEFCASE = new HintCarrier(h_type.LOCK, "Briefcase", PURPLELOCK);
    public static final HintCarrier SAFE = new HintCarrier(h_type.LOCK, "Safe", COMBOLOCK);
    public static final HintCarrier RECEIPT1 = new HintCarrier(h_type.NOLOCK, "Grocery Receipt", null);
    public static final HintCarrier RECEIPT2 = new HintCarrier(h_type.NOLOCK, "Florist Receipt", null);
    public static final HintCarrier BLUEBOOK = new HintCarrier(h_type.NOLOCK, "Blue Book", null);
    public static final HintCarrier FLOWERPOT = new HintCarrier(h_type.NOLOCK, "Flower Pot", null);
    public static final HintCarrier BANANABOWL = new HintCarrier(h_type.NOLOCK, "Banana Bowl", null);
    public static final HintCarrier COATRACK = new HintCarrier(h_type.NOLOCK, "Coat Rack", null);
    public static final HintCarrier UMBRELLAHOLDER = new HintCarrier(h_type.NOLOCK, "Umbrella Holder", null);
    public static final HintCarrier PAINTING = new HintCarrier(h_type.NOLOCK, "Painting", null);
    public static final HintCarrier FPAINTING = new HintCarrier(h_type.NOLOCK, "Herring Painting", null);

    //2 Tables
    public static final Table RECEIPTTABLE = new Table("Receipt Table");
    public static final Table BANANATABLE = new Table("Banana Table");

    //Current screen
    private static int currentscreen;

    //If the controls screen is currently open
    private static boolean controlscreen;

    //If the inventory screen is currently open
    private static boolean inventoryscreen;


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
        FLOWERPOT.setImage(Arrays.asList(Images.FLOWERPOT, Images.FLOWERPOT_KEY, Images.FLOWERPOT_EMPTY));
        COATRACK.setItem(BLUEKEY);
        COATRACK.setImage(Arrays.asList(Images.HAT_RACK, Images.HAT_RACK_ZOOM, Images.KEY_RACK_ZOOM, Images.EMPTY_RACK_ZOOM, Images.EMPTY_RACK));
        VENT.setItem(GREENKEY);
        VENT.setImage(Arrays.asList(Images.VENT_FAR, Images.VENT_ZOOM, Images.VENT_KEY, Images.VENT_EMPTY));
        BANANA.setKey(PURPLEKEY);
        BANANA.setImage(Arrays.asList(Images.BANANA, Images.BANANA_PEEL));
        SAFE.setItem(GOLDKEY);
        SAFE.setImage(Arrays.asList(Images.SAFE_CLOSED, Images.SAFE_KEY, Images.SAFE_EMPTY, Images.SAFE_OPEN));
        BANANABOWL.setItem(BANANA);
        BANANABOWL.setImage(Arrays.asList(Images.BANANA_TABLE_ZOOM, Images.EMPTY_TABLE_ZOOM));
        CABINET.setHint(HINTCAB);
        CABINET.setImage(Arrays.asList(Images.DRESSER_CLOSED, Images.CABINET_ZOOM, Images.DRESSER_CABINET, Images.DRESSER_BOTH));
        DRAWER.setHint(HINTDRA);
        DRAWER.setImage(Arrays.asList(Images.DRESSER_CLOSED, Images.DRAWER_ZOOM, Images.DRESSER_DRAWER, Images.DRESSER_BOTH));
        BRIEFCASE.setHint(HINTBRI);
        BRIEFCASE.setImage(Arrays.asList(Images.BRIEFCASE_CLOSED, Images.BRIEFCASE_TOP, Images.BRIEFCASE_OPEN));
        REDBOOK.setHint(HINTRED);
        REDBOOK.setImage(Arrays.asList(Images.RED_BOOK_CLOSED, Images.RED_BOOK_ZOOM, Images.RED_BOOK_ZOOM, Images.RED_BOOK_OPEN));
        BLUEBOOK.setHint(HINTBLU);
        BLUEBOOK.setImage(Arrays.asList(Images.BLUE_BOOK_SIDE, Images.BLUE_BOOK_ZOOM));
        PAINTING.setHint(HINTPAI);
        PAINTING.setImage(Arrays.asList(Images.PAINTING_NOTE, Images.PAINTING_NOTE_ZOOM));
        RECEIPT1.setHint(HINTRC1);;
        RECEIPT2.setHint(HINTRC2);
        UMBRELLAHOLDER.setHint(HINTSCR);
        UMBRELLAHOLDER.setImage(Arrays.asList(Images.UMBRELLA_SIDE, Images.UMBRELLA_SCREWDRIVER, Images.UMBRELLA_EMPTY));
        FPAINTING.setHint(new Hint("Fake Hint", "This painting seems completely normal"));
        FPAINTING.setImage(Arrays.asList(Images.PAINTING));
        
        RECEIPTTABLE.placeOnTop(RECEIPT1);
        RECEIPTTABLE.placeOnTop(RECEIPT2);
        RECEIPTTABLE.setImage(Arrays.asList(Images.RECEIPT_TABLE_SIDE, Images.RECEIPT_TABLE_TOP));
        BANANATABLE.placeOnTop(BANANABOWL);
        BANANATABLE.setImage(Arrays.asList(Images.BANANA_TABLE, Images.EMPTY_TABLE));
        
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
        notifyObservers(String.format("Advanced to %s", focused.getName()));
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
            notifyObservers("Opened " + i.getName());
            return ((Screw)i).unscrew(player.getEquipped());
        }
        else if (i instanceof Lock){
            notifyObservers("Unlocked " + i.getName());
            return ((Lock)i).keyUnlock(player.getEquipped());
        }
        else{
            notifyObservers("This item cannot be used here.");
            return false;
        }

    }
    public int getScreen(){
        return currentscreen;
    }

    public void toggleControls() {
        controlscreen = !controlscreen;
        if (controlscreen) {
            notifyObservers("Turned to screen controls");
        } else {
            notifyObservers(String.format("Turned to screen %d", currentscreen));
        }
    }

    public boolean controls() {
        return controlscreen;
    }

    public void toggleInventory() {
        inventoryscreen = !inventoryscreen;
        if (inventoryscreen) {
            notifyObservers("Turned to screen inventory");
        } else {
            notifyObservers(String.format("Turned to screen %d", currentscreen));
        }
    }

    public boolean inventory() {
        return inventoryscreen;
    }
}
