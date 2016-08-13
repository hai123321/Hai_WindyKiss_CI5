package controllers.Enemy;

/**
 * Created by Nam Hai on 8/13/2016.
 */
public class ZikzakFlyBehavior implements FlyBehavior {
    public static final int SPEED = 3;


    @Override
    public void doFly(EnemyController enemyController) {
        enemyController.getGameVector().dx = SPEED;
        enemyController.getGameVector().dy = SPEED;
    }
}
