package controllers.Enemy;

import models.GameObject;

/**
 * Created by Nam Hai on 8/13/2016.
 */
public class DropFlyBehavior implements FlyBehavior {
    public static final int SPEED = 3;

    @Override
    public void doFly(EnemyController enemyController) {
        GameObject gameObject = enemyController.getGameObject();
        int dx = 600 - gameObject.getX();
        int dy = 800 - gameObject.getY();
        if (dy > 0) {
            double ratio = Math.sqrt(dx * dx + dy * dy) / SPEED;
            enemyController.getGameVector().dy = (int) (dy / ratio);
            enemyController.getGameVector().dx = (int) (dx / ratio);
        }
    }
}




