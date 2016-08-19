package controllers.bombs;

import models.GameObject;

/**
 * Created by Nam Hai on 8/19/2016.
 */
public interface ProtectSubcriber {
    void onProtected(int x, int y);
    GameObject getGameObject();
}
