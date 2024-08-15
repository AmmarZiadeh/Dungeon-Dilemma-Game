package common;

import java.util.Random;

public class Character {
	
	private String name;
	private int health;
	private int maxHealth;
	private int attack;
	private int defence;
	private int speed;
	private int gold;
	private int exp;
	private int expNeeded;
	private Random rand;
	private int randInt1;
	private int randInt2;
	
	public Character(String a) {
		
		name = a;
		health = 100;
		maxHealth = 100;
		attack = 10;
		defence = 1;
		gold = 0;
		speed = 1;
		exp = 0;
		expNeeded = 150;
		rand = new Random();
		
	}
	
	public void attack(Monster m) {
		
		m.setHealth(m.getHealth() - attack + m.getDefence());
		if (m.getHealth() < 0) {
			m.setHealth(0);
		}
		
	}
	
	public void hit(Monster m) {
		
		health = health - m.getAttack() + defence;
		if (health < 0) {
			health = 0;
		}
		if (health >= 99999) {
			health = 99999;
		}
		
	}
	
	public void makeMoney(Monster m) {
		
		gold += m.getGold();
		if (gold >= 9999) {
			gold = 9999;
		}
		
	}
	
	public void gainExp(Monster m) {
		
		exp += m.getExp();
		if (exp > 99999) {
			exp = 99999;
		}
		expNeeded -= m.getExp();
		if (expNeeded < 0) {
			expNeeded = 0;
		}
		
	}
	
	public void defend(Monster m) {
		
		health -= m.getAttack()*0.2;
		if (health < 0) {
			health = 0;
		}
		
	}
	
	public int stun(Monster m) {
		
		randInt1 = rand.nextInt(4);
		randInt2 = rand.nextInt(4);
		if(randInt1 == randInt2) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	public void run(Monster m) {
		
		health -= m.getAttack()/2;
		if (health < 0) {
			health = 0;
		}
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String a) {
		
		name = a;
		
	}
	
	public int getHealth() {
		
		return health;
		
	}
	
	public void setHealth(int a) {
		
		health = a;
		
	}
	
	public int getMaxHealth() {
		
		return maxHealth;
		
	}
	
	public int setMaxHealth(int a) {
		
		maxHealth = a;
		return maxHealth;
		
	}
	
	public int getAttack() {
		
		return attack;
		
	}
	
	public void setAttack(int a) {
		
		attack = a;
		
	}
	
	public int getDefence() {
		
		return defence;
		
	}
	
	public void setDefence(int a) {
		
		defence = a;
		
	}
	
	public int getSpeed() {
		
		return speed;
		
	}
	
	public void setSpeed(int a) {
		
		speed = a;
		
	}
	
	public int getGold() {
		
		return gold;
		
	}
	
	public void setGold(int a) {
		
		gold = a;
		
	}
	
	public int getExp() {
		
		return exp;
		
	}
	
	public void setExp(int a) {
		
		exp = a;
		
	}
	
	public int getExpNeeded() {
		
		return expNeeded;
		
	}
	
	public void setExpNeeded(int a) {
		
		expNeeded = a;
		
	}
	
	@Override
	public String toString() {
		
		String st = "Your Health Points: " + health +
					"\nYour Attack Level: " + attack +
					"\nYour Speed Level: " + speed;
		return st;
		
	}
	
}
