package sk.zrebec.learn.java.designpatterns.observer;

/**
 * This is method which is called from Channel instance after upload method from channel.
 * Here should be all logic for one of each notified components.
 */

public interface ISubscriber {

    /**
     * This is method which is called from Channel instance after upload method from channel.
     * Here should be all logic for one of each notified components.
     */
    void update();

    /**
     * Add subscriber (this object instance) to Channel
     *
     * @param ch Channel object instance
     */
    void subscribeChannel(Channel ch);

}
