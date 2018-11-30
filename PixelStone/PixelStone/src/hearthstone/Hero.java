package hearthstone;

public class Hero {

	private String name;
	private int health;
	private int attack;
	
		
	
	public Hero(String name, int health, int attack){
		this.name = name;
		this.health = health;
		this.attack = attack;
	}
	
	public String getName(){
		return name;
	}
	public int getHealth(){
		return health;
	}
	public int getAttack(){
		return attack;
	}
	public void setHealth(int health){
		this.health = health;
	}
	public void setAttack(int attack){
		this.attack = attack;
	}
	

}
