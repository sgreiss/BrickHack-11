package interactables;
public abstract class interactable {
    //types: safe, table, paper
    private boolean usable;

    public interactable(){
        usable = true;
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