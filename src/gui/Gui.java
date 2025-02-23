package src.gui;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import src.gui.Model;
import src.gui.Observer;
import src.interactables.HintCarrier;
import src.interactables.Interactable;
import src.interactables.HintCarrier.h_type;
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
import src.items.Banana;
import src.items.Item;

public class Gui extends Application implements Observer<Model, String> {
    private static Model model;

    private boolean notebookselection;
    private Label gameMessage;
    private BorderPane root = new BorderPane();
    private Pane center = new Pane();

    private ImageView arrow_left = new ImageView();
    private ImageView arrow_right = new ImageView();
    private ImageView arrow_back = new ImageView();

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

        stage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ESCAPE && !model.inventory()) {
                model.toggleControls();
            } else if (e.getCode() == KeyCode.E && !model.controls()) {
                model.toggleInventory();
            } else if (e.getCode() == KeyCode.Q) {
                stop();
            }
        });
        notebookselection = true;
        stage.setScene(new Scene(root, 650, 700));
        stage.show();
    }

    @Override
    public void update(Model model, String message) {
        System.out.println(message);

        if(message.length() >= 16 && message.substring(0, 16).equals("Turned to screen")) {
            if (model.controls()) {
                controls_screen();
            } else if (model.notebook()) {
                notebook_screen();
            } else if (model.inventory()) {
                inventory_screen();
            } else {
                switch (Integer.parseInt(String.valueOf(message.charAt(17)))) {
                    case 0:
                        screen0();
                        break;
                    case 1:
                        screen1();
                        break;
                    case 2:
                        screen2();
                        break;
                    case 3:
                        screen3();
                }
            }
        }
        else if(message.length() >= 11 && message.substring(0, 11).equals("Advanced to")) {
            zoom_screen(message.substring(12));
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

    private void back_arrow() {
        arrow_back.setImage(src.gui.Images.ARROW_DOWN);
        arrow_back.setFitWidth(70);
        arrow_back.setFitHeight(70);
        arrow_back.setPreserveRatio(true);
        arrow_back.setPickOnBounds(false);
        arrow_back.setLayoutX(310);
        arrow_back.setLayoutY(570);
        arrow_back.setOnMouseEntered(e -> {
            arrow_back.setImage(src.gui.Images.ARROW_DOWN_BRIGHT);
            ScaleTransition st = new ScaleTransition(Duration.millis(150), arrow_back);
            st.setToX(1.1);
            st.setToY(1.1);
            st.play();
        });

        arrow_back.setOnMouseExited(e -> {
            arrow_back.setImage(src.gui.Images.ARROW_DOWN);
            ScaleTransition st = new ScaleTransition(Duration.millis(150), arrow_back);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });

        arrow_back.setOnMouseClicked(e -> {
            model.retreat();
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
            model.advance(Model.COATRACK);
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
            model.advance(Model.UMBRELLAHOLDER);
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
            model.advance(Model.FLOWERPOT);
        });

        ImageView receipt_table = new ImageView(src.gui.Images.RECEIPT_TABLE_SIDE);
        receipt_table.setFitWidth(400);
        receipt_table.setFitHeight(400);
        receipt_table.setPreserveRatio(true);
        receipt_table.setPickOnBounds(false);
        receipt_table.setLayoutX(-30);
        receipt_table.setLayoutY(245);
        receipt_table.setOnMouseClicked(e -> {
            model.advance(Model.RECEIPTTABLE);
        });

        ImageView briefcase = new ImageView(src.gui.Images.BRIEFCASE_CLOSED);
        briefcase.setFitWidth(300);
        briefcase.setFitHeight(300);
        briefcase.setPreserveRatio(true);
        briefcase.setPickOnBounds(false);
        briefcase.setLayoutX(235);
        briefcase.setLayoutY(340);
        briefcase.setOnMouseClicked(e -> {
            model.advance(Model.BRIEFCASE);
        });

        ImageView vent = new ImageView(src.gui.Images.VENT_FAR);
        vent.setFitWidth(100);
        vent.setFitHeight(100);
        vent.setPreserveRatio(true);
        vent.setPickOnBounds(false);
        vent.setLayoutX(460);
        vent.setLayoutY(470);
        vent.setOnMouseClicked(e -> {
            model.advance(Model.VENT);
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
            model.advance(Model.CABINET);
        });

        ImageView banana_table = new ImageView(src.gui.Images.BANANA_TABLE);
        banana_table.setFitWidth(400);
        banana_table.setFitHeight(400);
        banana_table.setPreserveRatio(true);
        banana_table.setPickOnBounds(false);
        banana_table.setLayoutX(250);
        banana_table.setLayoutY(245);
        banana_table.setOnMouseClicked(e -> {
            model.advance(Model.BANANATABLE);
        });

        center.getChildren().addAll(background, dresser, banana_table, arrow_left, arrow_right);

        root.setCenter(center);
        root.setBottom(null);
    }
    
    private void screen3() {
        left_arrow();
        right_arrow();

        root.setStyle("-fx-background-color: #666666;");
        center = new Pane();

        ImageView background = new ImageView(src.gui.Images.BACKGROUND);
        background.setFitWidth(650);
        background.setFitHeight(650);
        background.setPreserveRatio(true);

        ImageView normal_painting = new ImageView(src.gui.Images.PAINTING);
        normal_painting.setFitWidth(250);
        normal_painting.setFitHeight(250);
        normal_painting.setPreserveRatio(true);
        normal_painting.setPickOnBounds(false);
        normal_painting.setLayoutX(320);
        normal_painting.setLayoutY(100);

        ImageView hint_painting = new ImageView(src.gui.Images.PAINTING_NOTE);
        hint_painting.setFitWidth(250);
        hint_painting.setFitHeight(250);
        hint_painting.setPreserveRatio(true);
        hint_painting.setPickOnBounds(false);
        hint_painting.setLayoutX(80);
        hint_painting.setLayoutY(100);
        hint_painting.setOnMouseClicked(e -> {
            model.advance(Model.PAINTING);
        });

        ImageView safe = new ImageView(src.gui.Images.SAFE_CLOSED);
        safe.setFitWidth(200);
        safe.setFitHeight(200);
        safe.setPreserveRatio(true);
        safe.setPickOnBounds(false);
        safe.setLayoutX(60);
        safe.setLayoutY(360);
        safe.setOnMouseClicked(e -> {
            model.advance(Model.SAFE);
        });

        ImageView bookshelf = new ImageView(src.gui.Images.BOOKSHELF);
        bookshelf.setFitWidth(300);
        bookshelf.setFitHeight(300);
        bookshelf.setPreserveRatio(true);
        bookshelf.setLayoutX(320);
        bookshelf.setLayoutY(340);

        ImageView red_book = new ImageView(src.gui.Images.RED_BOOK_CLOSED);
        red_book.setFitWidth(400);
        red_book.setFitHeight(400);
        red_book.setPreserveRatio(true);
        red_book.setPickOnBounds(false);
        red_book.setLayoutX(295);
        red_book.setLayoutY(275);
        red_book.setOnMouseClicked(e -> {
            model.advance(Model.REDBOOK);
        });

        ImageView blue_book = new ImageView(src.gui.Images.BLUE_BOOK_SIDE);
        blue_book.setFitWidth(300);
        blue_book.setFitHeight(300);
        blue_book.setPreserveRatio(true);
        blue_book.setPickOnBounds(false);
        blue_book.setLayoutX(330);
        blue_book.setLayoutY(340);
        blue_book.setOnMouseClicked(e -> {
            model.advance(Model.BLUEBOOK);
        });
        center.getChildren().addAll(background, normal_painting, hint_painting, safe, bookshelf, red_book, blue_book, arrow_left, arrow_right);

        root.setCenter(center);
        root.setBottom(null);
    }

    private void zoom_screen(String interactable) {
        back_arrow();

        root.setStyle("-fx-background-color: #666666;");
        center = new Pane();

        switch(interactable) {
            case "Coat Rack": 
                ImageView hat_rack = new ImageView(src.gui.Images.HAT_RACK_ZOOM);
                hat_rack.setFitWidth(650);
                hat_rack.setFitHeight(650);
                hat_rack.setPreserveRatio(true);
                hat_rack.setLayoutX(0);
                hat_rack.setLayoutY(0);
                hat_rack.setOnMouseClicked(e -> {
                    System.out.println("Hanger clicked");
                });
                center.getChildren().addAll(hat_rack, arrow_back);
                break;
            case "Umbrella Holder": 
                ImageView umbrella_holder = new ImageView(src.gui.Images.UMBRELLA_SCREWDRIVER);
                umbrella_holder.setFitWidth(650);
                umbrella_holder.setFitHeight(650);
                umbrella_holder.setPreserveRatio(true);
                umbrella_holder.setLayoutX(0);
                umbrella_holder.setLayoutY(0);
                umbrella_holder.setOnMouseClicked(e -> {
                    System.out.println("Umbrella clicked");
                });
                center.getChildren().addAll(umbrella_holder, arrow_back);
                break;
            case "Receipt Table": 
                ImageView receipt_table = new ImageView(src.gui.Images.RECEIPT_TABLE_TOP);
                receipt_table.setFitWidth(650);
                receipt_table.setFitHeight(650);
                receipt_table.setPreserveRatio(true);
                receipt_table.setLayoutX(0);
                receipt_table.setLayoutY(0);
                ImageView banana_receipt = new ImageView(src.gui.Images.BANANA_RECEIPT);
                banana_receipt.setFitWidth(300);
                banana_receipt.setFitHeight(300);
                banana_receipt.setPreserveRatio(true);
                banana_receipt.setLayoutX(50);
                banana_receipt.setLayoutY(150);
                banana_receipt.setOnMouseClicked(e -> {
                    System.out.println("Banana Receipt clicked");
                });
                ImageView flower_receipt = new ImageView(src.gui.Images.FLOWER_RECEIPT);
                flower_receipt.setFitWidth(300);
                flower_receipt.setFitHeight(300);
                flower_receipt.setPreserveRatio(true);
                flower_receipt.setLayoutX(300);
                flower_receipt.setLayoutY(150);
                flower_receipt.setOnMouseClicked(e -> {
                    System.out.println("Flower Receipt clicked");
                });
                center.getChildren().addAll(receipt_table, banana_receipt, flower_receipt, arrow_back);
                break;
            case "Flower Pot": 
                ImageView flower_pot = new ImageView(src.gui.Images.FLOWERPOT_KEY);
                flower_pot.setFitWidth(650);
                flower_pot.setFitHeight(650);
                flower_pot.setPreserveRatio(true);
                flower_pot.setLayoutX(0);
                flower_pot.setLayoutY(0);
                flower_pot.setOnMouseClicked(e -> {
                    System.out.println("Flower Pot clicked");
                });
                center.getChildren().addAll(flower_pot, arrow_back);
                break;
            case "Vent": 
                ImageView vent = new ImageView(src.gui.Images.VENT_ZOOM);
                vent.setFitWidth(650);
                vent.setFitHeight(650);
                vent.setPreserveRatio(true);
                vent.setLayoutX(0);
                vent.setLayoutY(0);
                vent.setOnMouseClicked(e -> {
                    System.out.println("Vent clicked");
                });
                center.getChildren().addAll(vent, arrow_back);
                break;
            case "Briefcase": 
                ImageView briefcase = new ImageView(src.gui.Images.BRIEFCASE_TOP);
                briefcase.setFitWidth(650);
                briefcase.setFitHeight(650);
                briefcase.setPreserveRatio(true);
                briefcase.setLayoutX(0);
                briefcase.setLayoutY(0);
                briefcase.setOnMouseClicked(e -> {
                    System.out.println("Briefcase clicked");
                });
                center.getChildren().addAll(briefcase, arrow_back);
                break;
            case "Dresser Cabinet", "Dresser Drawer": 
                ImageView dresser = new ImageView(src.gui.Images.DRESSER_CLOSED);
                dresser.setFitWidth(650);
                dresser.setFitHeight(650);
                dresser.setPreserveRatio(true);
                dresser.setLayoutX(0);
                dresser.setLayoutY(0);
                dresser.setOnMouseClicked(e -> {
                    System.out.println("Dresser clicked");
                });
                center.getChildren().addAll(dresser, arrow_back);
                break;
            case "Banana Table": 
                ImageView banana_table = new ImageView(src.gui.Images.BANANA_TABLE_ZOOM);
                banana_table.setFitWidth(650);
                banana_table.setFitHeight(650);
                banana_table.setPreserveRatio(true);
                banana_table.setLayoutX(0);
                banana_table.setLayoutY(0);
                banana_table.setOnMouseClicked(e -> {
                    System.out.println("Banana Table clicked");
                });
                center.getChildren().addAll(banana_table, arrow_back);
                break;
                case "Painting": 
                ImageView painting = new ImageView(src.gui.Images.PAINTING_NOTE_ZOOM);
                painting.setFitWidth(650);
                painting.setFitHeight(650);
                painting.setPreserveRatio(true);
                painting.setLayoutX(0);
                painting.setLayoutY(0);
                painting.setOnMouseClicked(e -> {
                    System.out.println("Painting clicked");
                });
                center.getChildren().addAll(painting, arrow_back);
                break;
                case "Safe": 
                ImageView safe = new ImageView(src.gui.Images.COMBO_LOCK_ZOOM);
                safe.setFitWidth(650);
                safe.setFitHeight(650);
                safe.setPreserveRatio(true);
                safe.setLayoutX(0);
                safe.setLayoutY(0);
                safe.setOnMouseClicked(e -> {
                    System.out.println("Banana Table clicked");
                });
                center.getChildren().addAll(safe, arrow_back);
                break;
                case "Red Book": 
                ImageView red_book = new ImageView(src.gui.Images.RED_BOOK_ZOOM);
                red_book.setFitWidth(650);
                red_book.setFitHeight(650);
                red_book.setPreserveRatio(true);
                red_book.setLayoutX(0);
                red_book.setLayoutY(0);
                red_book.setOnMouseClicked(e -> {
                    System.out.println("Red Book clicked");
                });
                center.getChildren().addAll(red_book, arrow_back);
                break;
            case "Blue Book": 
                ImageView blue_book = new ImageView(src.gui.Images.BLUE_BOOK_ZOOM);
                blue_book.setFitWidth(650);
                blue_book.setFitHeight(650);
                blue_book.setPreserveRatio(true);
                blue_book.setLayoutX(0);
                blue_book.setLayoutY(0);
                blue_book.setOnMouseClicked(e -> {
                    System.out.println("Blue Book clicked");
                });
                center.getChildren().addAll(blue_book, arrow_back);
                break;
        }

        root.setCenter(center);
        root.setBottom(null);
    }
    private void controls_screen() {
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #3a3a3a, #1e1e1e);");

        gameMessage = new Label(Model.CONTROLSMSG);
        gameMessage.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        gameMessage.setTextFill(Color.web("#f8f8f8"));
        gameMessage.setWrapText(true);
        gameMessage.setMaxWidth(600);
        gameMessage.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.3), 2, 0, 3, 3);");

        StackPane messagePadding = new StackPane(gameMessage);
        messagePadding.setPadding(new Insets(10, 20, 20, 20));
        root.setTop(messagePadding);

        StackPane buttonPadding = new StackPane(new Label(" "));
        buttonPadding.setPadding(new Insets(20, 20, 50, 20));

        root.setBottom(buttonPadding);

        center = new StackPane();

        Label controlsLabel = new Label(Model.CONTROLS);
        controlsLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        controlsLabel.setTextFill(Color.web("#f8f8f8"));
        controlsLabel.setWrapText(true);
        controlsLabel.setMaxWidth(600);
        controlsLabel.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 2, 0, 3, 3);");
        controlsLabel.setAlignment(Pos.CENTER);

        StackPane centerPane = new StackPane(controlsLabel);
        centerPane.setPadding(new Insets(0, 0, 0, 0));

        center.getChildren().add(centerPane);
        root.setCenter(center);
    }

    private void inventory_screen() {

        Pane oldScreen = (Pane) (root.getCenter());
        Pane inventoryScreen = new Pane();

        ImageView inventory = new ImageView(src.gui.Images.INVENTORY);
        inventory.setFitWidth(650);
        inventory.setFitHeight(650);
        inventory.setPreserveRatio(true);
        inventoryScreen.getChildren().add(inventory);

        ImageView notebook = new ImageView(Images.NOTEBOOK_ITEM);
        inventoryScreen.getChildren().add(notebook);
        notebook.setFitWidth(65);
        notebook.setFitHeight(65);
        notebook.setPreserveRatio(true);
        notebook.setPickOnBounds(true);
        notebook.setLayoutX(45);
        notebook.setLayoutY(145);
        notebook.setOnMouseClicked(e -> {
            System.out.println("Notebook active");
        });

        for (int j = 0; j < model.player.getInventory().length; j++) {
            Item i = model.player.getInventory()[j];
            if (i != null) {
                String name = i.getName();
                Image imagestr = null;
                if (name.contains("Key")) {
                    if (name.contains("Red")) {
                        imagestr = Images.RED_KEY;
                    } else if (name.contains("Blue")) {
                        imagestr = Images.BLUE_KEY;
                    } else if (name.contains("Purple")) {
                        imagestr = Images.PURPLE_KEY;
                    } else if (name.contains("Green")) {
                        imagestr = Images.GREEN_KEY;
                    } else if (name.contains("Gold")) {
                        imagestr = Images.GOLD_KEY;
                    }
                } else if (name.contains("Banana")) {
                    if (i.isUsable()) {
                        imagestr = Images.BANANA;
                    } else {
                        imagestr = Images.BANANA_PEEL;
                    }
                } else if (name.contains("Screwdriver")) {
                    imagestr = Images.SCREWDRIVER;
                }
                int x = 0;
                int y = 0;
                if (imagestr != null) {
                    if (j % 2 == 0) {
                        x = 195;
                    } else {
                        x = 45;
                    }
                    if (j < 1) {
                        y = 145;
                    } else if (j < 3) {
                        y = 280;
                    } else if (j < 5) {
                        y = 410;
                    } else {
                        y = 545;
                    }
                    ImageView item = new ImageView(imagestr);
                    inventoryScreen.getChildren().add(item);
                    item.setFitWidth(65);
                    item.setFitHeight(65);
                    item.setPreserveRatio(true);
                    item.setPickOnBounds(true);
                    item.setLayoutX(x);
                    item.setLayoutY(y);
                    item.setOnMouseClicked(e -> {
                        System.out.println(String.format("%s clicked", name));
                    });
                }
            }
        }

        ImageView use = new ImageView(Images.USE_BUTTON);
        inventoryScreen.getChildren().add(use);
        use.setFitWidth(400);
        use.setFitHeight(150);
        use.setPreserveRatio(true);
        use.setPickOnBounds(false);
        use.setLayoutX(400);
        use.setLayoutY(500);
        use.setOnMouseClicked(e -> {
            if (notebookselection) {
                notebookselection = false;
                model.toggleNotebook();
            }
            System.out.println("Use clicked");
        });

        StackPane center = new StackPane(oldScreen, inventoryScreen);

        root.setCenter(center);
        root.setBottom(null);
    }

    @Override
    public void stop() {
         System.exit(0);
     }

    public static void main(String[] args) {
        Application.launch(args);
    }
}