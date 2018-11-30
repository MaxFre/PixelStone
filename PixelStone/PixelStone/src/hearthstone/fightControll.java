package hearthstone;

import Effects.EffectController;

public class fightControll {
	EffectController effectController;
	Controller controller;
	Gui gui;
	private int clickOn1 = 0;
	private int clickOn2 = 0;
	private int clickOn3 = 0;
	private int clickOn4 = 0;
	private int clickOn5 = 0;
	
	private int putThisMinionToSleep = 0;
	private int thisMinionAttacked = 0;
	private int thisMinionWasAttacked = 0;
	
	public fightControll(Controller controller,EffectController effectController) {
		this.controller = controller;		
		this.effectController = effectController;
		effectController.imHere(this);
	}
	
	public void fightControll(Gui gui) {
		this.gui = gui;						
	}
	
	
	public void clickOnBattleOne(){
		clickOn1++;
		gui.disableFightImages(1);
		if(clickOn1==2){
			clickOn1=0;
			gui.makeAktionButtonWork();
			gui.resetFightImage(1);			
			
		}
	}

	
	public void clickOnBattleTwo(){
		clickOn2++;
		gui.disableFightImages(2);
		if(clickOn2==2){
			clickOn2=0;
			gui.resetFightImage(2);
			gui.makeAktionButtonWork();
//			System.out.println("here in fight?");
		}
	}
	
	public void clickOnBattleThree(){
		clickOn3++;
		gui.disableFightImages(3);
		if(clickOn3==2){
			clickOn3=0;
			gui.resetFightImage(3);
			gui.makeAktionButtonWork();
		}
	}
	
	public void clickOnBattleFour(){
		clickOn4++;
		gui.disableFightImages(4);
		if(clickOn4==2){
			clickOn4=0;
			gui.resetFightImage(4);
			gui.makeAktionButtonWork();
		}
	}
	
	public void clickOnBattleFive(){
		clickOn5++;
		gui.disableFightImages(5);
		if(clickOn5==2){
			clickOn5=0;
			gui.resetFightImage(5);
			gui.makeAktionButtonWork();
		}
	}

	public synchronized void clickOnEnemyBattleOne(){
			if(clickOn5>0){
//				System.out.println(" 5 atk number 1");
				putThisMinionToSleep = 5;
				thisMinionAttacked = 5;
				thisMinionWasAttacked = 1;				
//				controller.putMinionToSleep(5);
//				controller.damage(5, 1);
				effectController.fightAnimation(5);
			}
			if(clickOn4>0){
//				System.out.println(" 4 atk number 1");
				putThisMinionToSleep = 4;
				thisMinionAttacked = 4;
				thisMinionWasAttacked = 1;	
//				controller.putMinionToSleep(4);
//				controller.damage(4, 1);
				effectController.fightAnimation(4);
			}
			if(clickOn3>0){
//				System.out.println(" 3 atk number 1");
				putThisMinionToSleep = 3;
				thisMinionAttacked = 3;
				thisMinionWasAttacked = 1;
				
				effectController.fightAnimation(3);
//				
//				controller.putMinionToSleep(3);
//				controller.damage(3, 1);
				
			}
			if(clickOn2>0){
//				System.out.println(" 2 atk number 1");
				putThisMinionToSleep = 2;
				thisMinionAttacked = 2;
				thisMinionWasAttacked = 1;
				
				effectController.fightAnimation(2);
				
//				controller.putMinionToSleep(2);
//				controller.damage(2, 1);
				
			}
			if(clickOn1>0){
				System.out.println(" 1 atk number 1 - sending info to effects");
				putThisMinionToSleep = 1;
				thisMinionAttacked = 1;
				thisMinionWasAttacked = 1;
				
				effectController.fightAnimation(1);
				
//				controller.putMinionToSleep(1);
//				controller.damage(1, 1);
				
			}		
			clickOn5=0;
			clickOn4=0;
			clickOn3=0;
			clickOn2=0;
			clickOn1=0;
		}
	
		public void clickOnEnemyBattleTwo(){
			
				if(clickOn5>0){
					putThisMinionToSleep = 5;
					thisMinionAttacked = 5;
					thisMinionWasAttacked = 2;
//					System.out.println(" 5 atk number 2");
//					controller.putMinionToSleep(5);
//					controller.damage(5, 2);
					effectController.fightAnimation(5);
				}
				if(clickOn4>0){
//					System.out.println(" 4 atk number 2");
					putThisMinionToSleep = 4;
					thisMinionAttacked = 4;
					thisMinionWasAttacked = 2;
//					controller.putMinionToSleep(4);
//					controller.damage(4, 2);
					effectController.fightAnimation(4);
				}
				if(clickOn3>0){
//					System.out.println(" 3 atk number 2");
					putThisMinionToSleep = 3;
					thisMinionWasAttacked = 2;
					thisMinionAttacked = 3;

//					controller.putMinionToSleep(3);
//					controller.damage(3, 2);
					effectController.fightAnimation(3);
				}
				if(clickOn2>0){
//					System.out.println(" 2 atk number 2");
					putThisMinionToSleep = 2;
					thisMinionWasAttacked = 2;
					thisMinionAttacked = 2;
//					controller.putMinionToSleep(2);
//					controller.damage(2, 2);
					effectController.fightAnimation(2);
				}
				if(clickOn1>0){
//					System.out.println(" 1 atk number 2");
					putThisMinionToSleep = 1;
					thisMinionWasAttacked = 2;
					thisMinionAttacked = 1;
//							
//					controller.putMinionToSleep(1);
//					controller.damage(1, 2);
					effectController.fightAnimation(1);
				}
				clickOn5=0;
				clickOn4=0;
				clickOn3=0;
				clickOn2=0;
				clickOn1=0;
			}
			
			public void clickOnEnemyBattleThree(){
				
					if(clickOn5>0){
						putThisMinionToSleep = 5;
						thisMinionWasAttacked = 3;
						thisMinionAttacked = 5;
//						System.out.println(" 5 atk number 3");
//						controller.putMinionToSleep(5);
//						controller.damage(5, 3);
						effectController.fightAnimation(5);
					}
					if(clickOn4>0){
//						System.out.println(" 4 atk number 3");
						putThisMinionToSleep = 4;
						thisMinionWasAttacked = 3;
						thisMinionAttacked = 4;
//						controller.putMinionToSleep(4);
//						controller.damage(4, 3);
						effectController.fightAnimation(4);
					}
					if(clickOn3>0){
//						System.out.println(" 3 atk number 3");
						putThisMinionToSleep = 3;
						thisMinionWasAttacked = 3;
						thisMinionAttacked = 3;
						
//						controller.putMinionToSleep(3);
//						controller.damage(3, 3);
						effectController.fightAnimation(3);
					}
					if(clickOn2>0){
//						System.out.println(" 2 atk number 3");
						putThisMinionToSleep = 2;
						thisMinionWasAttacked = 3;
						thisMinionAttacked = 2;
//						controller.putMinionToSleep(2);
//						controller.damage(2, 3);
						effectController.fightAnimation(2);
					}
					if(clickOn1>0){
//						System.out.println(" 1 atk number 3");
						putThisMinionToSleep = 2;
						thisMinionWasAttacked = 3;
						thisMinionAttacked = 2;
//						controller.putMinionToSleep(1);
//						controller.damage(1, 3);
						effectController.fightAnimation(1);
					}
					clickOn5=0;
					clickOn4=0;
					clickOn3=0;
					clickOn2=0;
					clickOn1=0;
				}
				
				public void clickOnEnemyBattleFour(){
					
						if(clickOn5>0){
//							System.out.println(" 5 atk number 4");
							putThisMinionToSleep = 5;
							thisMinionWasAttacked = 4;
							thisMinionAttacked = 5;
//							controller.putMinionToSleep(5);
//							controller.damage(5, 4);
							effectController.fightAnimation(5);
						}
						if(clickOn4>0){
//							System.out.println(" 4 atk number 4");
							putThisMinionToSleep = 4;
							thisMinionWasAttacked = 4;
							thisMinionAttacked = 4;
//							controller.putMinionToSleep(4);
//							controller.damage(4, 4);
							effectController.fightAnimation(4);
						}
						if(clickOn3>0){
//							System.out.println(" 3 atk number 4");
							putThisMinionToSleep = 3;
							thisMinionWasAttacked = 4;
							thisMinionAttacked = 3;
//							controller.putMinionToSleep(3);
//							controller.damage(3, 4);
							effectController.fightAnimation(3);
						}
						if(clickOn2>0){
//							System.out.println(" 2 atk number 4");
							putThisMinionToSleep = 2;
							thisMinionWasAttacked = 4;
							thisMinionAttacked = 2;
//							controller.putMinionToSleep(2);
//							controller.damage(2, 4);
							effectController.fightAnimation(2);
						}
						if(clickOn1>0){
//							System.out.println(" 1 atk number 4");
							putThisMinionToSleep = 1;
							thisMinionWasAttacked = 4;
							thisMinionAttacked = 1;
//							controller.putMinionToSleep(1);
//							controller.damage(1, 4);
							effectController.fightAnimation(1);
						}
						clickOn5=0;
						clickOn4=0;
						clickOn3=0;
						clickOn2=0;
						clickOn1=0;
					}
					
	
	public void clickOnEnemyBattleFive(){
		
			if(clickOn5>0){
//				System.out.println(" 5 atk number 5");
				putThisMinionToSleep = 5;
				thisMinionWasAttacked = 5;
				thisMinionAttacked = 5;
//				controller.putMinionToSleep(5);
//				controller.damage(5, 5);
				effectController.fightAnimation(5);
			}
			if(clickOn4>0){
//				System.out.println(" 4 atk number 5");
				putThisMinionToSleep = 4;
				thisMinionWasAttacked = 5;
				thisMinionAttacked = 4;
//				controller.putMinionToSleep(4);
//				controller.damage(4, 5);
				effectController.fightAnimation(4);
			}
			if(clickOn3>0){
//				System.out.println(" 3 atk number 5");
				putThisMinionToSleep = 3;
				thisMinionWasAttacked = 5;
				thisMinionAttacked = 3;
//				controller.putMinionToSleep(3);
//				controller.damage(3, 5);
				effectController.fightAnimation(3);
			}
			if(clickOn2>0){
//				System.out.println(" 2 atk number 5");
				putThisMinionToSleep = 2;
				thisMinionWasAttacked = 5;
				thisMinionAttacked = 2;
//				controller.putMinionToSleep(2);
//				controller.damage(2, 5);
				effectController.fightAnimation(2);
			}
			if(clickOn1>0){
//				System.out.println(" 1 atk number 5");
				putThisMinionToSleep = 1;
				thisMinionWasAttacked = 5;
				thisMinionAttacked = 1;
//				controller.putMinionToSleep(1);
//				controller.damage(1, 5);
				effectController.fightAnimation(1);
			}	
			clickOn5=0;
			clickOn4=0;
			clickOn3=0;
			clickOn2=0;
			clickOn1=0;
	}
	
	

	public void fightingDone(){
		controller.putMinionToSleep(putThisMinionToSleep);
		controller.damage(thisMinionAttacked, thisMinionWasAttacked);
	}
	
	

}
