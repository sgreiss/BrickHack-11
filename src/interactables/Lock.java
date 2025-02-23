package src.interactables;

import src.items.Item;
import src.items.LockKey;

public class Lock extends Unlockable {
    private String key;
    public Lock(String name, String key){
        super(u_type.KEYLOCK, name);
        this.key = key;
    }
    public boolean keyUnlock(Item i){
        if ((i instanceof LockKey) && i.getName().equals(key)){
            i.use();
            return unlock();
        }
        return false;
    }
}
