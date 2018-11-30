package hearthstone;

import java.io.IOException;

import ClientSide.ExAClient;

public class StartGame {		

	
	public StartGame(){
//		String playerName = JOptionPane.showInputDialog("input Name");
//		Controller controller = new Controller();
//		try {
//			new ExAClient(controller, "127.0.0.1", 1337, playerName);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	
	
	
	public static void main(String [] args) throws IOException{
//		StartGame run = new StartGame();
//		ExAServer go = new ExAServer(1337);
		ExAClient run = new ExAClient();
	}

}

