package models;

import java.awt.*;

/**
 * Created by Nam Hai on 7/24/2016.
 */

public class Plane extends GameObject {
    public static final int WIDTH = 70;
    public static final int HEIGHT = 59;
    public static final int HP = 100;

    public Plane(int x, int y) {
        super(x, y, WIDTH, HEIGHT, HP);
    }

}
