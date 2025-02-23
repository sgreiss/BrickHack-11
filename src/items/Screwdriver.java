package src.items;

// A screwdriver that can be used to unscrew screws
public class Screwdriver extends Item {
    private static final String DESCRIPTION = "A screwdriver with a cat design on the handle.";
    public Screwdriver(String name){
        super(name, DESCRIPTION);
    }
}
