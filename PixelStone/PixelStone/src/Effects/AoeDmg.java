package Effects;

import javax.swing.JLabel;

import hearthstone.fightControll;

public class AoeDmg implements Runnable{
	
	
	private JLabel[] enemyMinions;
	private boolean running = true;
	
	private int[] x = new int[5];
	private int[] y = new int[5];
	private int[] widht = new int[5];
	private int[] height = new int[5];
	private String[] allParts;
	fightControll fc;
	
	public AoeDmg(JLabel[] enemyMinions, String[] positions,fightControll fc){
		this.fc = fc;
		this.enemyMinions = enemyMinions;

		
		
		for(int i = 0; i<5; i++){
			
			System.out.println("positions - "+ positions[i]);
			allParts = positions[i].split(",");		
				
			x[i] = Integer.parseInt(allParts[0]);
			y[i] = Integer.parseInt(allParts[1]);
			widht[i] = Integer.parseInt(allParts[2]);
			height[i] = Integer.parseInt(allParts[3]);
		}
	}





	@Override
	public void run() {
		int howManyTimes = 0;
		while(running){
			try {
			
		 for(int a = 0; a<15; a++){
			for(int i = 0; i<5; i++){
				x[i] = x[i]-3;
			}
			
			for(int i = 0; i<5; i++){
			enemyMinions[i].setBounds(x[i], y[i], widht[i], height[i]);			
			}
			
				Thread.sleep(10);
		 }
		 
		 for(int a = 0; a<30; a++){
			for(int i = 0; i<5; i++){
				x[i] = x[i]+3;
			}
			
			for(int i = 0; i<5; i++){
			enemyMinions[i].setBounds(x[i], y[i], widht[i], height[i]);			
			}
			
				Thread.sleep(10);
		 }
		 
		 for(int a = 0; a<15; a++){
				for(int i = 0; i<5; i++){
					x[i] = x[i]-3;
				}
				
				for(int i = 0; i<5; i++){
				enemyMinions[i].setBounds(x[i], y[i], widht[i], height[i]);			
				}
				
					Thread.sleep(10);
			 }
		 
		 howManyTimes++;
		 if(howManyTimes==1){
			 fc.fightingDone();
			 running=false;
		 }
		 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
