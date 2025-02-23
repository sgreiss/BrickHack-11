package src.interactables;

import src.items.Item;
import src.items.LockKey;

public class Lock extends Unlockable {
    private String key;
    public Lock(String name, String key){
        super(u_type.KEYLOCK, name);
        this.key = key;
    }
    /**
     * attempts to unlock the lock using an item
     * @param i: the item to be used
     * @return true if the item is a key and successfully unlocks the lock, false otherwise
     */
    public boolean keyUnlock(Item i){
        if ((i instanceof LockKey) && i.getName().equals(key)){
            i.use();
            return unlock();
        }
        return false;
    }
}
