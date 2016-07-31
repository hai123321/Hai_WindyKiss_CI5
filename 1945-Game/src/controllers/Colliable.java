package controllers;

import models.GameObject;

/**
 * Created by Nam Hai on 7/31/2016.
 */
public interface Colliable {
    GameObject getGameObject();
    void onCollide(Colliable colliable);
}
