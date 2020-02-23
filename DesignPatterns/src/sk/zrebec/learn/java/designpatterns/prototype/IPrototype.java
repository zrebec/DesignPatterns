package sk.zrebec.learn.java.designpatterns.prototype;

import java.util.ArrayList;

/**
 * In fact, in this case we have two options. The first one is that out interface will extends Cloneable interface
 * or otherwise our class can implements 2 interfaces. Our and then Cloneable
 */
public interface IPrototype extends Cloneable {

    ArrayList<Integer> getPrimeNumbers();

    Prototype getClone() throws CloneNotSupportedException;

}
