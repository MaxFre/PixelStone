package hearthstone;

import java.io.Serializable;

public class NormalStringMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5809556742429233439L; 
	
	String text;
	String name;
	int manaThisTurn;
	
	public NormalStringMessage(String text, String name,int manaThisTurn){
		this.text = text;
		this.name = name;
		this.manaThisTurn = manaThisTurn;
	}

	public String getName(){
		return name;
	}
	
	public String getText(){
		return text;
	}
	
	public int getManaThisTurn(){
		return manaThisTurn;
	}
}
