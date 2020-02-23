package sk.zrebec.learn.java.designpatterns.prototype;

import java.util.ArrayList;

public interface IPrototype {

    ArrayList<Integer> getPrimeNumbers();

    Prototype getClone();

}
