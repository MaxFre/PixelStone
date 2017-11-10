package hearthstone;

public class fightControll {
	Controller controller;
	Gui gui;
	private int clickOn1 = 0;
	private int clickOn2 = 0;
	private int clickOn3 = 0;
	private int clickOn4 = 0;
	private int clickOn5 = 0;
	
	public fightControll(Controller controller) {
		this.controller = controller;						
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

	public void clickOnEnemyBattleOne(){
			if(clickOn5>0){
//				System.out.println(" 5 atk number 1");
				controller.putMinionToSleep(5);
				controller.damage(5, 1);
			}
			if(clickOn4>0){
//				System.out.println(" 4 atk number 1");
				controller.putMinionToSleep(4);
				controller.damage(4, 1);
			}
			if(clickOn3>0){
//				System.out.println(" 3 atk number 1");
				controller.putMinionToSleep(3);
				controller.damage(3, 1);
			}
			if(clickOn2>0){
//				System.out.println(" 2 atk number 1");
				controller.putMinionToSleep(2);
				controller.damage(2, 1);
			}
			if(clickOn1>0){
//				System.out.println(" 1 atk number 1");
				controller.putMinionToSleep(1);
				controller.damage(1, 1);
			}		
			clickOn5=0;
			clickOn4=0;
			clickOn3=0;
			clickOn2=0;
			clickOn1=0;
		}
	
		public void clickOnEnemyBattleTwo(){
			
				if(clickOn5>0){
//					System.out.println(" 5 atk number 2");
					controller.putMinionToSleep(5);
					controller.damage(5, 2);
				}
				if(clickOn4>0){
//					System.out.println(" 4 atk number 2");
					controller.putMinionToSleep(4);
					controller.damage(4, 2);
				}
				if(clickOn3>0){
//					System.out.println(" 3 atk number 2");
					controller.putMinionToSleep(3);
					controller.damage(3, 2);
				}
				if(clickOn2>0){
//					System.out.println(" 2 atk number 2");
					controller.putMinionToSleep(2);
					controller.damage(2, 2);
				}
				if(clickOn1>0){
//					System.out.println(" 1 atk number 2");
					controller.putMinionToSleep(1);
					controller.damage(1, 2);
				}
				clickOn5=0;
				clickOn4=0;
				clickOn3=0;
				clickOn2=0;
				clickOn1=0;
			}
			
			public void clickOnEnemyBattleThree(){
				
					if(clickOn5>0){
//						System.out.println(" 5 atk number 3");
						controller.putMinionToSleep(5);
						controller.damage(5, 3);
					}
					if(clickOn4>0){
//						System.out.println(" 4 atk number 3");
						controller.putMinionToSleep(4);
						controller.damage(4, 3);
					}
					if(clickOn3>0){
//						System.out.println(" 3 atk number 3");
						controller.putMinionToSleep(3);
						controller.damage(3, 3);
					}
					if(clickOn2>0){
//						System.out.println(" 2 atk number 3");
						controller.putMinionToSleep(2);
						controller.damage(2, 3);
					}
					if(clickOn1>0){
//						System.out.println(" 1 atk number 3");
						controller.putMinionToSleep(1);
						controller.damage(1, 3);
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
							controller.putMinionToSleep(5);
							controller.damage(5, 4);
						}
						if(clickOn4>0){
//							System.out.println(" 4 atk number 4");
							controller.putMinionToSleep(4);
							controller.damage(4, 4);
						}
						if(clickOn3>0){
//							System.out.println(" 3 atk number 4");
							controller.putMinionToSleep(3);
							controller.damage(3, 4);
						}
						if(clickOn2>0){
//							System.out.println(" 2 atk number 4");
							controller.putMinionToSleep(2);
							controller.damage(2, 4);
						}
						if(clickOn1>0){
//							System.out.println(" 1 atk number 4");
							controller.putMinionToSleep(1);
							controller.damage(1, 4);
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
				controller.putMinionToSleep(5);
			}
			if(clickOn4>0){
//				System.out.println(" 4 atk number 5");
				controller.putMinionToSleep(4);
			}
			if(clickOn3>0){
//				System.out.println(" 3 atk number 5");
				controller.putMinionToSleep(3);
			}
			if(clickOn2>0){
//				System.out.println(" 2 atk number 5");
				controller.putMinionToSleep(2);
			}
			if(clickOn1>0){
//				System.out.println(" 1 atk number 5");
			}	
			clickOn5=0;
			clickOn4=0;
			clickOn3=0;
			clickOn2=0;
			clickOn1=0;
	}
	
	
	
	

}
