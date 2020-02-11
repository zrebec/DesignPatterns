package sk.zrebec.learn.java.designpatterns.factory;

public abstract class Enemy {

	private String name;
	private double speed;
	private double damage;
	private int stamina;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDamage() {
		return damage;
	}
	public void setDamage(double damage) {
		this.damage = damage;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public void followHero() { 
		
		System.out.println(getName() + " is following the hero!");
		
	}
	
	public void displayEnemy() {
		
		System.out.println(getName() + " spawns");
		
	}
	
	public void enemyAttacks() {
		
		System.out.println(getName() + " attacking and does " + getDamage() + " points of damage!");
		
	}
	
	
}

