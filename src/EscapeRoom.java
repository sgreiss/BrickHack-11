package src;

import java.util.*;

import src.Item.item_type;
import src.interactables.*;


public class EscapeRoom {
    private static final int NUM_SCREENS = 4;
    private static final int NUM_ITEMS = 6;

    //Main function to show functionality of all classes
    public static void main(String[] args) {
        //declaring a KeyLock
        KeyLock keylock = new KeyLock("Red Lock", "Red Key");
        //declaring a Table
        Table table = new Table("Cedar Table");
        //declaring a Screw
        Screw screw = new Screw("Plus Shape Screw");
        //declaring a Paper
        Paper paper = new Paper("Note", "The code is 1357");
        //declaring a HintHolder
        HintHolder hintholder = new HintHolder("ComboSafe", keylock);

        //declaring a key
        Item key = new Item(item_type.KEY, "Red Key");
        //declaring a banana
        Item banana = new Item(item_type.BANANA, "Ripe Banana");
        //declaring a screwdriver
        Item screwdriver = new Item(item_type.SCREWDRIVER, "CAT Screwdriver");

        //placing objects on table
        table.placeOnTop(screw);
        table.placeOnTop(keylock);
        table.placeOnTop(paper);

        System.out.println(table.checkInteractable(0).getName());
        System.out.println(table.checkInteractable(1).getName());
        System.out.println(table.checkInteractable(2).getName());

        //creating dud key
        Item dudkey = new Item(item_type.KEY, "bad key");

        //unlocking KeyLock
        if (keylock.keyUnlock(key)){
            System.out.println(keylock.getName() + " was unlocked by " + key.getName());
        }
        hintholder.setHint(paper);
        System.out.println(hintholder.getHint().getContents());

        if (keylock.isOpen()){
            System.out.println("Lock already Unlocked");
        }
    }
}