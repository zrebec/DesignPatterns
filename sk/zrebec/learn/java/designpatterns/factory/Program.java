package sk.zrebec.learn.java.designpatterns.factory;

import java.util.Scanner;

/**
 * This class is a sample of factory implementation.
 * 
 * Factory method return one or more instances of classes 
 * which has a common super class.
 * 
 * The good example is a generating enemies in game engine
 * Imagine, that you have more enemy types (zombies, troopers or robots).
 * Every enemy has a different speed, strength, stamina and damage.
 * But every enemy has all these parameters, only with different implementation.
 * 
 * See Program.java for implementation.
 *  
 * @author friskyfox
 * @version 1.0.1
 *
 */

public class Program {

	public static void main(String[] args) {
		
		/*

		  Hero running away of enemies. He/She must run 1km to safe
		  Your task is kill hero before he runs away by different enemies

		  After any attack hero runs a random distance and his/her health
		  regenerate by hero type

		 */

		final EnemyFactory enemyFactory = new EnemyFactory();
		Scanner userInput = new Scanner(System.in);
		Enemy enemy = null;
		final short safeDistance = 1000;
		int distance = 0;

		// TODO Make more heroes with different attribute values (Speed / Health / Regeneration)
		// TODO Is easy kill the hero with robots and run away with zombies e.g. This must be balanced. See description below
		
		/*
		  How to balance game?
		  Every enemy attacks to the hero. Speed of enemies are different, but we don't make the difference
		  when is the hero faster. Hero can run in one move random distance from 1 to 100m.

		   We must implement this to the enemies. Enemy has speed from 1 to 20. 1 represents 5 meters (20*5 = 100)

		   If hero get higher number before attack, he ran away and enemy cannot attack

		   Of course, we must find the balance. That means Fast Zombie will must have very high chance to catch the
		   hero and attacks. Normal Zombie will must have the lowest chance. But Fast Zombie gets a small attack and normal
		   zombie makes the attack with the highest damage. Trooper and Robots must be re-balanced too.

		   Don't remember, hero have a small health regeneration after every move.

		 */
		Hero hero = new Hero();


		while (hero.getHealth() >= 0 && distance <= safeDistance) {
			System.out.print("What kind of enemy should attack? (T / R / Z / F): ");


			if (userInput.hasNextLine()) {

				String typeOfEnemy = userInput.nextLine();
				enemy = enemyFactory.makeEnemy(typeOfEnemy);

			}

			if (enemy != null) {
				hero.setHealth(hero.getHealth() - doStuffEnemy(enemy));
				distance += hero.doesRun();
				System.out.println("Hero is still alive and runs " + distance + "m. After regegenration his health is still " + hero.getHealth());
			}
			
		}
		
		if (hero.getHealth() <= 0) {
			System.out.println("Hero is death. Game over");
		} else {
			System.out.println("Great! Your gets safe point! YOU ARE WINNER");
		}
	}
	
	public static double doStuffEnemy(Enemy anEnemy) {

		anEnemy.displayEnemy();
		anEnemy.followHero();
		anEnemy.enemyAttacks();
		
		return anEnemy.getDamage();
		
	}

}
