package src.Interactables;
import java.util.ArrayList;

public class Table {
    private ArrayList<> onTop;
    public Table(String name) {
        super(name);
        onTop = new ArrayList<>();
    }
    public void placeOnTop(Interactable i) {
        onTop.add(i);
    }
    public Interactable checkInteractable(int index) {
        return onTop.get(index);
    }
}
