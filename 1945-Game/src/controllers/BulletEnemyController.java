package controllers;

import models.GameObject;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by Nam Hai on 8/2/2016.
 */
public class BulletEnemyController extends SingleController implements Colliable {
    public static int SPEED = 20;

    public BulletEnemyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = (PlaneController.getPlaneController1().getGameObject().middleX() - this.getGameObject().getX()) / (3 * SPEED);
        this.gameVector.dy = (PlaneController.getPlaneController1().getGameObject().getY() - this.getGameObject().getY()) / (3 * SPEED);
        CollsionPool.intance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() > 1024 || gameObject.getY() < 0){
            gameObject.destroy();
        }
    }



    @Override
    public void onCollide(Colliable colliable) {
    }
}