package sk.zrebec.learn.java.designpatterns.factory;

public class EnemyFactory {
	
	public Enemy makeEnemy(String enemyOption) {
		return switch (enemyOption.toUpperCase()) {
			case "T" -> new Trooper();
			case "R" -> new Robot();
			case "Z" -> new Zombie();
			case "F" -> new FastZombie();
			default -> null;
		};
	}

}
