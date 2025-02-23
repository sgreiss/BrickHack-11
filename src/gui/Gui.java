package src.gui;
import src.gui.Model;
import src.gui.Observer;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.util.Duration;

public class Gui extends Application implements Observer<Model, String> {
    private static Model model;

    private Label gameMessage;
    private BorderPane root = new BorderPane();
    private Pane center = new Pane();

    private ImageView arrow_left = new ImageView();
    private ImageView arrow_right = new ImageView();
    private ImageView arrow_down = new ImageView();

    @Override
    public void init() {
        model = new Model();
        model.addObserver(this);
        model.ready();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Escape Room");
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #3a3a3a, #1e1e1e);");

        gameMessage = new Label(Model.STARTMSG);
        gameMessage.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        gameMessage.setTextFill(Color.web("#f8f8f8"));
        gameMessage.setWrapText(true);
        gameMessage.setMaxWidth(600);
        gameMessage.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.3), 2, 0, 3, 3);");

        StackPane messagePadding = new StackPane(gameMessage);
        messagePadding.setPadding(new Insets(10, 20, 20, 20));
        root.setTop(messagePadding);

        Button readyButton = new Button("Ready");
        readyButton.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        readyButton.setStyle("-fx-background-color: #666666; -fx-text-fill: #f8f8f8; -fx-padding: 12px 24px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
        
        readyButton.setOnMouseEntered(e -> {
            readyButton.setStyle("-fx-background-color: #888888; -fx-text-fill: #ffffff; -fx-padding: 12px 24px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
            ScaleTransition st = new ScaleTransition(Duration.millis(150), readyButton);
            st.setToX(1.1);
            st.setToY(1.1);
            st.play();
        });

        readyButton.setOnMouseExited(e -> {
            readyButton.setStyle("-fx-background-color: #666666; -fx-text-fill: #f8f8f8; -fx-padding: 12px 24px; -fx-border-radius: 8px; -fx-background-radius: 8px;");
            ScaleTransition st = new ScaleTransition(Duration.millis(150), readyButton);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });
        
        readyButton.setOnAction(e -> {
            model.turn(0);
        });

        StackPane buttonPadding = new StackPane(readyButton);
        buttonPadding.setPadding(new Insets(20, 20, 200, 20));

        root.setBottom(buttonPadding);
        
        center = new StackPane();

        Label startLabel = new Label(Model.WELCOME);
        startLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        startLabel.setTextFill(Color.web("#f8f8f8"));
        startLabel.setWrapText(true);
        startLabel.setMaxWidth(600);
        startLabel.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 2, 0, 3, 3);");

        StackPane centerPane = new StackPane(startLabel);
        centerPane.setPadding(new Insets(0, 0, 0, 0));

        center.getChildren().add(centerPane);
        root.setCenter(center);

        stage.setScene(new Scene(root, 650, 700));
        stage.show();
    }

    @Override
    public void update(Model model, String message) {
        //TODO: add key bind commands
        System.out.println(message);

        if(message.length() >=16 && message.substring(0, 16).equals("Turned to screen")) {
            switch(Integer.parseInt(String.valueOf(message.charAt(17)))) {
                case 0:
                    screen0();
                    break;
                case 1:
                    screen1();
                    break;
                case 2:
                    screen2();
            }
        }
    }

    private void left_arrow() {
        arrow_left.setImage(src.gui.Images.ARROW_LEFT);
        arrow_left.setFitWidth(70);
        arrow_left.setFitHeight(70);
        arrow_left.setPreserveRatio(true);
        arrow_left.setPickOnBounds(false);
        arrow_left.setLayoutX(0);
        arrow_left.setLayoutY(300);
        arrow_left.setOnMouseEntered(e -> {
            arrow_left.setImage(src.gui.Images.ARROW_LEFT_BRIGHT);
            ScaleTransition st = new ScaleTransition(Duration.millis(150), arrow_left);
            st.setToX(1.1);
            st.setToY(1.1);
            st.play();
        });

        arrow_left.setOnMouseExited(e -> {
            arrow_left.setImage(src.gui.Images.ARROW_LEFT);
            ScaleTransition st = new ScaleTransition(Duration.millis(150), arrow_left);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });

        arrow_left.setOnMouseClicked(e -> {
            model.turn(-1);
        });
    }

    private void right_arrow() {
        arrow_right.setImage(src.gui.Images.ARROW_RIGHT);
        arrow_right.setFitWidth(70);
        arrow_right.setFitHeight(70);
        arrow_right.setPreserveRatio(true);
        arrow_right.setPickOnBounds(false);
        arrow_right.setLayoutX(585);
        arrow_right.setLayoutY(300);
        arrow_right.setOnMouseEntered(e -> {
            arrow_right.setImage(src.gui.Images.ARROW_RIGHT_BRIGHT);
            ScaleTransition st = new ScaleTransition(Duration.millis(150), arrow_right);
            st.setToX(1.1);
            st.setToY(1.1);
            st.play();
        });

        arrow_right.setOnMouseExited(e -> {
            arrow_right.setImage(src.gui.Images.ARROW_RIGHT);
            ScaleTransition st = new ScaleTransition(Duration.millis(150), arrow_right);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });

        arrow_right.setOnMouseClicked(e -> {
            model.turn(1);
        });
    }

    private void screen0() {
        left_arrow();
        right_arrow();

        root.setStyle("-fx-background-color: #666666;");
        center = new Pane();

        ImageView background = new ImageView(src.gui.Images.BACKGROUND);
        background.setFitWidth(650);
        background.setFitHeight(650);
        background.setPreserveRatio(true);

        ImageView hat_rack = new ImageView(src.gui.Images.HAT_RACK);
        hat_rack.setFitWidth(400);
        hat_rack.setFitHeight(400);
        hat_rack.setPreserveRatio(true);
        hat_rack.setPickOnBounds(false);
        hat_rack.setLayoutX(-60);
        hat_rack.setLayoutY(245);
        hat_rack.setOnMouseClicked(e -> {
            System.out.println("Hanger clicked");
        });

        ImageView door = new ImageView(src.gui.Images.DOOR_CLOSED);
        door.setFitWidth(500);
        door.setFitHeight(500);
        door.setPreserveRatio(true);
        door.setPickOnBounds(false);
        door.setLayoutX(75);
        door.setLayoutY(105);
        door.setOnMouseClicked(e -> {
            System.out.println("Door clicked");
        });

        ImageView umbrella_holder = new ImageView(src.gui.Images.UMBRELLA_SIDE);
        umbrella_holder.setFitWidth(250);
        umbrella_holder.setFitHeight(250);
        umbrella_holder.setPreserveRatio(true);
        umbrella_holder.setPickOnBounds(false);
        umbrella_holder.setLayoutX(450);
        umbrella_holder.setLayoutY(380);
        umbrella_holder.setOnMouseClicked(e -> {
            System.out.println("Umbrella clicked");
        });

        center.getChildren().addAll(background, hat_rack, door, umbrella_holder, arrow_left, arrow_right);

        root.setCenter(center);
        root.setBottom(null);
    }

    private void screen1() {
        left_arrow();
        right_arrow();

        root.setStyle("-fx-background-color: #666666;");
        center = new Pane();

        ImageView background = new ImageView(src.gui.Images.BACKGROUND);
        background.setFitWidth(650);
        background.setFitHeight(650);
        background.setPreserveRatio(true);

        ImageView window = new ImageView(src.gui.Images.WINDOW);
        window.setFitWidth(470);
        window.setFitHeight(470);
        window.setPreserveRatio(true);
        window.setPickOnBounds(false);
        window.setLayoutX(90);
        window.setLayoutY(-10);

        ImageView flowerpot = new ImageView(src.gui.Images.FLOWERPOT);
        flowerpot.setFitWidth(130);
        flowerpot.setFitHeight(130);
        flowerpot.setPreserveRatio(true);
        flowerpot.setPickOnBounds(false);
        flowerpot.setLayoutX(155);
        flowerpot.setLayoutY(230);
        flowerpot.setOnMouseClicked(e -> {
            System.out.println("Flowerpot clicked");
        });

        ImageView receipt_table = new ImageView(src.gui.Images.RECEIPT_TABLE_SIDE);
        receipt_table.setFitWidth(400);
        receipt_table.setFitHeight(400);
        receipt_table.setPreserveRatio(true);
        receipt_table.setPickOnBounds(false);
        receipt_table.setLayoutX(-30);
        receipt_table.setLayoutY(245);
        receipt_table.setOnMouseClicked(e -> {
            System.out.println("Receipt Table clicked");
        });

        ImageView briefcase = new ImageView(src.gui.Images.BRIEFCASE_CLOSED);
        briefcase.setFitWidth(300);
        briefcase.setFitHeight(300);
        briefcase.setPreserveRatio(true);
        briefcase.setPickOnBounds(false);
        briefcase.setLayoutX(235);
        briefcase.setLayoutY(340);
        briefcase.setOnMouseClicked(e -> {
            System.out.println("Briefcase clicked");
        });

        ImageView vent = new ImageView(src.gui.Images.VENT_FAR);
        vent.setFitWidth(100);
        vent.setFitHeight(100);
        vent.setPreserveRatio(true);
        vent.setPickOnBounds(false);
        vent.setLayoutX(460);
        vent.setLayoutY(470);
        vent.setOnMouseClicked(e -> {
            System.out.println("Vent clicked");
        });

        center.getChildren().addAll(background, receipt_table, window, flowerpot, briefcase, vent, arrow_left, arrow_right);

        root.setCenter(center);
        root.setBottom(null);
    }
    
    private void screen2() {
        left_arrow();
        right_arrow();

        root.setStyle("-fx-background-color: #666666;");
        center = new Pane();

        ImageView background = new ImageView(src.gui.Images.BACKGROUND);
        background.setFitWidth(650);
        background.setFitHeight(650);
        background.setPreserveRatio(true);

        ImageView dresser = new ImageView(src.gui.Images.DRESSER_CLOSED);
        dresser.setFitWidth(400);
        dresser.setFitHeight(400);
        dresser.setPreserveRatio(true);
        dresser.setPickOnBounds(false);
        dresser.setLayoutX(-30);
        dresser.setLayoutY(230);
        dresser.setOnMouseClicked(e -> {
            System.out.println("Dresser clicked");
        });

        ImageView banana_table = new ImageView(src.gui.Images.BANANA_TABLE);
        banana_table.setFitWidth(400);
        banana_table.setFitHeight(400);
        banana_table.setPreserveRatio(true);
        banana_table.setPickOnBounds(false);
        banana_table.setLayoutX(250);
        banana_table.setLayoutY(245);
        banana_table.setOnMouseClicked(e -> {
            System.out.println("Banana Table clicked");
        });

        center.getChildren().addAll(background, dresser, banana_table, arrow_left, arrow_right);

        root.setCenter(center);
        root.setBottom(null);
    }
    
    // @Override
    // public void stop() {
    //     model.exit();
    // }

    public static void main(String[] args) {
        Application.launch(args);
    }
}