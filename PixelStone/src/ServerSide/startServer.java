package ServerSide;

import java.io.IOException;

import ClientSide.ExAClient;

public class startServer {
	
	public static void main(String [] args) throws IOException{
//		StartGame run = new StartGame();
		ExAServer go = new ExAServer(1337);
		ExAClient run = new ExAClient();

	}
}
