package src.interactables;
public abstract class interactable {
    //types: safe, table, paper
    private boolean usable;
    private String name;

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
}