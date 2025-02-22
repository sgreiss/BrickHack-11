package src.interactables;

public class combolock extends interactable{
    private int code;
    public combolock(int code, String lockname){
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
