package src.Interactables;

public class ComboLock extends Unlockable{
    private int code;
    public ComboLock(String name, int code){
        super(u_type.COMBO, name);
        this.code = code;
    }
    public boolean comboUnlock(int guess){
        if (guess == code){
            return unlock();
        }
        return false;
    }
}
