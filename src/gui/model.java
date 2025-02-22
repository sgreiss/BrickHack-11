package src.Gui;

import java.util.List;

public class Model {
    public static final int DIM = -1;
    private String[][] screen;
    private int screenNum;
    private final List<Observer<Model, String>> observers;

    public Model() {
        
    }

}