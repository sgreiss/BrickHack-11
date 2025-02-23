package src.gui;

import java.util.*;

public class Model {
    private enum game_state {
        START, PLAY, END;
    }
    public static final String UNUSABLE = "This item has no use anymore.";
    public static final String UNDISCOVERED = "No use for this yet.";
    public static final String LOCKED = "This item is locked.";
    public static final String UNLOCKFAIL = "Failed to unlock this item.";

    1 combination locks
    5 keylocks
    public static final int DIM = -1;
    private String[][] screen;
    private int screenNum;
    private final List<Observer<Model, String>> observers;

    public Model() {
        this.observers = new ArrayList<>();
        init();
    }

    public void init() {
        screen = new String[DIM][DIM];
        screenNum = 0;
    }

}
