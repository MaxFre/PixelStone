package ServerSide;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import ClientSide.ArrayListMessage;
import ClientSide.NormalStringMessage;
import hearthstone.Card;




public class ExAServer{
	

    private ServerSocket serverSocket;
    String parts[];
    String response = "";
	private int nbrOfPlayers = 0;
	private int manaThisTurn = 11111;
	Socket ClientSocket =  null;
	Socket ClientSocket2 = null;
	NormalStringMessage message;
	ArrayListMessage arrayMessage;
	ArrayList<Card> playerOnesCardsonField = new ArrayList<Card>();
	ArrayList<Card> playerTwoCardsonField = new ArrayList<Card>();
	private ArrayList<serverClientThread> threads = new ArrayList<serverClientThread>();
	serverClientThread playerOne;
	serverClientThread playerTwo;
	private int rdyMessage = 0;
	Connection connection;
	
	
	   public ExAServer(int requestPort) {
		   System.out.println("startar servern, lyssnar p� " + requestPort);	    	 
	    	   connection = new Connection(requestPort);
	    	   connection.start();      
	    }
	    
	   public class Connection extends Thread {

		    private Connection(int port) {
		      try {
		        serverSocket = new ServerSocket(port);
		        InetAddress ip = InetAddress.getLocalHost();
		        System.out.println("Port number=" + port + "/n" + "IP= " + ip);
		     
		      } catch (IOException e) {
		        System.out.println(e);
	
		      }
		    }

	    public boolean startingUpGame(){
	    	rdyMessage++;
	    	if(rdyMessage==2){    
//	    		System.out.println("tell its go time");
	    		return true;
	    	}
	    	return false;
	    }
	    
	    public int theManaThisTurn(){
	    	if(manaThisTurn<10){
	    		manaThisTurn++;
	    	}
	    	return manaThisTurn;
	    }
	    
	    
	    
	    public void run() {  //ig�ng s�l�nge servern �r p�.	    	
	    	  
	    	 while (true) {
	    		try {    		
					ClientSocket = serverSocket.accept();
					    		
	    		if(nbrOfPlayers==1){
	    			nbrOfPlayers++;
//	    			 System.out.println("startin clientthread for playerTwo");
	    			playerTwo  = new serverClientThread(ClientSocket, threads, connection,2);
 			
	    		}
	    		
	    		else if(nbrOfPlayers==0){
	    			nbrOfPlayers++;
//	    			 System.out.println("startin clientthread for playerOne");
	    			playerOne = new serverClientThread(ClientSocket, threads, connection,1);
 			
	    		}
	    		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	    public void playerEndingTurn(int whoUAre){
//	    	System.out.println("tell other players its his turn");
	    	if(whoUAre==1){
	    		playerTwo.getInfoNewTurn();
	    	}
	    	
	    	else if(whoUAre==2){
				playerOne.getInfoNewTurn();
	    	}
	    }
	    
		public void updateBoard(ArrayList<Card> theOneCalling, ArrayList<Card> otherPlayers, int whoUAre){	
			System.out.println("theOneCalling - " + theOneCalling.size());
			System.out.println("otherPlayers - " + otherPlayers.size());
			if(whoUAre==1){
				playerOne.updateBoard(theOneCalling,otherPlayers);
				playerTwo.updateBoard(otherPlayers,theOneCalling);
			}
			if(whoUAre==2){
				playerOne.updateBoard(otherPlayers,theOneCalling);
				playerTwo.updateBoard(theOneCalling,otherPlayers);
			}
			
		}
 }   
}


   