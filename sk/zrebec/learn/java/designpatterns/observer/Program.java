package sk.zrebec.learn.java.designpatterns.observer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is sample implementation of observer design pattern. Observer is a design pattern which inform all objects
 * for change. In this example we have subscribers, channel and this main implementation.
 * Class channel contains upload method and then call notify method for notify each of all subscribers (look to
 * channel class for more info). Subscriber class has update method which is called if notify method from channel is
 * called. In this case subscriber prints out new Video name.
 */

public class Program {

    public static void main(String[] args) {

        Channel javaLearning = new Channel();
        ArrayList<Subscriber> subs = new ArrayList<>();
        // Initialize subscribe names
        String[] names = {"Martin", "Fox", "Peter", "Lucy"};

        // Create new Subscriber instance for each name
        Arrays.stream(names).forEach(name -> subs.add(new Subscriber(name)));

        /*
          Add subscriber to javaLearning channel from subscribers ArrayList
          and each subscriber add to javaLearning channel
         */
        for (Subscriber sub : subs) {
            javaLearning.subscribe(sub);
            sub.subscribeChannel(javaLearning);
        }

        /*
          This is lambda method, but in this case is used for as example to use lambda expressions in Java
          In fact, classic for method is most effective here because here we are 2 cycles and above (uncommented section)
          we have just one cycle, and we can add actual subscriber to channel
         */

        /*
          Subscribe all subscribers from ArrayList
          subs.forEach(sub -> javaLearning.subscribe(sub));

          Add all subscribers into channel
          subs.forEach(sub -> sub.subscribeChannel(javaLearning));
        */

        // Upload new video
        javaLearning.upload("How to use Observer design pattern in Java");

    }

}
