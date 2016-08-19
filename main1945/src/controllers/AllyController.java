package controllers;

import controllers.enemies.EnemyController;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by Nam Hai on 8/19/2016.
 */
public class AllyController extends SingleController implements Colliable {

    private double radian = 0;
    private double RADIUS = 100;
    private int SPEED = 8;
    private int COOLDOWN = 200;
    private int count;
    private int countcd;

    public AllyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            ((EnemyController) colliable).destroy();
        }
    }

    @Override
    public void run() {
        super.run();
        count++;
        countcd++;
        if (count == SPEED) {
            count = 0;
            this.getGameObject().moveTo(
                    (int) (PlaneController.instance.getGameObject().getMiddleX() - RADIUS * Math.cos(radian)),
                    (int) (PlaneController.instance.getGameObject().getMiddleY() - RADIUS * Math.sin(radian))
            );
            radian++;
            if (radian == 360) {
                radian = 0;
            }
        }
        if (countcd == COOLDOWN) {
            this.getGameObject().destroy();
        }
    }
}
