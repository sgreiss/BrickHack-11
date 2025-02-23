package src.interactables;

public class ComboLock extends Unlockable{
    private int code;
    public ComboLock(String name, int code){
        super(u_type.COMBO, name);
        this.code = code;
    }
    /**
     * Attempts to unlock the lock using a user's guess 
     * @param guess: the user's guess
     * @return true if the guess is correct and the lock is unlocked, false otherwise
     */
    public boolean comboUnlock(int guess){
        if (guess == code){
            return unlock();
        }
        return false;
    }
}
