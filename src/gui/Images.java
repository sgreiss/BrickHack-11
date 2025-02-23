package src.gui;
import java.io.InputStream;
import java.util.Objects;

import javafx.scene.image.Image;

public class Images {
    private static final String ASSETS_DIR = "resources/";

    public static Image ARROW_DOWN_BRIGHT = new Image(Objects.requireNonNull(Images.class.getResourceAsStream(ASSETS_DIR+"/arrows/arrow_down_bright.PNG")));

}
