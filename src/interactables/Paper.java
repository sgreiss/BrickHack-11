package src.interactables;

public class Paper extends Interactable {
    private String contents;

    public Paper (String name, String contents) {
        super(name);
        this.contents = contents;
    }
    public String getContents() {
        return contents;
    }
}
