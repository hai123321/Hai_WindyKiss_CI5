package models;

import java.awt.*;

/**
 * Created by Nam Hai on 7/27/2016.
 */
public class Bullet extends GameObject{
    public static final int WIDTH = 13;
    public static final int HEIGHT = 33;
    public Bullet(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 1);
    }

    public Bullet(int x, int y, int width, int height) {
        super(x, y, width, height, 1);
    }
}
