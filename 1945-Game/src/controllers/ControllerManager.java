package controllers;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Nam Hai on 7/30/2016.
 */
public class ControllerManager implements  BaseController{
    public Vector<SingleController> singleControllerVector;

    public ControllerManager() {
        singleControllerVector = new Vector<>();
    }

    public void add (SingleController singleController){
        this.singleControllerVector.add(singleController);
    }

    @Override
    public void draw(Graphics graphics) {
        for(BaseController controller : this.singleControllerVector){
            controller.draw(graphics);
        }
    }

    @Override
    public void run() {
        Iterator<SingleController> singleControllerIterator =
                this.singleControllerVector.iterator();
        while(singleControllerIterator.hasNext()){
            SingleController singleController = singleControllerIterator.next();
            if(!singleController.getGameObject().isAlive()){
                singleControllerIterator.remove();
            }else{
                singleController.run();
            }
        }
    }
}
