package src.interactables;
import src.item;
public abstract class keylock extends interactable{
    private String keyname;

    public keylock(String keyname){
        this.keyname = keyname;
    }

    public boolean unlock(item key){
        if (key.getName() == keyname){
            super.use();
            return true;
        }
        return false;

    }
}
