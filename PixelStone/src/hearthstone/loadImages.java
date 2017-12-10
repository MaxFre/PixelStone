package hearthstone;

import java.awt.Image;

import javax.swing.ImageIcon;

public class loadImages {

	static ImageIcon emptySlot;
	static ImageIcon filler;
	static ImageIcon cardBack;
	static ImageIcon bakground;

	
	
	
	
	public loadImages(){	
	  emptySlot = new ImageIcon(new ImageIcon("images/binoimage.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	  filler = new ImageIcon(new ImageIcon("images/filler.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	  cardBack = new ImageIcon(new ImageIcon("images/cardBack.gif").getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));
	  bakground = new ImageIcon(new ImageIcon("images/bakgroundImage.png").getImage().getScaledInstance(1900, 1000, Image.SCALE_DEFAULT));
   }
	
	
	public static ImageIcon getFiller(){
		return filler;
	}
	
	public static ImageIcon getbakground(){
		return bakground;
	}
	
	public static ImageIcon getCardFiller(){
		return cardBack;
	}
	
	public static ImageIcon getEmptySlot(){
		return emptySlot;
	}
}