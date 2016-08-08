package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by Nam Hai on 7/30/2016.
 */
public class BulletController extends SingleController implements Colliable {

    private static final int SPEED = 20;

    public BulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -SPEED;
        CollsionPool.intance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() < 0 || gameObject.getY() > 1024) {
            gameObject.destroy();
        }
    }



    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController || colliable instanceof BigEnemyController) {
            colliable.getGameObject().changeHP(-1);
        }


    }
}
