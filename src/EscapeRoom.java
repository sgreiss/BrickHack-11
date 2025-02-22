package src;

import src.Item;
import src.Item.item_type;
import src.Interactables.ComboLock;

public class EscapeRoom {
    private static final int NUM_SCREENS = 4;
    private static final int NUM_ITEMS = 6;

    //Main function to test all classes
    public static void main(String[] args) {
        ComboLock lock = new ComboLock(4576, "Greiss");
        Item key = new Item(item_type.KEY, "key");
    }
}