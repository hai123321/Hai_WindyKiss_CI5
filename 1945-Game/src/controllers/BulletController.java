package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by Nam Hai on 7/30/2016.
 */
public class BulletController extends SingleController implements Colliable {

    private static final int SPEED = 20;

    public BulletController(GameObject gameObject, GameDrawer gameDrawer, Boolean enemy) {
        super(gameObject, gameDrawer);
        if (enemy) {
            this.gameVector.dx = (PlaneController.getPlaneController1().getGameObject().middleX() - this.getGameObject().getX()) / (3 * SPEED);
            this.gameVector.dy = (PlaneController.getPlaneController1().getGameObject().getY() - this.getGameObject().getY()) / (3 * SPEED);
        } else {
            this.gameVector.dy = -SPEED;
        }
        CollsionPool.intance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() < 0 || gameObject.getY() > 1024) {
            gameObject.destroy();
        }
        if (gameObject.getX() >700) {
            gameObject.destroy();
        }
    }


    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            colliable.getGameObject().destroy();
        }
    }
}
