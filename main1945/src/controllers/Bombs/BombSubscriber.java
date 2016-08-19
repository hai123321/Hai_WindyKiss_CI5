package controllers.bombs;

import models.GameObject;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public interface BombSubscriber {
    void onBombExplode(int x, int y);
    GameObject getGameObject();
}
