package hearthstone;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Deck {
	 ArrayList<Card> deck = new ArrayList<Card>();
	 Controller controller;
	 
	 
	public Deck(){
	   try {
		createDeck();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   showDeck();
	}

	
	 public void createDeck() throws IOException {

		 BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("resources/CardsToDeck.txt")));	

			while (true) {
				String word = "";
				String name = "";
				String image = "";
				int health = 0;
				int attack = 0;
				
								  
					
					  word = r.readLine();
					  name = word;
					  System.out.println("Name: " + name +" -  " +word); 

					  word = r.readLine();
					  health = Integer.parseInt(word);
					  System.out.println("health: " + health +" - " +word); 

					  word = r.readLine();
					  attack = Integer.parseInt(word);
					  System.out.println("attack: " + attack +" - " +word); 
					  
					  
					  word = r.readLine();
					  image = word;
					  ImageIcon icon = new ImageIcon("images/"+image+".png");
					  System.out.println("attack: " + attack +" - " +word); 
					  
					  deck.add(new Card(name, health, attack,icon));	
					  System.out.println("card added");
					  
					  
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
			 System.out.println("--------------------------");
		 }
	 }
}
