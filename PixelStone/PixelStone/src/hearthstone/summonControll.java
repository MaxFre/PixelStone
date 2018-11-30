package hearthstone;

import java.util.ArrayList;


  /**
   * class keeping check on what minions on field and stuff.
   */
  public class summonControll {
	Controller controller;
	ArrayList<Card> yourCardsOnField = new ArrayList<Card>();
	ArrayList<Card> yourCardsOnHand = new ArrayList<Card>();
	ArrayList<Card> EnemyCardsOnField = new ArrayList<Card>();

	
	
	public summonControll(Controller controller){
		this.controller = controller;
		
	}
	

	public void summmonThis(Card card){
		yourCardsOnField.add(card);
		
//		controller.summonedMinions(yourCardsOnField);
	}
	
	
	public void yourKilledSummon(int whatMinion, Card card){
		yourCardsOnField.remove(whatMinion);
//		controller.summonedMinions(yourCardsOnField);
	}
	
	
	
	
	public void EnemysummmonThis(Card card){
		EnemyCardsOnField.add(card);
		controller.enemySummonedMinions(EnemyCardsOnField);
	}
	
	
	public void EnemysKilledSummon(int whatMinion, Card card){
		EnemyCardsOnField.remove(whatMinion);
		controller.enemySummonedMinions(EnemyCardsOnField);
	}
	
	
	
	
	
}
