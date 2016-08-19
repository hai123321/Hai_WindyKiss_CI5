package controllers.bombs;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.Bomb;
import utils.Utils;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public class BombController extends SingleController implements Colliable {

    private int COOLDOWN = 100;
    private int countcd;

    public BombController(Bomb gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    public static BombController create(int x, int y) {
        return new BombController(
                new Bomb(x, y),
                new ImageDrawer("resources/bomb.png"));
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {

            NotificationCenter.instance
                    .onBomExplode(gameObject.getX(), gameObject.getY());
            Utils.playSound("resources/explosion.wav", false);
            gameObject.destroy();
        }
    }

    @Override
    public void run() {
        super.run();
        countcd++;
        if (countcd == COOLDOWN) {
            this.getGameObject().destroy();
        }
    }
}
