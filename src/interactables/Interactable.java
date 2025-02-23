package src.interactables;
public class Interactable {
    //types: safe, table, paper
    private boolean usable; //whether the object can be interacted with or not
    private String name; //name of the interactable object

    public Interactable(String name) {
        usable = true; 
        this.name = name;
    }
    /**
     * this use method is how we're able to make certain items fail to be used later on in the escape room
     * @returns true if the object is successfully used, false otherwise
     */
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
