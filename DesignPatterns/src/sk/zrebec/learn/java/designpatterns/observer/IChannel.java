package sk.zrebec.learn.java.designpatterns.observer;

import java.util.List;

public interface IChannel {
    void subscribe(Subscriber sub);

    void unSubscribe(Subscriber sub);

    void notifySubscribers();

    void upload(String title);

    String getTitle();
}
