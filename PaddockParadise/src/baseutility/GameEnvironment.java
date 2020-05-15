/**
 * 
 */
package baseutility;

import java.util.Arrays;
import java.util.Scanner;
import MainClassesPackage.Farm;
import MainClassesPackage.Farmer;
import MainClassesPackage.PaddockParadiseManager;


/**
 * @author liam
 *
 */
public class GameEnvironment {
	
	private Farmer farmer;
	private Farm farm;
	private int activitiesPerformed;
	private PaddockParadiseManager manager;
	private final int[] OPTIONS = {1, 2, 3};
	private final String OPTION_STRING = "What would you like to do?\n"
			+	"[1] View " + farm.getName()
			+	"[2] Perform an action"
			+	"[3] Visit the General Store";
	
	/*
	 * This is the game environment. Here the user can 
	 * - view items
	 * - view the farm
	 * - view the general store
	 * 
	 * 
	 */
	
	public GameEnvironment(PaddockParadiseManager manager) {
		this.manager = manager;
		farmer = manager.getFarmer();
		farm = manager.getFarm();
		
	}
	
	public void playGame() {
		System.out.println(OPTION_STRING);
		Scanner scanner = new Scanner(System.in);
		int choice = getInput(scanner);
		while (!isValidInput(OPTIONS, choice)) {
			choice = getInput(scanner);
		}
		scanner.close();
		switch (choice) {
		case 1:
			viewFarmStatus();
			break;
		case 2:
			performActivity();
			break;
		case 3:
			visitGeneralStore();
			break;
		}	

	}
	
	public int getInput(Scanner scanner) {
		if (scanner.hasNextInt()) {
			int return_val = scanner.nextInt();
			scanner.nextLine();
			return return_val;
		}
		System.out.println("You didn't pick a valid option!");
		return -1;
	}
	
	public boolean isValidInput(int[] acceptedInputs, int input) {
			if (Arrays.asList(acceptedInputs).contains(input)) {
				return true;
			}
		return false;
	}
	
	public void viewFarmStatus() {
		farm.viewFarmStatus();
	}
	
	public void visitGeneralStore() {
		
	}
	
	public void performActivity() {
		
	}
	
}
