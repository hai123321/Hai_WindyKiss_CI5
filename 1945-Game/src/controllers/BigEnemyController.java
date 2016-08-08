package controllers;

import models.Bullet;
import models.GameObject;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.util.Random;

/**
 * Created by Nam Hai on 8/2/2016.
 */
public class BigEnemyController extends SingleController implements Colliable, Runnable {
    public static int SPEED = 5;
    private Random in = new Random();

    public BigEnemyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = SPEED;
        CollsionPool.intance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (in.nextInt(100) % 11 == 0) {
            BulletEnemyController bulletController = new BulletEnemyController(
                    new Bullet(this.gameObject.middleX() - Bullet.WIDTH / 2, this.gameObject.getY() + this.gameObject.getHeight(), 30, 30),
                    new ImageDrawer("resources/enemy_bullet.png")
            );

            EnemyBulletManager.instance.add(bulletController);
        }

        if (this.getGameObject().getX() > 720 || this.getGameObject().getHp() == 0) {
            this.gameObject.destroy();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof BulletController) {
            colliable.getGameObject().destroy();
            if (this.getGameObject().getHp() > 0) {
                this.getGameObject().changeHP(-1);
            } else {
                this.getGameObject().destroy();
            }
        }
        if (colliable instanceof GiftController) {
            if(((GiftController) colliable).gameVector.dy == 0){
                this.getGameObject().destroy();
                colliable.getGameObject().destroy();
            }
        }
    }
}
