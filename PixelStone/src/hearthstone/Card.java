package hearthstone;

import javax.swing.ImageIcon;

public class Card {
	
	private int health;
	private int attack;
	private String name;
	private ImageIcon icon;

	
	public Card(String name, int health, int attack, ImageIcon icon){
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.icon = icon;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public int getAttack(){
		return attack;
	}
	public void setAttack(int attack){
		this.attack = attack;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public ImageIcon getImage(){
		return icon;
	}
}
