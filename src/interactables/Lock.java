package src.Interactables;
import src.Item;
import src.Item.item_type;

public class Lock extends Interactable {
    public enum lock_type {
        COMBO, KEY;
    }
    private lock_type type; //type of lock
    private String key; //key for KEY type locks
    private int code; //code for COMBO type locks. Assumed to be a 4 digit number
    public Lock(lock_type type, String name, String unlock) {
        super(name);
        this.type = type;
        
        switch(type) {
            case COMBO:
                code = Integer.parseInt(unlock); //assumes that if the combo type is selected then the String will be a valid int
                key = null;
                break;
            case KEY:
                key = unlock; //assumes that unlock will be the name of the key that unlocks it
                code = 0;
                break;
        }
    }
    public boolean comboUnlock(int i){
        if (type != lock_type.COMBO || i != code){
            return false;
        }
        super.use();
        return true;
    }
    public boolean keyUnlock(Item i){
        if (type != lock_type.KEY || i.getType() != item_type.KEY || !i.getName().equals(key)){
            return false;
        }
        super.use();
        return true;
    }

    
}
