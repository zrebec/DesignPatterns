package sk.zrebec.learn.java.designpatterns.observer;


public class Subscriber implements Observer {

    private String name;
    private Channel channel = new Channel();

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
