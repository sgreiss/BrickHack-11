package src.items;


// A key that opens a lock
public class LockKey extends Item {
    private static final String DESCRIPTION = "This key opens a lock. As expected of a key";
    public LockKey(String name) {
        super(name, DESCRIPTION);
    }
}
