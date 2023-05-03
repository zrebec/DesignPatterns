package sk.zrebec.learn.java.designpatterns.singleton;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is a sample of singleton class implementation.
 *
 * Method can be initialised only once. Any instances of this class
 * return the same instance which was the first.
 *
 * In this example method get random number from 0 to 50 and any other
 * instances always return the same number which was first
 *
 * The good usable of singleton for database connection for example. That means
 * we need just one instance of database connection and any instances of this class
 * return the same connection reference as first.
 *
 * See Program.java for implementation.
 *
 * THINK: Also you can use final reserve word in Singleton initialisation.
 *        private static final Singleton singletonInstance = new Singleton();
 *        Then you must remove initialisation on Singleton in getInstance method
 *
 * @author friskyfox
 * @version 1.2
 *
 */

public class Singleton {

	final private static Singleton singletonInstance = null;
	final private int singletonNumber;

	private static class LazyHolder {
		private static final Singleton INSTANCE = new Singleton();
	}


	//This is Singleton constructor. It must be private and return value
	private Singleton() {
		// Using ThreadLocalRandom to generate random number in a simpler way
		singletonNumber = ThreadLocalRandom.current().nextInt(1, 51);
	}

	/**
	 * This method return instance of singleton
	 * @return instance of singleton
	 */
	public static Singleton getSingletonInstance() {
		return LazyHolder.INSTANCE;
	}
	
	/**
	 * Method returns number which is initialised in constructor
	 * 
	 * @return random number from interval 1 to 50
	 */
	public int getSingletonRandomNumber() {
		return singletonNumber;
	}
}
