package hearthstone;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.SwingUtilities;


public class ExAServer extends Thread{
	
    private Thread server = new Thread(this);
    private DatagramSocket socket;
    private ServerSocket serverSocket;
    String parts[];
    String response = "";
	private String nameOfPlayerOne = "test1";
	private String nameOfPlayerTwo = "test2";
	private int nbrOfPlayers = 0;
	private int manaThisTurn = 11111;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos2;
	private ObjectInputStream ois2;
	Socket ClientSocket1 =  null;
	Socket ClientSocket2 = null;
	NormalStringMessage message;
	ArrayListMessage arrayMessage;
	ArrayList<Card> playerOnesCardsonField = new ArrayList<Card>();
	ArrayList<Card> playerTwoCardsonField = new ArrayList<Card>();
	
	   public ExAServer(int requestPort) {
		   System.out.println("startar servern, lyssnar p� " + requestPort);
	       try{
	    	   serverSocket = new ServerSocket(requestPort);
	           server.start();  
	       }catch (Exception e){ System.out.println("fel här i server?");}
	    }
	    
//	   public void whatToDo(String fromClient){
//		String first;
//		String second;
//		
//		parts = fromClient.split(",");
//		first = String.valueOf((parts[0]));
//		second = String.valueOf((parts[1]));
//
//		if(first.equals("Name")){
//			if(nbrOfPlayers==1){
//				nameOfPlayerOne = second;
//				System.out.println("player one is named: " + nameOfPlayerOne);
//				response = nameOfPlayerOne+",Mana,"+manaThisTurn;
//				if(manaThisTurn<10){
//					manaThisTurn++;
//				}
//			}
//			if(nbrOfPlayers==2){
//				nameOfPlayerTwo = second;
//				System.out.println("player two is named: " + nameOfPlayerTwo);
//				response = nameOfPlayerTwo+",Mana,"+manaThisTurn;
//				if(manaThisTurn<10){
//					manaThisTurn++;
//				}
//			}
//		}
//		
//		if(first.equals("Done")){
//			if(second.equals(nameOfPlayerTwo)){
//				response = nameOfPlayerOne+",urTurn,"+manaThisTurn;
//				if(manaThisTurn<10){
//					manaThisTurn++;
//				}
//			}
//			if(second.equals(nameOfPlayerOne)){
//				response = nameOfPlayerTwo+",urTurn,"+manaThisTurn;
//				if(manaThisTurn<10){
//					manaThisTurn++;
//				}
//			}
//		}
//				 
//	   }
	   
	   
	    public void run() {  //ig�ng s�l�nge servern �r p�.
	    	
	    	while(true){
	    		
	    		if(nbrOfPlayers==0){
	    			try {
						ClientSocket1 = serverSocket.accept();
						nbrOfPlayers++;
						System.out.println("Server - " + nbrOfPlayers);
					} catch (IOException e)  {
						System.out.println("Server problem line 100");
						e.printStackTrace();
					}
	    		}
//	    		if(nbrOfPlayers==1){
//	    			try {
//						ClientSocket2 = serverSocket.accept();
//						oos2 = new ObjectOutputStream(ClientSocket1.getOutputStream());
//	      				ois2 = new ObjectInputStream(ClientSocket1.getInputStream());
//					} catch (IOException e) {
//						System.out.println("Server problem line 108");
//						e.printStackTrace();
//					}
//	    		}
	    	
	    	
	    		try {
	    				  
	    			
	      				oos = new ObjectOutputStream(ClientSocket1.getOutputStream());
	      				ois = new ObjectInputStream(ClientSocket1.getInputStream());
	      				
	      				
	      				
	      				
	      				
	      			//PlayerOne Perspective	
	      			Object testobject = ois.readObject();
	    			if (testobject instanceof NormalStringMessage) {
	    				NormalStringMessage mess = (NormalStringMessage) testobject;
	    				System.out.println(" 1 . From server - " +mess.getText() +"  "+  mess.getName());
	    				oos.writeObject(new NormalStringMessage("newTurn",nameOfPlayerTwo, manaThisTurn));
						oos.flush();
	    				if(mess.getText().equals("rdy")){
	    					
	    				}
	    		
	    				if(mess.getText().equals("EndTurn")){
	    					endTurn();
	    					oos2.writeObject(new NormalStringMessage("newTurn",nameOfPlayerTwo, manaThisTurn));
							oos2.flush();
	    				}
	    				if(mess.getText().equals("Name")){
	    					if(nameOfPlayerOne.equals("")){
	    					nameOfPlayerOne = mess.getName();
	    					}
	    					else
	    						nameOfPlayerTwo = mess.getName();
	    				}
	    			}
	    			
	    			if (testobject instanceof ArrayListMessage) {
	    				ArrayListMessage mess = (ArrayListMessage) testobject;
	    					    				
	    				System.out.println("here in array " + mess.getEnemyCardsOnField());
	    				playerOnesCardsonField = mess.getYourCardsOnField();
	    				playerTwoCardsonField = mess.getEnemyCardsOnField();
	    				oos.writeObject(new ArrayListMessage(playerOnesCardsonField,playerTwoCardsonField));
//	    				oos.writeObject(new ArrayListMessage(playerTwoCardsonField,playerOnesCardsonField));
						oos.flush();
//						oos2.flush();
	    				
	    			}
//	      			//PlayerTwo Perspective	
//	    			if(ois2!=null){
//	      			Object testobject2 = ois2.readObject();
//	    			if (testobject2 instanceof NormalStringMessage) {
//	    				NormalStringMessage mess = (NormalStringMessage) testobject;
//	    					    				
//	    				if(mess.getText().equals("EndTurn")){
//	    					endTurn();
//	    					oos.writeObject(new NormalStringMessage("newTurn",nameOfPlayerOne, manaThisTurn));
//							oos.flush();
//	    				}
//	    				if(mess.getText().equals("Name")){
//	    					if(nameOfPlayerOne.equals("")){
//	    					nameOfPlayerOne = mess.getName();
//	    					}
//	    					else
//	    						nameOfPlayerTwo = mess.getName();
//	    				}
//	    			}
//	    			
//	    			if (testobject instanceof ArrayListMessage) {
//	    				ArrayListMessage mess = (ArrayListMessage) testobject;
//	    					    				
//	    				playerTwoCardsonField = mess.getYourCardsOnField();
//	    				playerOnesCardsonField = mess.getEnemyCardsOnField();
//	    				
//	    				oos2.writeObject(new ArrayListMessage(playerOnesCardsonField,playerTwoCardsonField));
//	    				oos.writeObject(new ArrayListMessage(playerTwoCardsonField,playerOnesCardsonField));
//						oos.flush();
//						oos2.flush();
//	    				
//	    			}}
	    			
	    			

	    		} catch(IOException | ClassNotFoundException e) { 
	    			System.out.println("Server problem line 187  " + e);
	    		}}
	      	}
	    		

	    public void endTurn(){
	    	if(manaThisTurn<10){
	    		manaThisTurn++;
	    	}
	    
	    }
	    
	    
	    public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {	
				try{
					new ExAServer(1337);
					
				} catch(Exception e){ System.out.println("Server problem line 206");;
			}
		}});
		
	 }
	    
   }