package src.gui;

public interface observer<Subject, ClientData> {
    void update(Subject subject, ClientData data);
}
