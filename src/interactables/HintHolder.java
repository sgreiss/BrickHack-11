package src.interactables;

public class HintHolder extends Interactable {
    private Interactable hint;
    private Unlockable condition;
    public HintHolder(String name, Unlockable condition) {
        super(name);
        this.condition = condition;
    }
    public Interactable getHint() {
        if (condition.isOpen()) {
            return hint;
        }
        return null;
    }
    
}
