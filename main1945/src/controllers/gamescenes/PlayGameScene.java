package controllers.gamescenes;

import controllers.bombs.BombControllerManager;
import controllers.CollsionPool;
import controllers.enemies.EnemyBulletControllerManager;
import controllers.enemies.EnemyControllerManager;
import controllers.PlaneController;
import models.GameObjectWithHP;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by qhuydtvt on 8/14/2016.
 */
public class PlayGameScene implements GameScene {

    private Image background;
    private static final String TAG = PlayGameScene.class.toString();

    private GameSceneListener gameSceneListener;

    public PlayGameScene() {
        reset();
    }


    private void reset() {
        background = Utils.loadImage("resources/background.png");
        PlaneController.instance.reset();
        EnemyBulletControllerManager.instance.reset();
        EnemyControllerManager.instance.reset();
        BombControllerManager.instance.reset();
        CollsionPool.instance.reset();
        CollsionPool.instance.add(PlaneController.instance);
    }


    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        PlaneController.instance.setGameSceneListener(gameSceneListener);
        this.gameSceneListener = gameSceneListener;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        PlaneController.instance.draw(g);
        EnemyControllerManager.instance.draw(g);
        EnemyBulletControllerManager.instance.draw(g);
        BombControllerManager.instance.draw(g);
    }

    @Override
    public KeyListener getKeyListener() {
        return PlaneController.instance;
    }

    @Override
    public void run() {
        if (((GameObjectWithHP) PlaneController.instance.getGameObject()).getHp() > 0) {
            PlaneController.instance.run();
            EnemyBulletControllerManager.instance.run();
            EnemyControllerManager.instance.run();
            BombControllerManager.instance.run();
            CollsionPool.instance.run();
        } else {

            if (gameSceneListener != null)
                gameSceneListener.changeGameScene(new EndGameScene());
            else {
                System.out.println(String.format(
                        "%s : gameSceneListener is not set",
                        TAG
                ));
            }
        }

    }

}
