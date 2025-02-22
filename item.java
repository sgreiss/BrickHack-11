public class item {
    private static enum item_type {
        KEY, SCREWDRIVER, NOTEBOOK, BANANA;
    }
    private item_type type; // the type of item
    private String name; // the name of the item
    private String description; // the description of the item
    

    public item(item_type type, String name, String description, boolean useable) {
        this.type = type;
        this.name = name;
        this.description = description;
    }
}