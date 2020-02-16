package sk.zrebec.learn.java.designpatterns.prototype;

public class Program {

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		int primeNumbersIn = 200000;

		//Define Prototype and initialise max calculate size  in constructor
		Prototype primeNumberCalculator = new Prototype(primeNumbersIn);

		long endTime = System.nanoTime();

		//Print count of prime numbers defined in constructor
		System.out.println("We have " + primeNumberCalculator.getPrimeNumbers().size() + " prime numbers between 2 to " + primeNumbersIn);
		System.out.println("Initialization ran " + ((endTime - startTime) / 1000000) + " milliseconds");
		startTime = System.nanoTime();

		//Get clone
		try {
			Prototype clonePrimerNumberCalculator = (Prototype) primeNumberCalculator.getClone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		endTime = System.nanoTime();

		System.out.println("Clone ran ran " + ((endTime - startTime) / 1000000) + " milliseconds");
	}

}
