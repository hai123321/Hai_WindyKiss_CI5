package controllers.bombs;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 8/10/2016.
 */


public class NotificationCenter {
    private Vector<BombSubscriber> subscribers;
    private Vector<FreezzeSubcriber> freezzeSubcribers;
    private Vector<ProtectSubcriber> protectSubcribers;

    public NotificationCenter() {
        subscribers = new Vector<BombSubscriber>();
        freezzeSubcribers = new Vector<FreezzeSubcriber>();
        protectSubcribers = new Vector<ProtectSubcriber>();
    }

    public void subsribe(BombSubscriber bombSubscriber) {
        subscribers.add(bombSubscriber);
    }

    public void subsribeFrezze(FreezzeSubcriber bombSubscriber) {
        freezzeSubcribers.add(bombSubscriber);
    }


    public void subsribeProtected(ProtectSubcriber protectSubcriber) {
        protectSubcribers.add(protectSubcriber);
    }




    public void onBomExplode(int x, int y) {
        Iterator<BombSubscriber> bombSubscriberIterator = subscribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            BombSubscriber bombSubscriber = bombSubscriberIterator.next();
            if(!bombSubscriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                bombSubscriber.onBombExplode(x, y);
            }
        }
    }

    public void onProtected(int x, int y) {
        Iterator<ProtectSubcriber> protectSubcriberIterator = protectSubcribers.iterator();
        while(protectSubcriberIterator.hasNext()) {
            ProtectSubcriber protectSubcriber = protectSubcriberIterator.next();
            if(!protectSubcriber.getGameObject().isAlive()) {
                protectSubcriberIterator.remove();
            } else {
                protectSubcriber.onProtected(x, y);
            }
        }
    }

    public void onFrezze(int x, int y) {
        Iterator<FreezzeSubcriber> bombSubscriberIterator = freezzeSubcribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            FreezzeSubcriber freezzeSubcriber = bombSubscriberIterator.next();
            if(!freezzeSubcriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                freezzeSubcriber.onFrezze(x, y);
            }
        }
    }

    public static final NotificationCenter instance = new NotificationCenter();
}
