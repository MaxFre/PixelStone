package ClientSide;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import hearthstone.Card;
import hearthstone.Controller;



public class ExAClient implements Runnable{
	
	Controller controller;
	String ipAdress;
	int port;
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	NormalStringMessage stringMessage;
	String PlayerName;
	ArrayList<Card> yourCardsOnField = new ArrayList<Card>();
	ArrayList<Card> enemyCardsOnField = new ArrayList<Card>();
	ArrayList<Card> theDeck;
	private Object obj;
	
	public ExAClient() throws IOException {
		this.ipAdress = "localhost";
		this.port = 1337;	
		socket = new Socket(ipAdress, port);
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());

		run();
	}
	
	public void rdy()  {
		try {	

			oos.writeObject(new NormalStringMessage("rdy", "1", 0));
			oos.flush();
			System.out.println("Client rdy sending to server");		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public  void run() {
		try {
			controller = new Controller(this);

			
			while(true){
			
			obj = ois.readObject();
			System.out.println("new object to client");
				
			if (obj instanceof NormalStringMessage) {
				NormalStringMessage mess = (NormalStringMessage) obj;
				System.out.println(mess.getText());
				if(mess.getText().equals("newTurn")){	
					System.out.println("Client gets new turn info");
					controller.newRound();
					controller.setMana(mess.getManaThisTurn());
				}
			}
			
			if (obj instanceof ArrayListMessage) {
				ArrayListMessage mess = (ArrayListMessage) obj;
				System.out.println("Client gets new card info");
				yourCardsOnField = mess.getYourCardsOnField();
				enemyCardsOnField = mess.getEnemyCardsOnField();
				
				controller.updateBoard(yourCardsOnField,enemyCardsOnField);
        	}
			
		 }
		} catch (IOException e) {e.printStackTrace();
		} catch (ClassNotFoundException e) {e.printStackTrace();
	    }
	  }
	

	
	public void doneThisTurn(){
		try {
			oos.writeObject(new NormalStringMessage("endTurn", PlayerName, 0));
			oos.flush();			
		} catch (IOException ex){}
	}
	
	public void updateBoard(ArrayList<Card> yourCardsOnTheField, ArrayList<Card> enemyCardsOnTheField){
		this.yourCardsOnField = yourCardsOnTheField;
		this.enemyCardsOnField = enemyCardsOnTheField;
		try {
			ArrayListMessage test = new ArrayListMessage(yourCardsOnField, enemyCardsOnField);
			System.out.println("sista check - " + test.getYourCardsOnField().size());	
			
			for(int i = 0; i<test.getYourCardsOnField().size(); i++){
				System.out.print("kollar kort i - " + test.getYourCardsOnField().get(i).getName()+"   ");
			}
			
			oos.writeObject(test);
			oos.flush();

		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Card> getYourCardsOnField(){
		return yourCardsOnField;
	}
	
	public ArrayList<Card> getEnemyCardsOnField(){
		return enemyCardsOnField;
	}
	
	
}
	
	
	

