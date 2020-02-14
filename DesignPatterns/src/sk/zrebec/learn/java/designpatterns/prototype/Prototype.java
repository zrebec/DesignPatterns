package sk.zrebec.learn.java.designpatterns.prototype;

import java.util.ArrayList;

public class Prototype {
	
	private ArrayList<Integer> primeNumbers = new ArrayList<>();
	private int maxNumber;
	
	public Prototype(int i) {
		maxNumber = i;
		this.calculatePrimeNumbers();
	}
	
	private void calculatePrimeNumbers() {
		
		for(int i = 2; i <= maxNumber; i++) {
			boolean prime = true;
			for (int j = 2; j < (i / 2 + 1); j++) {
				if (i % j == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				// This is prime number
				primeNumbers.add(i);
			}
		}
	}

	public ArrayList<Integer> getPrimeNumbers() {
		return primeNumbers;
	}

}
