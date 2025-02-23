package src;

import src.interactables.*;
import src.interactables.HintCarrier.h_type;
import src.items.*;

public class EscapeRoom {
    //Main function to show functionality of all classes
    public static void main(String[] args) {
        //declaring a KeyLock
        Lock keylock = new Lock("Red Lock", "Red Key");
        //declaring a Table
        Table table = new Table("Cedar Table");
        //declaring a Screw
        Screw screw = new Screw("Plus Shape Screw");
        //declaring a Hint
        Hint paper = new Hint("Note", "The code is 1357");
        //declaring a HintHolder
        HintCarrier hintholder = new HintCarrier(h_type.LOCK, "ComboSafe", keylock);
        //declaring another HintHolder
        HintCarrier hintholder2 = new HintCarrier(h_type.LOCK, "Vent", screw);

        //declaring a key
        LockKey key = new LockKey("Red Key");
        //declaring a banana
        //Banana banana = new Banana();
        //declaring a screwdriver
        Screwdriver screwdriver = new Screwdriver("CAT Screwdriver");

        //placing objects on table
        table.placeOnTop(screw);
        table.placeOnTop(keylock);
        table.placeOnTop(paper);

        System.out.println(table.checkInteractable(0).getName());
        System.out.println(table.checkInteractable(1).getName());
        System.out.println(table.checkInteractable(2).getName());

        //creating dud key
        //LockKey dudkey = new LockKey("bad key");

        //Opening hintholder before being unlocked
        if (hintholder.getHint() == null){
            System.out.println("No hint available for " + hintholder.getName());
        }
        if (hintholder2.getHint() == null){
            System.out.println("No hint available for " + hintholder2.getName());
        }

        //unlocking KeyLock
        if (keylock.keyUnlock(key)){
            System.out.println(keylock.getName() + " was unlocked by " + key.getName());
        }
        if (screw.unscrew(screwdriver)){
            System.out.println(screw.getName() + " was unscrewed by " + screwdriver.getName());
        }

        hintholder.setHint(paper);
        System.out.println(hintholder.getHint().getContents());

        if (keylock.isOpen()){
            System.out.println("Lock already Unlocked");
        }
    }
}