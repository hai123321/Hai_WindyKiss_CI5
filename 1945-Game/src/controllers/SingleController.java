package controllers;

import models.GameObject;
import models.GameVector;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by Nam Hai on 7/30/2016.
 */
public class SingleController implements BaseController {
    protected GameObject gameObject;
    private GameDrawer gameDrawer;
    protected GameVector gameVector;


    public SingleController(GameObject gameObject, GameDrawer gameDrawer) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = new GameVector();
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    @Override
    public void draw(Graphics graphics) {
        gameDrawer.draw(graphics, gameObject);
    }

    @Override
    public void run() {
        gameObject.move(this.gameVector);
    }
}
