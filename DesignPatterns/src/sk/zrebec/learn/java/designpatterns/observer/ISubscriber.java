package sk.zrebec.learn.java.designpatterns.observer;

public interface ISubscriber {

    void update();

    void subscribeChannel(Channel ch);

}
