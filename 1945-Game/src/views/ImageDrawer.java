package views;

import models.GameObject;
import utils.Utils;

import java.awt.*;

/**
 * Created by Nam Hai on 7/30/2016.
 */
public class ImageDrawer implements GameDrawer {
    private Image image;

    public ImageDrawer(Image image) {
        this.image = image;
    }

    public ImageDrawer(String url) {
        this.image = Utils.loadImage(url);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    @Override
    public void draw(Graphics graphics, GameObject gameObject) {
        graphics.drawImage(image, gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight(), null);
    }
}
