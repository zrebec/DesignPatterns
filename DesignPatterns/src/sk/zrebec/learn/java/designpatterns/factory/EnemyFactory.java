package sk.zrebec.learn.java.designpatterns.factory;

public class EnemyFactory {
	
	public Enemy makeEnemy(String enemyOption) {
		
		switch (enemyOption.toUpperCase()) {
		case "T":
			return new Trooper();
		case "R":
			return new Robot();
		case "Z":
			return new Zombie();
		case "F":
			return new FastZombie();
		default:
			return null;
		}
		
	}

}
