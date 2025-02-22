package src.Interactables;

import src.Item;
import src.Item.item_type;

public class Screw extends Unlockable {
    public Screw(String screwname) {
        super(u_type.SCREW, screwname);
    }
    public boolean unscrew(Item i) {
        if (i.getType() != item_type.SCREWDRIVER || !isUsable()){
            return false;
        }
        return unlock();
    }
}
