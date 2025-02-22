package src.Interactables;
import src.Item;
public class KeyLock extends Interactable{
    private String keyname; //key needed to unlock lock

    public KeyLock(String keyname, String lockname){
        super(lockname);
        this.keyname = keyname;
    }

    public boolean unlock(Item key){
        if (key.getName() == keyname){
            super.use();
            return true;
        }
        return false;

    }
}
