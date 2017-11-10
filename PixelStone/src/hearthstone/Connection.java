package hearthstone;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Connection extends Thread {
	private String ipAddress;
	private int serverPort;
	private String toServer;
	Controller controller;
	
	public Connection(Controller Controller,String ipAddress, int serverPort, String toServer) {			
		this.ipAddress = ipAddress;
		this.serverPort = serverPort;
		this.toServer =  toServer;
		this.controller = Controller;
	}

	
	public void run() {  
		try (Socket socket = new Socket(ipAddress,serverPort); //h�r sker uppkopplongen till servern
			 DataOutputStream dos = new DataOutputStream(socket.getOutputStream());   //str�mmar f�r kommunication.
			 DataInputStream dis = new DataInputStream(socket.getInputStream()) ){    //v�ntar p� svar
			
			dos.writeUTF(toServer);  //skriver till servern	
			dos.flush();
//		
			
			String fromServer = dis.readUTF(); //l�ser av svaret 
			
			String first;
			String second;
			
			String[] parts = fromServer.split(",");
			first = String.valueOf((parts[0]));
			second = String.valueOf((parts[1]));
			
			if(first.equals("Mana")){
				int mana = Integer.parseInt(second);
				controller.setMana(mana);
			}
		} catch(Exception e) { 
		}
	}
}
