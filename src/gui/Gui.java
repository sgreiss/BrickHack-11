package src.gui;
import src.gui.Model;
import src.gui.Observer;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.util.Duration;

public class Gui extends Application implements Observer<Model, String> {
    private static Model model;

    private Label gameMessage;
    private BorderPane root = new BorderPane();
    private StackPane center = new StackPane();

    @Override
    public void init() {
        model = new Model();
        model.addObserver(this);
        model.ready();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Escape Room");
        // root.setStyle("-fx-background-color: linear-gradient(to bottom, #3a3a3a, #1e1e1e);");

        // gameMessage = new Label(Model.STARTMSG);
        // gameMessage.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        // gameMessage.setTextFill(Color.web("#f8f8f8"));
        // gameMessage.setWrapText(true);
        // gameMessage.setMaxWidth(600);
        // gameMessage.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 2, 0, 3, 3);");

        // StackPane messagePadding = new StackPane(gameMessage);
        // messagePadding.setPadding(new Insets(10, 20, 20, 20));
        // root.setTop(messagePadding);

        // Button readyButton = new Button("Ready");
        // readyButton.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        // readyButton.setStyle("-fx-background-color: #666666; -fx-text-fill: #f8f8f8; -fx-padding: 12px 24px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
        
        // readyButton.setOnMouseEntered(e -> {
        //     readyButton.setStyle("-fx-background-color: #888888; -fx-text-fill: #ffffff; -fx-padding: 12px 24px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
        //     ScaleTransition st = new ScaleTransition(Duration.millis(150), readyButton);
        //     st.setToX(1.1);
        //     st.setToY(1.1);
        //     st.play();
        // });

        // readyButton.setOnMouseExited(e -> {
        //     readyButton.setStyle("-fx-background-color: #666666; -fx-text-fill: #f8f8f8; -fx-padding: 12px 24px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
        //     ScaleTransition st = new ScaleTransition(Duration.millis(150), readyButton);
        //     st.setToX(1.0);
        //     st.setToY(1.0);
        //     st.play();
        // });
        
        // readyButton.setOnAction(e -> {
        //     model.turn(0);
        // });

        // StackPane buttonPadding = new StackPane(readyButton);
        // buttonPadding.setPadding(new Insets(20, 20, 200, 20));

        // root.setBottom(buttonPadding);
        
        // center = new StackPane();

        // Label startLabel = new Label(Model.WELCOME);
        // startLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        // startLabel.setTextFill(Color.web("#f8f8f8"));
        // startLabel.setWrapText(true);
        // startLabel.setMaxWidth(600);
        // startLabel.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 2, 0, 3, 3);");

        // StackPane centerPane = new StackPane(startLabel);
        // centerPane.setPadding(new Insets(0, 0, 0, 0));

        // center.getChildren().add(centerPane);
        // root.setCenter(center);

        Button test = new Button();
        test.setGraphic(new ImageView(src.gui.Images.ARROW_DOWN_BRIGHT));

        //stage.setScene(new Scene(root, 700, 700));
        stage.setScene(new Scene(test, 500, 500));
        stage.show();
    }

    @Override
    public void update(Model model, String message) {
        //TODO: add key bind commands
        //TODO: add screen switching
    }

    private void screen0() {
        
    }

    // @Override
    // public void stop() {
    //     model.exit();
    // }

    public static void main(String[] args) {
        Application.launch(args);
    }
}