package Effects;

import javax.swing.JLabel;

import hearthstone.fightControll;

public class FightAnimation implements Runnable{

	private boolean running = true;
	private JLabel minion;
	private int originalPosition;
	private int x;
	private int y;
	private int width;
	private int height;
	private String[] allParts;
	fightControll fc;
	
	private boolean firstPartDone = false;
	private boolean secondPartDone = false;
	private boolean StartsecondPartDone = false;
	private boolean thirdPartDone = false;
	private boolean startthirdPartDone = false;
	
	public FightAnimation(JLabel minion, String position,fightControll fc){
		this.minion = minion;
		this.fc = fc;
		allParts = position.split(",");
		
		x = Integer.parseInt(allParts[0]);
		y = Integer.parseInt(allParts[1]);
		originalPosition = y;
		width = Integer.parseInt(allParts[2]);
		height = Integer.parseInt(allParts[3]);
		
	}
	

	
	@Override
	public synchronized void run() {
		
		while(running){
			
			try {
			
			   if(firstPartDone==false){
				   
				y = y+1;
				minion.setBounds(x, y, width, height);			
				Thread.sleep(30);
				System.out.println("firstpart");
				}
			   
				if (y == (originalPosition + 20) && secondPartDone == false && startthirdPartDone == false) {
					StartsecondPartDone = true;
				}
				if (StartsecondPartDone) {
					firstPartDone = true;
					y = y - 1;
					minion.setBounds(x, y, width, height);
					Thread.sleep(1);
					System.out.println("secondpart");
				}
				
			    if(y==(originalPosition-40) && thirdPartDone ==false){
			    	startthirdPartDone=true;
			    	secondPartDone = true;
			    	StartsecondPartDone=false;
			    }
			    if(startthirdPartDone){
					if(thirdPartDone==false){
						y = y+1;
						minion.setBounds(x, y, width, height);	
						Thread.sleep(10);
						System.out.println("thirdpart");
						
						if(y==originalPosition){
							System.out.println("animation done");
							fc.fightingDone();
							running = false;
						}
					}
					
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
