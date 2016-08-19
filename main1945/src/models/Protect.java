package models;

/**
 * Created by Nam Hai on 8/19/2016.
 */
public class Protect extends GameObject {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;

    public Protect(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }

    public Protect(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
