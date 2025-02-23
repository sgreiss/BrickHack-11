package src;
public class Item {
    public static enum item_type {
        KEY, SCREWDRIVER, BANANA, BANANA_PEEL;
    }
    private item_type type; // the type of item
    private String name; // the name of the item
    private String description; // the description of the item

    public Item(item_type type, String name) {
        this.type = type;
        this.name = name;
        switch(type) {
            case KEY:
                description = "Used to unlock keylocks";
                break;
            case SCREWDRIVER:
                description = "Used to take out screws";
                break;
            case BANANA: 
                description = "Used to gain potassium";
                break;
            case BANANA_PEEL:
                description = "Potassium gained, trash obtained";
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
}
