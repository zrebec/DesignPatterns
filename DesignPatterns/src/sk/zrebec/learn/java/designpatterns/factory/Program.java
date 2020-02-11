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
 * But every enemy has all this parameters, only with different implementation. 
 * 
 * See Program.java for implementation.
 *  
 * @author friskyfox
 * @version 1.0
 *
 */

public class Program {

	public static void main(String[] args) {
		
		// TODO Implement this description
		/**
		 * 
		 * Hero running away of enemies. He/She must run 1km to safe
		 * Your task is kill hero before he runs away by different enemies
		 * 
		 * After any attack hero runs a random distance and his/her health
		 * regenerate by hero type
		 * 
		 */
		
		Enemy enemy = null;
		Scanner userInput = new Scanner(System.in);
		
		// TODO Make more heroes with different attribute values (Speed / Health / Regeneration)
		Hero hero = new Hero();
		
		
		while (hero.getHealth() >= 0) {
			System.out.println("What kind of enemy should attack? (T / R / Z)");
			
			
			if(userInput.hasNextLine()) {
				
				String typeOfEnemy = userInput.nextLine();
				enemy = EnemyFactory.makeEnemy(typeOfEnemy);
				
			}
			
			if(enemy != null) {
				hero.setHealth(hero.getHealth() - doStuffEnemy(enemy));
				System.out.println("Hero is still alive. His health is " + hero.getHealth());
			}
			
		}
		
		System.out.println("Hero is death " + hero.getHealth());
		userInput.close();
	}
	
	public static double doStuffEnemy(Enemy anEnemy) {

		anEnemy.displayEnemy();
		anEnemy.followHero();
		anEnemy.enemyAttacks();
		
		return anEnemy.getDamage();
		
	}

}
