package hearthstone;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.SwingUtilities;




public class ExAClient implements Runnable{
	
	Controller controller;
	String ipAdress;
	int port;
	Connection connection;
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	NormalStringMessage stringMessage;
	String PlayerName;
	ArrayList<Card> yourCardsOnField = new ArrayList<Card>();
	ArrayList<Card> enemyCardsOnField = new ArrayList<Card>();
	

	
	public ExAClient(Controller Controller, String ipAddress, int port, String NameOfPlayer) throws IOException {
		this.controller = Controller;
		this.ipAdress = ipAddress;
		this.port = port;		
		this.PlayerName = NameOfPlayer;
		controller.tellImHere(this);
		socket = new Socket(ipAddress, port);
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());		
		run();
	}
	
	public void rdy(){
		System.out.println("rdy from client");
		try {
			oos.writeObject(new NormalStringMessage("rdy", PlayerName, 0));
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doneThisTurn(){
		try {
			oos.writeObject(new NormalStringMessage("endTurn", PlayerName, 0));
			oos.flush();
		} catch (IOException ex){}
	}
	
	public void updateBoard(ArrayList<Card> yourCardsOnField, ArrayList<Card> enemyCardsOnField){
		this.yourCardsOnField = yourCardsOnField;
		this.enemyCardsOnField = enemyCardsOnField;
		try {
			oos.writeObject(new ArrayListMessage(yourCardsOnField, enemyCardsOnField));
			System.out.println("sending to server");
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Card> getYourCardsOnField(){
		return yourCardsOnField;
	}
	
	public ArrayList<Card> getEnemyCardsOnField(){
		return enemyCardsOnField;
	}
	

	@Override
	public void run() {
		try {
			oos.writeObject(new NormalStringMessage("Name",PlayerName,0));
			oos.flush();
			
						
			Object testobject = ois.readObject();
			if (testobject instanceof NormalStringMessage) {
				NormalStringMessage mess = (NormalStringMessage) testobject;
				
				if(mess.getText().equals("newTurn")){
					
					controller.newRound();
					controller.setMana(mess.getManaThisTurn());
				}
			}
			
			if (testobject instanceof ArrayListMessage) {
				NormalStringMessage mess = (NormalStringMessage) testobject;
				
				if(mess.getText().equals("newTurn")){
					
					controller.newRound();
					controller.setMana(mess.getManaThisTurn());
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
	
	
	

