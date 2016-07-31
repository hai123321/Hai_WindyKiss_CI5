package controllers;

import models.Enemy;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by Nam Hai on 7/31/2016.
 */
public class EnemyManager extends ControllerManager {

    private EnemyManager() {
        super();


    }

    Random in = new Random();
    int enX = in.nextInt(768);
    int enY = 10;
    int cd = 0;

    @Override
    public void run() {
        super.run();
        cd++;
        if (cd % 50 == 0) {
            cd = 0;
            EnemyController enemyController = new EnemyController(
                    new Enemy(enX, enY),
                    new ImageDrawer("resources/enemy_plane_yellow_3.png"),
                    true
            );
            enX = in.nextInt(768);
            this.add(enemyController);

            enemyController = new EnemyController(
                    new Enemy(10, 200),
                    new ImageDrawer("resources/plane1.png"),
                    false
            );
            this.add(enemyController);
        }

    }

    public final static EnemyManager instance = new EnemyManager();
}
