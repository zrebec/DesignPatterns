package sk.zrebec.learn.java.designpatterns.singleton;

/**
 * This is implementation exampleof Singleton in Singleton java in this package
 * @author friskyfox
 * @version 1.0
 *
 * THINK: It will be good connect do SQLite database and make example
 * 		  that any counts of instances returns the same database connection reference
 *
 */

public class Program {

	public static void main(String[] args) {


		// We can create any instances of this singleton
		Singleton number1 = Singleton.getSingletonInstance();
		Singleton number2 = Singleton.getSingletonInstance();
		Singleton number3 = Singleton.getSingletonInstance();
		Singleton number4 = Singleton.getSingletonInstance();


		//The output will be still same in all instances
		System.out.println(number1.getSingletonRandomNumber());
		System.out.println(number2.getSingletonRandomNumber());
		System.out.println(number3.getSingletonRandomNumber());
		System.out.println(number4.getSingletonRandomNumber());

	}
	
}
