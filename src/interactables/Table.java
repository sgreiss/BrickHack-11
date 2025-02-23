package src.interactables;
import java.util.ArrayList;

public class Table extends Interactable {
    private ArrayList<Interactable> onTop;
    public Table(String name) {
        super(name);
        onTop = new ArrayList<>();
    }
    /*
     * places an interactable on top of the table
     * @param i the interactable to be placed on top of the table
     */
    public void placeOnTop(Interactable i) {
        onTop.add(i);
    }
    /*
     * accesses the interactable from the "index"th position of the table
     * @param index the index of the interactable to be accessed
     * @return the interactable at index
     */
    public Interactable checkInteractable(int index) {
        return onTop.get(index);
    }
}
