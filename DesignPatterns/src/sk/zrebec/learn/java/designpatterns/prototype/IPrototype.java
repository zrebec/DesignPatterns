package sk.zrebec.learn.java.designpatterns.prototype;

public interface IPrototype {

    public Prototype getClone() throws CloneNotSupportedException;

}
