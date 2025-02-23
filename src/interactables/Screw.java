package src.interactables;

import src.items.Item;
import src.items.Screwdriver;

public class Screw extends Unlockable {
    public Screw(String screwname) {
        super(u_type.SCREW, screwname);
    }
    public boolean unscrew(Item i) {
        if (!(i instanceof Screwdriver) || !isUsable()){
            return false;
        }
        i.use();
        return unlock();
    }
}
