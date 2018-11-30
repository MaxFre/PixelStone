package Effects;

import javax.swing.JLabel;

import hearthstone.Gui;
import hearthstone.fightControll;

public class EffectController {
	
	Effects.FightAnimation fightAnimator;
	Gui gui;
	Thread forFighting;
	Thread forAoeDmg;
	String position;
	fightControll fc;
	AoeDmg aoedmg;
	
	public EffectController(){
		
	}
	
	
	public void aoeDmgAnimation() {

		JLabel[] enemyMinions = new JLabel[5];
		String[] positions = new String[5];

		for (int i = 0; i < 5; i++) {
			enemyMinions[i] = gui.getEnemyBattleImage(i);
		}

		for (int i = 0; i < 5; i++) {
			positions[i] = gui.getAoeEnemyPosition(i);
		}
		
		aoedmg = new AoeDmg(enemyMinions,positions,fc);
		forAoeDmg = new Thread(aoedmg);
		forAoeDmg.start();

	}
	
	
	public void fightAnimation(int whatMinion){
//		 aoeDmgAnimation();
		 JLabel minionToAttack = gui.getbattleImage(whatMinion);
		 position = gui.getPosition(whatMinion);
		 fightAnimator = new FightAnimation(minionToAttack,position,fc);
		 forFighting = new Thread(fightAnimator);
		 forFighting.start();

	}
	
	
	
	
	
	
	
	
	
	
	
	public void getGuiAccess(Gui gui){
		this.gui = gui;
	}
	
	public void imHere(fightControll fc){
		this.fc = fc;
	}
}
