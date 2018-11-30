package hearthstone;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Card implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7760495750667887268L;
	
	private int cost;
	private int health;
	private int attack;
	private int originalHealth;
	private boolean sleep;
	private String name;
	private ImageIcon image;
	private ImageIcon battleImage;
	private ImageIcon fightImage;

	
	public Card(String name, int health,int originalHealth, int attack, int cost, boolean sleep, ImageIcon image,ImageIcon battleImage,ImageIcon fightImage){
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.cost = cost;
		this.image = image;
		this.sleep = sleep;
		this.battleImage = battleImage;
		this.originalHealth = originalHealth;
		this.fightImage = fightImage;
	}
	
	public boolean getSleep(){
		return sleep;
	}
	
	public void setSleep(boolean sleep){
		this.sleep = sleep;
	}
	
	public int getOriginalHealth(){
		return originalHealth;
	}
	public int getHealth(){
		return health;
	}
	public int getCost(){
		return cost;
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
		return image;
	}
	public ImageIcon getBattleImage(){
		return battleImage;
	}
	public ImageIcon fightImage(){
		return fightImage;
	}
	
	
}
