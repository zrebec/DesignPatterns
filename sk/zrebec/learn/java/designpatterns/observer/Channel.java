package sk.zrebec.learn.java.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements IChannel {

    private List<Subscriber> subs = new ArrayList<>();
    private String title;

    @Override
    public void subscribe(Subscriber sub) {
        subs.add(sub);
    }

    @Override
    public void unSubscribe(Subscriber sub) {
        subs.remove(sub);
    }

    private void notifySubscribers() {
        for (Subscriber sub : subs) {
            sub.update();
        }
    }

    @Override
    public void upload(String title) {
        this.title = title;
        this.notifySubscribers();
    }

    @Override
    public String getTitle() {
        return title;
    }

}
