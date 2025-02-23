package src.items;

public class Banana extends Item {
    public enum b_state{
        BANANA, BANANA_PEEL;
    }
    private static final String DESCRIPTION = "A ripe banana. A good source of potassium.";
    private static final String PEELDESCRIPTION = "A banana peel. It's slippery. And trash";
    private b_state state;
    private LockKey key;
    public Banana(){
        super("Banana", DESCRIPTION);
        state = b_state.BANANA;
    }

    public void setKey(LockKey key){
        this.key = key;
    }
    /*
     * eats the banana, turning it into a banana peel and accessing the key inside
     * @return the key if the banana was successfully eaten, null otherwise
     */
    public LockKey eat(){
        if(state == b_state.BANANA){
            state = b_state.BANANA_PEEL;
            setDesc(PEELDESCRIPTION);
            use();
            return key;
        }
        return null;
    }
    
}
