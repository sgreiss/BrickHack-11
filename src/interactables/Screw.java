package src.interactables;

import src.items.Item;
import src.items.Screwdriver;

public class Screw extends Unlockable {
    public Screw(String screwname) {
        super(u_type.SCREW, screwname);
    }
    /**
     * Attempts to unscrew the screw using the item. Fails if the item is not a screwdriver or the screw is already unscrewed
     * @param i: item to unscrew screw
     * @return: true if the screw is successfully unscrewed, false otherwise
     */
    public boolean unscrew(Item i) {
        if (!(i instanceof Screwdriver) || !isUsable()){
            return false;
        }
        i.use();
        return unlock();
    }
}
