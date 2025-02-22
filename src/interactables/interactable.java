package src.Interactables;
public class Interactable {
    //types: safe, table, paper
    private boolean usable; //whether the object can be interacted with or not
    private String name; //name of the interactable object

    public Interactable(String name) {
        usable = true;
        this.name = name;
    }
    public boolean use() {
        if (usable){
            usable = false;
            return true;
        }
        else {
            return false;
        }
    }
    public String getName() {
        return name;
    }
    public boolean isUsable() {
        return usable;
    }
}