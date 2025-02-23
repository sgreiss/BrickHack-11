package src.gui;

import java.util.*;

public class Model {
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
        notifyObservers();
    }

}
