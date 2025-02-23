package src.interactables;

import src.items.Item;

public class HintCarrier extends Interactable {
    public enum h_type{
        LOCK, NOLOCK;
    }
    private Hint hint;
    private Item item;
    private Unlockable condition;
    private h_type type;
    
    public HintCarrier(h_type type, String name, Unlockable condition) {
        super(name);
        this.type = type;
        switch (type) {
            case LOCK:
                this.condition = condition;
            case NOLOCK:
                this.condition = null;
        }
    }
    /**
     * gets hint unless the condition is locked
     * does not apply if the type of the carrier is NOLOCK
     * @return hint if successfully accessed, null otherwise
     */
    public Hint getHint() {
        if (condition.isOpen() || type == h_type.NOLOCK){
            return hint;
        }
        return null;
    }
    /**
     * gets item unless the condition is locked
     * does not apply if the type of the carrier is NOLOCK
     * @return item if successfully accessed, null otherwise
     */
    public Item getItem()  {
        if (condition.isOpen() || type == h_type.NOLOCK) {
            use();
            return item;
        } 
        return null;
    }
    /**
     * sets the hint of the carrier
     * @param hint: the hint to be set
     */
    public void setHint(Hint hint) {
        this.hint = hint;
    }
    /**
     * sets the item of the carrier
     * @param item: the item to be set
     */
    public void setItem(Item i){
        item = i;
    }
    
}
