package models;

import java.awt.*;

/**
 * Created by Nam Hai on 7/30/2016.
 */
public class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int hp;

    protected boolean isAlive;

    public GameObject(int x, int y, int width, int height, int hp) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hp = hp;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void moveto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int middleX() {
        return this.x + this.width / 2;
    }

    public void move(GameVector gameVector) {
        x += gameVector.dx;
        y += gameVector.dy;
    }

    public boolean overlap(Rectangle rect) {
        return this.getRect().intersects(rect);
    }

    public boolean overlap(GameObject gameObject) {
        return overlap(gameObject.getRect());
    }

    private Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public void destroy() {
        this.isAlive = false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
