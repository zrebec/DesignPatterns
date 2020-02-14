package sk.zrebec.learn.java.designpatterns.observer;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        Channel javaLearning = new Channel();
        ArrayList<Subscriber> subs = new ArrayList<>();
        // Initialize subscribe names
        String[] names = {"Martin", "Fox", "Peter", "Lucy"};

        // Create new Subscriber instance for each name
        for (String name : names) {
            subs.add(new Subscriber(name));
        }

        // Add all subscribers in Channel subscribe
        for (Subscriber sub : subs) {
            javaLearning.subscribe(sub);
            sub.subscribeChannel(javaLearning);
        }

        javaLearning.upload("How to use Observer design pattern in Java");

    }

}
