package models;

/**
 * Created by Nam Hai on 8/8/2016.
 */
public class Gift extends GameObject {
    public static final int WIDTH = 35;
    public static final int HEIGHT = 45;

    public Gift(int x, int y, int width, int height) {
        super(x, y, width, height, 1);
    }

    public Gift(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 1);
    }


}
