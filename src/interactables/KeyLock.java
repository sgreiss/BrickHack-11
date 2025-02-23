package src.interactables;

import src.Item;
import src.Item.item_type;

public class KeyLock extends Unlockable {
    private String key;
    public KeyLock(String name, String key){
        super(u_type.KEYLOCK, name);
        this.key = key;
    }
    public boolean keyUnlock(Item i){
        if (i.getType() == item_type.KEY && i.getName().equals(key)){
            return unlock();
        }
        return false;
    }
}
