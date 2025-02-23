package src.interactables;

public class Hint extends Interactable {
    private String contents;

    public Hint (String name, String contents) {
        super(name);
        this.contents = contents;
    }
    public String getContents() {
        use();
        return contents;
    }
}
