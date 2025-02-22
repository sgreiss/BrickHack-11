package src.interactables;
public abstract class keylock extends interactable{
    private String keyname;

    public keylock(String keyname){
        this.keyname = keyname;
    }

    public boolean unlock(item key){
        if (key.getName() == keyname){
            super.use();
        }

    }
}
