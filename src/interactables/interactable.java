package src.interactables;
public abstract class interactable {
    //types: safe, table, paper
    private boolean usable; //whether the object can be interacted with or not
    private String name; //name of the interactable object

    public interactable(String name){
        usable = true;
        this.name = name;
    }
    public boolean use(){
        if (usable == true){
            usable = false;
            return true;
        }
        else {
            return false;
        }
    }
    public String getName(){
        return name;
    }
    public boolean getUsable(){
        return usable;
    }
}