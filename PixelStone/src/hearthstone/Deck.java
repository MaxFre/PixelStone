package hearthstone;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Deck {
	 ArrayList<Card> deck = new ArrayList<Card>();
	 Controller controller;
	 boolean sleep = true;
	 
	public Deck(){
	   try {
		createDeck();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	   showDeck();
	}

	
	 public void createDeck() throws IOException {

		ImageIcon emptySlot = new ImageIcon(new ImageIcon("images/binoimage.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		 
		 BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("resources/CardsToDeck.txt")));	

			while (true) {
				String word = "";
				String name = "";
				String image = "";
				String battleImage = "";
				String fightImage = "";
				int originalHealth = 0;
				int health = 0;
				int attack = 0;
				int cost = 0;
				
								  
					
					  word = r.readLine();
					  name = word;
//					  System.out.println("Name: " + name +" -  " +word); 

					  word = r.readLine();
					  health = Integer.parseInt(word);
					  originalHealth = health;
//					  System.out.println("health: " + health +" - " +word); 

					  word = r.readLine();
					  attack = Integer.parseInt(word);
//					  System.out.println("attack: " + attack +" - " +word); 
					  
					  word = r.readLine();
					  cost = Integer.parseInt(word);
//					  System.out.println("cost: " + cost +" - " +word); 
					  
					  word = r.readLine();
					  image = word;
					  ImageIcon icon = new ImageIcon(new ImageIcon("images/"+image+".png").getImage().getScaledInstance(155, 250, Image.SCALE_DEFAULT));
//					  ImageIcon icon = new ImageIcon("images/"+image+".png");
//					  System.out.println("image: " + image +" - " +word); 
					  
					  
					  word = r.readLine();
					  battleImage = word;
					  ImageIcon battleicon = new ImageIcon(new ImageIcon("images/"+battleImage+".png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
//					  System.out.println("battleimage: " + battleImage +" - " +word); 
					  
					  word = r.readLine();
					  fightImage = word;
					  ImageIcon fightIcon = new ImageIcon(new ImageIcon("images/"+fightImage+".png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
//					  System.out.println("battleimage: " + battleImage +" - " +word); 
					  
					  deck.add(new Card(name, health,originalHealth, attack,cost,sleep,icon,battleicon,fightIcon));	
//					  System.out.println("card added");
					  
					  
					  word = r.readLine();
					  
						if (word == null) {
							break;
						}
						  
			}
	 }
	 public ArrayList<Card> getDeck(){
		 return deck;
	 }
	 
	 
	 public void showDeck(){
		 for(int i = 0; i<deck.size(); i++){
			 System.out.println("Card:" + i);
			 System.out.println("Name:" +deck.get(i).getName());
			 System.out.println("Attack:" +deck.get(i).getAttack());
			 System.out.println("Health:" +deck.get(i).getHealth());
			 System.out.println("Cost:" +deck.get(i).getCost());
			 System.out.println("--------------------------");
		 }
	 }
}
