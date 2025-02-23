package src.interactables;

public class Hint extends Interactable {
    private String contents;

    public Hint (String name, String contents) {
        super(name);
        this.contents = contents;
    }
    /**
     * Returns the contents of the hint
     * @return content of hint (usually a sentence)
     */
    public String getContents() {
        use();
        return contents;
    }
}
