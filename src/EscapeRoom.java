package src;

import src.Item.item_type;
import src.Interactables.*;


public class EscapeRoom {
    private static final int NUM_SCREENS = 4;
    private static final int NUM_ITEMS = 6;

    //Main function to test all classes
    public static void main(String[] args) {
        ComboLock lock = new ComboLock(4576, "Greiss");
        Item key = new Item(item_type.KEY, "key");
        KeyLock otherlock = new KeyLock("key", "Goonin");
        if (otherlock.unlock(key)){
            System.out.println(otherlock.getName() + " successfully unlocked");
        }
    }
}