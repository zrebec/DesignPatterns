package sk.zrebec.learn.java.designpatterns.prototype;

public class Program {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();

		/**
		 *
		 * Define Prototype and initialise max calculate size
		 * in constructor
		 */
		Prototype primeNumberCalculator = new Prototype(200000);
		
		long endTime = System.nanoTime();

		/**
		 *
		 * Print count of prime numbers defined in constructor
		 */
		System.out.println(primeNumberCalculator.getPrimeNumbers().size());
		System.out.println("Prototype runned " + ((endTime - startTime) / 1000000) + " miliseconds");
	}

}
