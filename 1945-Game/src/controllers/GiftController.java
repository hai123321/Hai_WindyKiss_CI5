package controllers;

import models.GameObject;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;

/**
 * Created by Nam Hai on 8/8/2016.
 */
public class GiftController extends SingleController implements Colliable, Runnable {

    private static final int SPEED = 5;
    private int COOLDOWN = 1;
    private int HEIGHT_BOOM = 50000;
    private int WEIGHT_BOOM = 50000;

    public GiftController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollsionPool.intance.add(this);
    }


    @Override
    public void run() {
        super.run();
        if(this.gameVector.dy == 0){
            COOLDOWN--;
        }
        if (gameObject.getY() > 1080 || COOLDOWN == 0) {
            gameObject.destroy();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }


    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.getGameObject().setX(this.getGameObject().middleX() - WEIGHT_BOOM / 2);
            this.getGameObject().setY(this.getGameObject().middleY() - HEIGHT_BOOM / 2);
            this.getGameObject().setHeight(HEIGHT_BOOM);
            this.getGameObject().setWidth(WEIGHT_BOOM);
            this.setGameDrawer(new ImageDrawer("resources/blank.png"));
            this.gameVector.dy = 0;
        }
    }

}
