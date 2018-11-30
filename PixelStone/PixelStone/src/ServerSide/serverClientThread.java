package ServerSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import ClientSide.ArrayListMessage;
import ClientSide.NormalStringMessage;
import ServerSide.ExAServer.Connection;
import hearthstone.Card;

public class serverClientThread extends Thread {
	Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private String nameOfPlayerOne = "test1";
	private String nameOfPlayerTwo = "test2";
	private int manaThisTurn = 11111;

	NormalStringMessage message;
	ArrayListMessage arrayMessage;
	ArrayList<Card> playerOnesCardsonField = new ArrayList<Card>();
	ArrayList<Card> playerTwoCardsonField = new ArrayList<Card>();
	private ArrayList<serverClientThread> threads = new ArrayList<serverClientThread>();
	private int whoUAre;
	Connection server;

	public serverClientThread(Socket socket, ArrayList<serverClientThread> threads, Connection connection,
			int whoUAre) {
		this.socket = socket;
		this.threads = threads;
		this.server = connection;
		this.whoUAre = whoUAre;
		System.out.println("new clientThread");
		start();

	}

	public void run() {

		try {
			this.oos = new ObjectOutputStream(socket.getOutputStream());
			this.ois = new ObjectInputStream(socket.getInputStream());

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (true) {

			try {
				Object incomingObject = ois.readObject();
				
				
				// System.out.println("new object to clientThread");

				if (incomingObject instanceof NormalStringMessage) {
					NormalStringMessage mess = (NormalStringMessage) incomingObject;
					System.out.println("clientThread gets : " + mess.getText());
					// oos.writeObject(new
					// NormalStringMessage("newTurn",nameOfPlayerTwo,
					// manaThisTurn));
					// oos.flush();

					if (mess.getText().equals("rdy")) {
						mess.setText("no");
						incomingObject = null;
						if(server.startingUpGame()) {
							startingUpGame();
						}
					}

					if (mess.getText().equals("endTurn")) {
						mess.setText("no");
						incomingObject = null;
						server.playerEndingTurn(whoUAre);;
					}
					
					if (mess.getText().equals("Name")) {
						incomingObject = null;
						if (nameOfPlayerOne.equals("")) {
							nameOfPlayerOne = mess.getName();
						} else
							nameOfPlayerTwo = mess.getName();
					}
				}

				if (incomingObject instanceof ArrayListMessage) {
					ArrayListMessage mess = (ArrayListMessage) incomingObject;
					
					 System.out.println("player "+ whoUAre +" - " +
					 mess.getYourCardsOnField().size());
					playerOnesCardsonField = mess.getYourCardsOnField();
					playerTwoCardsonField = mess.getEnemyCardsOnField();
					server.updateBoard(playerOnesCardsonField, playerTwoCardsonField, whoUAre);
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

	public void updateBoard(ArrayList<Card> firstPlayerCards, ArrayList<Card> secondPlayerCards) {
		try {
			oos.writeObject(new ArrayListMessage(firstPlayerCards, secondPlayerCards));
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getInfoNewTurn() {
		try {
			NormalStringMessage test = new NormalStringMessage("newTurn", nameOfPlayerOne, server.theManaThisTurn());
			oos.writeObject(test);
			oos.flush();
//			System.out.println("-tell player new turn-");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startingUpGame() {
		try {
			NormalStringMessage test = new NormalStringMessage("newTurn", nameOfPlayerOne, server.theManaThisTurn());
			oos.writeObject(test);
			oos.flush();
//			System.out.println("-tell player new turn-");
		} catch (IOException e) {
			System.out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
	  