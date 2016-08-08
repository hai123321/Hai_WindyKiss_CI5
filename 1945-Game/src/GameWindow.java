//import javax.swing.*;

import controllers.*;
import models.Bullet;
import models.Direction;
import models.Plane;
import utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class GameWindow extends Frame implements Runnable {
    Image backgroundnd;
    //    Image myPlane;
    BufferedImage bufferedImage;
    Graphics bufferdImageGraphics;

//    boolean autoFire = false;

    PlaneController planeController1;
    Thread thread;

    public GameWindow() {
        planeController1 = PlaneController.getPlaneController1();


        System.out.println("Game window constructor");
        this.setVisible(true);
        this.setSize(768, 1024);
        this.setLocation(0, 0);
        backgroundnd = Utils.loadImage("resources/background.png");


        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addKeyListener(planeController1);

        //
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor"));


        this.bufferedImage = new BufferedImage(768, 1024, BufferedImage.TYPE_INT_ARGB);
        this.bufferdImageGraphics = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void update(Graphics g) {
        bufferdImageGraphics.drawImage(backgroundnd, 0, 0, null);
        planeController1.draw(bufferdImageGraphics);
        EnemyManager.instance.draw(bufferdImageGraphics);
        EnemyBulletManager.instance.draw(bufferdImageGraphics);
        GiftManager.instance.draw(bufferdImageGraphics);
        bufferdImageGraphics.drawString("Plane HP: " + PlaneController.getPlaneController1().getGameObject().getHp(), 50, 50);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(17);
                planeController1.run();
                EnemyManager.instance.run();
                CollsionPool.intance.run();
                GiftManager.instance.run();
                EnemyBulletManager.instance.run();
                repaint();
            }
        } catch (InterruptedException e) {

        }
    }


}


