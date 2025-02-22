public class item {
    private static enum item_type {
        KEY, SCREWDRIVER, NOTEBOOK, BANANA;
    }
    private item_type type; // the type of item
    private String name; // the name of the item
    private String description; // the description of the item
    private String menu; // the menu that pulls up when the item is intereacted with

    public item(item_type type, String name, String description, String menu) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.menu = menu;
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