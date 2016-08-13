package controllers.Enemy;

import controllers.PlaneController;
import models.EnemyBullet;
import models.GameObject;
import views.ImageDrawer;

/**
 * Created by Nam Hai on 8/13/2016.
 */
public class DropShotBehavior implements ShotBehavior {

    private final static int BULLET_SPEED = 10;
    private final static int SHOT_PERIOD = 50;
    private int count;

    @Override
    public void doShot(EnemyController enemyController) {
        count++;
        if (count >= SHOT_PERIOD) {
            count = 0;
            GameObject gameObject = enemyController.getGameObject();
            EnemyBulletController enemyBulletController =
                    new EnemyBulletController(
                            new EnemyBullet(
                                    gameObject.getMiddleX() - EnemyBullet.SIZE / 2,
                                    gameObject.getBottom()),
                            new ImageDrawer("resources/enemy_bullet.png")
                    );
            int dx = 0;
            int dy = BULLET_SPEED;
            enemyBulletController.getGameVector().dy = dy;
            enemyBulletController.getGameVector().dx = dx;
            EnemyBulletControllerManager.instance.add(enemyBulletController);
        }
    }
}
