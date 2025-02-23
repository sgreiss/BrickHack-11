package src.items;

import src.interactables.Interactable;

public class Item extends Interactable {

    private String name; // the name of the item
    private String description; // the description of the item

    public Item(String name, String description) {
        super(name);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
