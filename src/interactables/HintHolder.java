package src.interactables;

import src.Item;

public class HintHolder extends Interactable {
    private Paper hint;
    private Item item;
    private Unlockable condition;
    public HintHolder(String name, Unlockable condition) {
        super(name);
        this.condition = condition;
    }
    public Paper getHint() {
        if (condition.isOpen()) {
            return hint;
        }
        return null;
    }
    public Item getItem()  {
        if (condition.isOpen()){
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
