package sk.zrebec.learn.java.designpatterns.observer;

public class Subscriber implements ISubscriber {

    private String name;
    private Channel channel = new Channel();

    /**
     * Constructor just sets the name of subscriber
     *
     * @param name Subscriber name
     */
    Subscriber(String name) {
        super();
        this.name = name;
    }


    @Override
    public void update() {
        System.out.println("Hey " + name + "! Video \"" + channel.getTitle() + "\" is uploaded now!");
    }

    @Override
    public void subscribeChannel(Channel ch) {

        channel = ch;

    }

}
