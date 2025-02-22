package src;
public class Item {
    public static enum item_type {
        KEY, SCREWDRIVER, NOTEBOOK, BANANA;
    }
    private item_type type; // the type of item
    private String name; // the name of the item
    private String description; // the description of the item
    private String menu; // the menu that pulls up when the item is intereacted with

    public Item(item_type type, String name) {
        this.type = type;
        this.name = name;
        switch(type) {
            case item_type.KEY:
                description = "Used to unlock keylocks";
                break;
            case item_type.SCREWDRIVER:
                description = "Used to take out screws";
                break;
            case item_type.NOTEBOOK:
                description = "Used to store collected hints";
                break;
            case item_type.BANANA:
                description = "Used to gain potassium";
                break;
        }
    }

    public item_type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMenu() {
        return menu;
    }
}