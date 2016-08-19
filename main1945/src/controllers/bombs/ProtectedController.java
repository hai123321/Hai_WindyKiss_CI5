package controllers.bombs;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.Protect;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Nam Hai on 8/19/2016.
 */
public class ProtectedController extends SingleController implements Colliable {

    private static final int SPEED = 3;
    public ProtectedController(Protect gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
    }

    public static ProtectedController create(int x, int y) {
        return new ProtectedController(new Protect(x,y), new ImageDrawer("resources/lock.png"));
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            NotificationCenter.instance.onProtected(
                    gameObject.getX(),
                    gameObject.getY()
            );
            gameObject.destroy();
        }
    }
}