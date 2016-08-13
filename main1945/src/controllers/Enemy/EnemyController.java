package controllers.Enemy;

import controllers.Bombs.FreezzeSubcriber;
import controllers.Bombs.NotificationCenter;
import controllers.Bombs.BombSubscriber;
import controllers.Colliable;
import controllers.CollsionPool;
import controllers.SingleController;
import models.Enemy;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by qhuydtvt on 7/31/2016.
 */

public class EnemyController extends
        SingleController implements
        Colliable, BombSubscriber, FreezzeSubcriber {

    private EnemyState enemyState;
    private int frezzeCount;

    private static int FREZZE_PERIOD = 200;

    private FreezeBehavior freezeBehavior;
    private ShotBehavior shotBehavior;
    private FlyBehavior flyBehavior;

    public EnemyController(Enemy gameObject,
                           GameDrawer gameDrawer,
                           FreezeBehavior freezeBehavior,
                           ShotBehavior shotBehavior,
                           FlyBehavior flyBehavior) {
        super(gameObject, gameDrawer);

//        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
        NotificationCenter.instance
                .subsribe(this);
        NotificationCenter.instance
                .subsribeFrezze(this);
        enemyState = EnemyState.NORMAL;
        this.freezeBehavior = freezeBehavior;
        this.shotBehavior = shotBehavior;
        this.flyBehavior = flyBehavior;
        flyBehavior.doFly(this);
    }

    public EnemyState getEnemyState() {
        return enemyState;
    }

    public void setEnemyState(EnemyState enemyState) {
        this.enemyState = enemyState;
    }

    @Override
    public void onCollide(Colliable colliable) {

    }

    public static EnemyController create(int x, int y, EnemyPlaneType type) {
        EnemyController enemyController = null;
        switch (type) {
            case YELLOW:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_yellow_1.png"),
                        new FreezeBehavior(FREZZE_PERIOD),
                        new FollowShotBehavior(),
                        new DropFlyBehavior());
                break;
            case WHITE:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_white_1.png"),
                        new FreezeBehavior(FREZZE_PERIOD * 2),
                        new DropShotBehavior(),
                        new ZikzakFlyBehavior());
                break;
        }
        return enemyController;
    }

    @Override
    public void onBombExplode(int x, int y) {
        gameObject.destroy();
    }

    @Override
    public void run() {
        if (gameObject.getX() <= 0 || gameObject.getX() >= 600) {
            gameVector.dx = -gameVector.dx;
        }
        switch (this.enemyState) {
            case NORMAL:
                super.run();
                break;
            case FREZZED:
                break;
        }

        if (freezeBehavior != null)
            freezeBehavior.run(this);
        if (shotBehavior != null)
            shotBehavior.doShot(this);
    }

    @Override
    public void onFrezze(int x, int y) {
        enemyState = EnemyState.FREZZED;
        frezzeCount = 0;
    }
}
