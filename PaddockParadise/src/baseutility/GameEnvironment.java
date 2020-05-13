/**
 * 
 */
package baseutility;

import MainClassesPackage.Farm;
import MainClassesPackage.Farmer;
import MainClassesPackage.PaddockParadiseManager;

/**
 * @author liam
 *
 */
public class GameEnvironment {

	Farmer farmer;
	Farm farm;
	int activitiesPerformed;
	
	/*
	 * This is the game environment. Here the user can 
	 * - view items
	 * - view the farm
	 * - view the general store
	 * 
	 * 
	 */
	
	public GameEnvironment(PaddockParadiseManager manager) {
		farmer = manager.getFarmer();
		farm = manager.getFarm();
		
	}
	
	public void playGame() {
		System.out.println("What would you like to do?\n");
		
	}
	
	public void viewFarmStatus() {
		farm.viewFarmStatus();
	}
	
	public void visitGeneralStore() {
		
	}
	
	public void performActivity() {
		
	}
	
}
