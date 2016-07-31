package views;

import models.GameObject;

import java.awt.*;

/**
 * Created by Nam Hai on 7/30/2016.
 */
public interface GameDrawer {
    void draw(Graphics graphics, GameObject gameObject);
}
