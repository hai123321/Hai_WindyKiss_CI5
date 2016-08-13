package controllers.Enemy;

import controllers.ControllerManager;

import java.util.Random;

/**
 * Created by qhuydtvt on 7/31/2016.
 */
public class EnemyControllerManager extends ControllerManager {

    private int count;
    private static final int RESPAWN_TYPE1 = 50;
    private static final int RESPAWN_TYPE2 = 100;

    private EnemyControllerManager() {
        super();
    }

    Random in = new Random();

    @Override
    public void run() {
        super.run();


        count++;

        int enX = in.nextInt(600);
        int enY = 10;

        if(count == RESPAWN_TYPE2) {
            count = 0;
            /* TODO: Generate plane controller 2 */
                EnemyController enemyController =
                        EnemyController.create(enX,
                                enY, EnemyPlaneType.WHITE);
                this.add(enemyController);
        }
        else if (count == RESPAWN_TYPE1) {
            enX = in.nextInt(300);
                EnemyController enemyController =
                        EnemyController.create(enX,
                                enY, EnemyPlaneType.YELLOW);
                this.add(enemyController);
        }
    }

    public final static EnemyControllerManager instance = new EnemyControllerManager();
}
