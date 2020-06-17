package sk.zrebec.learn.java.designpatterns.observer;

/**
 * This is Channel class interface. This class has 3 important methods like add subscriber, notify all subscribers
 * and upload method. Looks to the description of each method.
 */

public interface IChannel {

    /**
     * This method add new subscriber into arrayList
     *
     * @param sub Subscriber object
     */
    void subscribe(Subscriber sub);

    /**
     * Method remove subscriber from arrayList
     *
     * @param sub Subscriber object
     */
    void unSubscribe(Subscriber sub);

    /**
     * This method is shall be called if you upload new video into your video provider
     *
     * @param title Video title
     */
    void upload(String title);

    /**
     * Just return the video title, because subscriber class wants see video name which you uploaded
     *
     * @return Video title
     */
    String getTitle();
}
