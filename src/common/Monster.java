package common;

import java.util.Random;

public class Monster {
	
	private String name;
	private int health;
	private int attack;
	private int defence;
	private int speed;
	private int gold;
	private int exp;
	private Random rand;
	private int randInt;
	
	public Monster() {
		
		rand = new Random();
		randInt = rand.nextInt(2);
		
		if(randInt == 0) {
			name = "Goblin";
			health = 30;
			randInt = rand.nextInt(5) + 5;
			attack = randInt;
			defence  = 3;
			speed = 1;
			gold = 40;
			exp = 40;
		} else {
			name = "Skeleton";
			health = 40;
			randInt = rand.nextInt(5) + 8;
			attack = randInt;
			defence  = 1;
			speed = 2;
			gold = 50;
			exp = 50;
		}
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public int getHealth() {
		
		return health;
		
	}
	
	public void setHealth(int a) {
		
		health = a;
		
	}
	
	public int getAttack() {
		
		return attack;
		
	}
	
	public int getDefence() {
		
		return defence;
		
	}
	
	public int getSpeed() {
		
		return speed;
		
	}
	
	public int getGold() {
		
		return gold;
		
	}
	
	public int getExp() {
		
		return exp;
		
	}
	
	public int getRandInt() {
		
		return randInt;
		
	}
	
	@Override
	public String toString() {
		
		String st = "Monster: " + name +
					"  Health: " + health +
					"  Attack: " + attack +
					"  Speed: " + speed;
		return st;
		
	}

}
