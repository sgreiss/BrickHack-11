package src;
public class Item {
    public static enum item_type {
        KEY, SCREWDRIVER, BANANA, BANANA_PEEL;
    }
    private item_type type; // the type of item
    private String name; // the name of the item
    private String description; // the description of the item
    private String menu; // the menu that pulls up when the item is intereacted with

    public Item(item_type type, String name) {
        this.type = type;
        this.name = name;
        switch(type) {
            case KEY:
                description = "Used to unlock keylocks";
                menu = "";
                break;
            case SCREWDRIVER:
                description = "Used to take out screws";
                menu = "";
                break;
            case BANANA:
                description = "Used to gain potassium";
                menu = "";
                break;
            case BANANA_PEEL:
                description = "Potassium gained, trash obtained";
                menu = "";
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