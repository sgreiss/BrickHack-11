package src.Interactables;

import src.Item;
import src.Item.item_type;

public class Screw extends Interactable {
    public Screw(String screwname) {
        super(screwname);
    }
    public boolean unscrew(Item i) {
        if (i.getType() == item_type.SCREWDRIVER){
            super.use();
            return true;
        }
        return false;
    }
}
