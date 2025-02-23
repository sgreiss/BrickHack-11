package src.gui;
import java.util.Objects;

import javafx.scene.image.Image;

public class Images {
    private static final String ASSETS_DIR = "resources/";

    // arrows
    public static Image ARROW_DOWN_BRIGHT = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/arrows/arrow_down_bright.PNG")));
    public static Image ARROW_DOWN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/arrows/arrow_down.PNG")));
    public static Image ARROW_LEFT_BRIGHT = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/arrows/arrow_left_bright.PNG")));
    public static Image ARROW_LEFT = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/arrows/arrow_left.PNG")));
    public static Image ARROW_RIGHT_BRIGHT = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/arrows/arrow_right_bright.PNG")));
    public static Image ARROW_RIGHT = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/arrows/arrow_right.PNG")));

    // background_images
    public static Image BACKGROUND = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/background_images/background.PNG")));
    public static Image WINDOW = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/background_images/window.PNG")));

    // banana
    public static Image BANANA_PEEL = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/banana/banana_peel.PNG")));
    public static Image BANANA_TABLE_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/banana/banana_table_zoom.PNG")));
    public static Image BANANA_TABLE = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/banana/banana_table.PNG")));
    public static Image BANANA = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/banana/banana.PNG")));
    public static Image EMPTY_TABLE_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/banana/empty_table_zoom.PNG")));
    public static Image EMPTY_TABLE = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/banana/empty_table.PNG")));

    // books
    public static Image BLUE_BOOK_SIDE = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/books/blue_book_side.PNG")));
    public static Image BLUE_BOOK_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/books/blue_book_zoom.PNG")));
    public static Image BOOKSHELF = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/books/bookshelf.PNG")));
    public static Image RED_BOOK_CLOSED = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/books/red_book_closed.PNG")));
    public static Image RED_BOOK_OPEN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/books/red_book_open.PNG")));
    public static Image RED_BOOK_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/books/red_book_zoom.PNG")));

    // briefcase
    public static Image BRIEFCASE_CLOSED = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/briefcase/briefcase_closed.PNG")));
    public static Image BRIEFCASE_OPEN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/briefcase/briefcase_open.PNG")));
    public static Image BRIEFCASE_TOP = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/briefcase/briefcase_top.PNG")));

    // door
    public static Image DOOR_CLOSED = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/door/door_closed.PNG")));
    public static Image DOOR_OPEN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/door/door_open.PNG")));

    // dresser
    public static Image CABINET_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/dresser/cabinet_zoom.PNG")));
    public static Image DRAWER_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/dresser/drawer_zoom.PNG")));
    public static Image DRESSER_BOTH = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/dresser/dresser_both.PNG")));
    public static Image DRESSER_CABINET = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/dresser/dresser_cabinet.PNG")));
    public static Image DRESSER_CLOSED = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/dresser/dresser_closed.PNG")));
    public static Image DRESSER_DRAWER = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/dresser/dresser_drawer.PNG")));

    // flowerpot
    public static Image FLOWERPOT_EMPTY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/flowerpot/flowerpot_empty.PNG")));
    public static Image FLOWERPOT_KEY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/flowerpot/flowerpot_key.PNG")));
    public static Image FLOWERPOT = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/flowerpot/flowerpot.PNG")));

    // hat_rack
    public static Image EMPTY_RACK_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/hat_rack/empty_rack_zoom.PNG")));
    public static Image EMPTY_RACK = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/hat_rack/empty_rack.PNG")));
    public static Image HAT_RACK_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/hat_rack/hat_rack_zoom.PNG")));
    public static Image HAT_RACK = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/hat_rack/hat_rack.PNG")));
    public static Image KEY_RACK_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/hat_rack/key_rack_zoom.PNG")));

    // inventory
    public static Image HOTBAR = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/inventory/hotbar.PNG")));
    public static Image INVENTORY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/inventory/inventory.PNG")));
    public static Image USE_BUTTON = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/inventory/use_button.PNG")));

    // locks - blue
    public static Image BLUE_KEY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/blue_lock/blue_key.PNG")));
    public static Image BLUE_LOCK_OPEN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/blue_lock/blue_lock_open.PNG")));
    public static Image BLUE_LOCK = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/blue_lock/blue_lock.PNG")));

    // locks - combo
    public static Image COMBO_LOCK_OPEN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/combo_lock/combo_lock_open.PNG")));
    public static Image COMBO_LOCK_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/combo_lock/combo_lock_zoom.PNG")));
    public static Image COMBO_LOCK = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/combo_lock/combo_lock.PNG")));

    // locks - gold
    public static Image GOLD_KEY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/gold_lock/gold_key.PNG")));
    public static Image GOLD_LOCK_OPEN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/gold_lock/gold_lock_open.PNG")));
    public static Image GOLD_LOCK = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/gold_lock/gold_lock.PNG")));

    // locks - green
    public static Image GREEN_KEY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/green_lock/green_key.PNG")));
    public static Image GREEN_LOCK_OPEN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/green_lock/green_lock_open.PNG")));
    public static Image GREEN_LOCK = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/green_lock/green_lock.PNG")));

    // locks - purple
    public static Image PURPLE_KEY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/purple_lock/purple_key.PNG")));
    public static Image PURPLE_LOCK_OPEN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/purple_lock/purple_lock_open.PNG")));
    public static Image PURPLE_LOCK = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/purple_lock/purple_lock.PNG")));

    // locks - red
    public static Image RED_KEY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/red_lock/red_key.PNG")));
    public static Image RED_LOCK_OPEN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/red_lock/red_lock_open.PNG")));
    public static Image RED_LOCK = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/locks/red_lock/red_lock.PNG")));

    // notebook
    public static Image NOTEBOOK_ITEM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/notebook/notebook_item.PNG")));
    public static Image NOTEBOOK_VIEW = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/notebook/notebook_view.PNG")));

    // paintings
    public static Image PAINTING_NOTE_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/paintings/painting_note_zoom.PNG")));
    public static Image PAINTING_NOTE = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/paintings/painting_note.PNG")));
    public static Image PAINTING = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/paintings/painting.PNG")));

    // receipt_table
    public static Image BANANA_RECEIPT = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/receipt_table/banana_receipt.PNG")));
    public static Image FLOWER_RECEIPT = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/receipt_table/flower_receipt.PNG")));
    public static Image RECEIPT_TABLE_SIDE = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/receipt_table/receipt_table_side.PNG")));
    public static Image RECEIPT_TABLE_TOP = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/receipt_table/receipt_table_top.PNG")));

    // safe
    public static Image SAFE_CLOSED = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/safe/safe_closed.PNG")));
    public static Image SAFE_EMPTY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/safe/safe_empty.PNG")));
    public static Image SAFE_KEY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/safe/safe_key.PNG")));
    public static Image SAFE_OPEN = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/safe/safe_open.PNG")));

    // screwdriver
    public static Image SCREWDRIVER = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/screwdriver/screwdriver.PNG")));
    public static Image UMBRELLA_EMPTY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/screwdriver/umbrella_empty.PNG")));
    public static Image UMBRELLA_SCREWDRIVER = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/screwdriver/umbrella_screwdriver.PNG")));
    public static Image UMBRELLA_SIDE = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/screwdriver/umbrella_side.PNG")));

    // vent
    public static Image VENT_EMPTY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/vent/vent_empty.PNG")));
    public static Image VENT_FAR = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/vent/vent_far.PNG")));
    public static Image VENT_KEY = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/vent/vent_key.PNG")));
    public static Image VENT_ZOOM = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/vent/vent_zoom.PNG")));
}