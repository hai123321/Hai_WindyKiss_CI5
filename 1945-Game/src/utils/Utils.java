package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nam Hai on 7/30/2016.
 */
public class Utils {
    public static Image loadImage(String url) {
        try {
            return ImageIO.read(new File(url));
        } catch (IOException e) {
            return null;
        }
    }
}
