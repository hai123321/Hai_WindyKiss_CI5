package controllers;

import models.Bullet;
import models.Enemy;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.util.Random;

/**
 * Created by Nam Hai on 7/31/2016.
 */
public class EnemyController extends SingleController implements Colliable, Runnable{
    private Random in = new Random();
    private boolean down;

    public  static final  int SPEED = 5;

    private ControllerManager enemyBulletManager;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer, boolean down) {
        super(gameObject, gameDrawer);
        this.down = down;
        if(down){
            this.gameVector.dy = SPEED;
        } else {
            this.gameVector.dx = SPEED;
        }
        this.enemyBulletManager = new ControllerManager();
        CollsionPool.intance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
    }

    @Override
    public void run() {
        super.run();
        if(in.nextInt(100) % 11 == 0){
            if(!down){
                BulletController bulletController = new BulletController(
                        new Bullet(this.gameObject.middleX() - Bullet.WIDTH / 2, this.gameObject.getY() + this.gameObject.getHeight()),
                        new ImageDrawer("resources/bullet.png"),
                        true
                );

                enemyBulletManager.add(bulletController);
            }
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        enemyBulletManager.draw(graphics);
        enemyBulletManager.run();
    }
}
