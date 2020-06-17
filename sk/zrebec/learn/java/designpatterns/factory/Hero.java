package sk.zrebec.learn.java.designpatterns.factory;

import java.util.Random;

public class Hero {

	private double health;
	private double regenerationAfterAttack;

	public Hero() {
		health = 100;
		regenerationAfterAttack = 6;
	}
	
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health + regenerationAfterAttack;
	}
	
	public int doesRun() {
		Random rn = new Random();
		return rn.nextInt(100) + 1;
	}
	
}
