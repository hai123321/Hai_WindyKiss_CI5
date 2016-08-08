package controllers;

import models.Enemy;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by Nam Hai on 7/31/2016.
 */
public class EnemyController extends SingleController implements Colliable, Runnable {

    public static final int SPEED = 5;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollsionPool.intance.add(this);
    }


    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof BulletController) {
            if (colliable.getGameObject().getHp() > 0) {
                colliable.getGameObject().changeHP(-1);
            } else {
                colliable.getGameObject().destroy();
            }

        }
        if (colliable instanceof GiftController) {
            if (((GiftController) colliable).gameVector.dy == 0) {
                this.getGameObject().destroy();
                colliable.getGameObject().destroy();
            }
        }
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() > 1080 || this.getGameObject().getHp() == 0) {
            gameObject.destroy();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }
}
