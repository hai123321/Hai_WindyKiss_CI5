package controllers;

import models.Gift;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by Nam Hai on 8/8/2016.
 */
public class GiftManager extends ControllerManager {

    public GiftManager() {
        super();
    }
    Random in = new Random();

    public static final GiftManager instance = new GiftManager();

    @Override
    public void run() {
        super.run();
        if(in.nextInt(100) == 0){
            GiftController giftController = new GiftController(
                    new Gift(in.nextInt(768), 0),
                    new ImageDrawer("resources/boom.png")
            );
            this.add(giftController);
        }
    }
}
