package src.items;

import src.interactables.Interactable;

public class Item extends Interactable {

    private String name; // the name of the item
    private String description; // the description of the item

    public Item(String name, String description) {
        super(name);
        this.description = description;
    }
    /*
     * sets the name of the item (only relevant to banana since it has two states)
     * @param name: the name to be set
     */
    public void setDesc(String desc){
        description = desc;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
