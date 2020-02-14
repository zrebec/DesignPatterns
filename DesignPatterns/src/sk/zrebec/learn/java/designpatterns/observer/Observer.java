package sk.zrebec.learn.java.designpatterns.observer;

public interface Observer {

    void update();

    void subscribeChannel(Channel ch);

}
