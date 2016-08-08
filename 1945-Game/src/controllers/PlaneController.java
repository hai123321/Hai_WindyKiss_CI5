package controllers;

import models.Bullet;
import models.Plane;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nam Hai on 7/30/2016.
 */
public class PlaneController extends SingleController implements KeyListener, Colliable {

    public static final int SPEED = 10;

    protected ControllerManager bulletManager;

    private Set<Integer> keyEventSet = new HashSet<>();

    private int bulletCD = 0;

    public PlaneController(Plane gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.bulletManager = new ControllerManager();
        CollsionPool.intance.add(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyEventSet.add(e.getKeyCode());
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        bulletManager.draw(graphics);
        bulletManager.run();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyEventSet.remove(e.getKeyCode());
    }

    @Override
    public void run() {
        super.run();
        changemove();
    }

    public void changemove() {
        bulletCD++;
        int x = 0;
        int y = 0;
        if (keyEventSet.contains(KeyEvent.VK_DOWN)) {
            y += SPEED;
        }
        if (keyEventSet.contains(KeyEvent.VK_UP)) {
            y -= SPEED;
        }
        if (keyEventSet.contains(KeyEvent.VK_RIGHT)) {
            x += SPEED;
        }
        if (keyEventSet.contains(KeyEvent.VK_LEFT)) {
            x -= SPEED;
        }
        this.gameVector.dy = y;
        this.gameVector.dx = x;
        if (bulletCD % 10 == 0) {
            bulletCD = 0;
            if (keyEventSet.contains(KeyEvent.VK_SPACE)) {
                BulletController bulletController = new BulletController(
                        new Bullet(this.gameObject.middleX() - Bullet.WIDTH / 2, this.gameObject.getY() - 130),
                        new ImageDrawer("resources/bullet.png")
                );

                bulletManager.add(bulletController);

                bulletController = new BulletController(
                        new Bullet(this.gameObject.getX(), this.gameObject.getY() - 100),
                        new ImageDrawer("resources/bullet.png")
                );

                bulletManager.add(bulletController);

                bulletController = new BulletController(
                        new Bullet(this.gameObject.getX() + this.gameObject.getHeight(), this.gameObject.getY() - 100),
                        new ImageDrawer("resources/bullet.png")
                );

                bulletManager.add(bulletController);
            }
        }


    }

    public static PlaneController planeController1;

    public static PlaneController getPlaneController1() {
        if (planeController1 == null) {
            planeController1 = new PlaneController(
                    new Plane(350, 900),
                    new ImageDrawer("resources/plane2.png")
            );
        }
        return planeController1;
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof BulletEnemyController) {
            colliable.getGameObject().destroy();
            if (this.getGameObject().getHp() > 0) {
                this.getGameObject().changeHP(-1);
            }
        }
    }
}
