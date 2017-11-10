package hearthstone;

import java.awt.Image;

import javax.swing.ImageIcon;

public class loadImages {

	static ImageIcon emptySlot;
	static ImageIcon filler;
	static ImageIcon cardBack;

	
	
	
	
	public loadImages(){	
	  emptySlot = new ImageIcon(new ImageIcon("images/binoimage.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	  filler = new ImageIcon(new ImageIcon("images/filler.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	  cardBack = new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(150, 250, Image.SCALE_DEFAULT));
   }
	
	
	public static ImageIcon getFiller(){
		return filler;
	}
	
	public static ImageIcon getCardFiller(){
		return cardBack;
	}
	
	public static ImageIcon getEmptySlot(){
		return emptySlot;
	}
}