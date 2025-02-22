package src;

import src.Item.item_type;
import src.Interactables.*;
import src.Interactables.Lock.lock_type;


public class EscapeRoom {
    private static final int NUM_SCREENS = 4;
    private static final int NUM_ITEMS = 6;

    //Main function to test all classes
    public static void main(String[] args) {
        //declaring a KeyLock
        Lock keylock = new Lock(lock_type.KEY, "Red Lock", "Red Key");
        Lock combolock = new Lock(lock_type.COMBO, "Blue Lock", "1357");
    }
}