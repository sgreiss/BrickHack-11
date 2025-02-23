package src.items;

public class Banana extends Item {
    public enum b_state{
        BANANA, BANANA_PEEL;
    }
    private static final String DESCRIPTION = "A ripe banana. A good source of potassium.";
    private b_state state;
    private LockKey key;
    public Banana(){
        super("Banana", DESCRIPTION);
        state = b_state.BANANA;
    }

    public void setKey(LockKey key){
        this.key = key;
    }
    public LockKey eat(){
        if(state == b_state.BANANA){
            state = b_state.BANANA_PEEL;
            return key;
        }
        return null;
    }
    
}
