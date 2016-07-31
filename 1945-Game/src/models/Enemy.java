package models;

/**
 * Created by Nam Hai on 7/31/2016.
 */
public class Enemy extends GameObject {

    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;
    public static final int HP = 5;

    public Enemy(int x, int y) {
        super(x, y, WIDTH, HEIGHT, HP);
    }
}
