package src.interactables;

public class Unlockable extends Interactable {
    public enum u_type{
        KEYLOCK, COMBO, SCREW;
    }
    private u_type type;
    public Unlockable(u_type type, String name){
        super(name);
        this.type = type;
    }
    /*
     * attempts to unlock the lock. Assume appropriate key, combo, or screwdriver was used. Fails if the lock is already unlocked
     * @return true if the lock is successfully unlocked, false otherwise
     */
    public boolean unlock(){
        if (isUsable()){
            return use();
        }
        return false;
    }
    public boolean isOpen(){
        return !isUsable();
    }
    public u_type getType(){
        return type;
    }

}
