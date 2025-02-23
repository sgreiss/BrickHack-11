package src.interactables;

import src.Item;

public class HintHolder extends Interactable {
    public enum h_type{
        LOCK, NOLOCK;
    }
    private Paper hint;
    private Item item;
    private Unlockable condition;
    private h_type type;
    
    public HintHolder(h_type type, String name, Unlockable condition) {
        super(name);
        this.type = type;
        switch (type) {
            case LOCK:
                this.condition = condition;
            case NOLOCK:
                this.condition = null;
        }
    }
    public Paper getHint() {
        if (condition.isOpen() || type == h_type.NOLOCK){
            return hint;
        }
        return null;
    }
    public Item getItem()  {
        if (condition.isOpen() || type == h_type.NOLOCK) {
            return item;
        } 
        return null;
    }
    public void setHint(Paper hint) {
        this.hint = hint;
    }
    public void setItem(Item i){
        item = i;
    }
    
}
