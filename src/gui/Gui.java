package src.gui;
import src.gui.Model;
import src.gui.Observer;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Gui extends Application implements Observer<Model, String> {
    private static Model model;

    //@Override
    // public void init() {
    //     model = new Model();
    //     model.addObserver(this);
    //     model.ready();
    // }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Escape Room");
        stage.setScene(new Scene(new BorderPane(), 700, 700));
        stage.show();
    }

    @Override
    public void update(Model model, String message) {
        System.out.println(message);
    }

    // @Override
    // public void stop() {
    //     model.exit();
    // }

    public static void main(String[] args) {
        Application.launch(args);
    }
}