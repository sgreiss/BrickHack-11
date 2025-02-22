package src.Interactables;

public class ComboLock extends Interactable{
    private int code; //code to unlock lock
    public ComboLock(int code, String lockname){
        super(lockname);
        this.code = code;
    }
    public boolean unlock(int guess){
        if (guess == code){
            super.use();
            return true;
        }
        return false;
    }
    
}
