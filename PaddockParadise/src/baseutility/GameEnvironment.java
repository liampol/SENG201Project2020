/**
 * 
 */
package baseutility;
import MainClassesPackage.*;
import java.util.Arrays;
import java.util.ArrayList;
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
	private int activitiesLeft;
	private ArrayList<Integer> options = new ArrayList<Integer>(3);
	private String optionString;
	private Scanner scanner = new Scanner(System.in);
	private PaddockParadiseManager manager;
	
	/*
	 * This is the game environment. Here the user can 
	 * - view items
	 * - view the farm
	 * - view the general store
	 * 
	 * 
	 */
	
	public GameEnvironment(PaddockParadiseManager incoming) {
		
		manager = incoming;
		this.farmer = incoming.getFarmer();
		this.farm = incoming.getFarm();
		activitiesLeft = 2;
		for (int i = 1; i < 4; i++) {
			options.add(i);
		}
		optionString = "What would you like to do?\n"
					+	"[1] View " + farm.getName() + "\n"
					+	"[2] Perform an action\n"
					+	"[3] Visit the General Store";
		playGame(scanner);
		scanner.close();

	}
	
	public void playGame(Scanner scanner) {
		System.out.println(optionString);
		int choice = getInput(scanner);
		while (!isValidInput(options, choice)) {
			System.out.println(optionString);
			choice = getInput(scanner);
		}
		// Gets stuck in while loop? Test methods
		switch (choice) {
		case 1:
			viewFarmStatus();
			break;
		case 2:
			performActivity();
			break;
		case 3:
			visitMarket();
			break;
		}	

	}
	
	public int getInput(Scanner scanner) {
		if (scanner.hasNextInt()) {
			int return_val = scanner.nextInt();
			return return_val;
			}
		scanner.next();
		return -1;
		
	}
	
	public boolean isValidInput(ArrayList<Integer> acceptedInputs, int input) {
			if (acceptedInputs.contains(input)) {
				return true;
			} else {
				System.out.println("You didn't pick a valid option!\n");
			}
		return false;
	}
	
	public void viewFarmStatus() {
		System.out.println(farm.viewFarmStatus());
		playGame(scanner);
	}
	
	public void visitMarket() {
		Market openMarket = new Market(manager);
		playGame(scanner);
		
	}
	
	public void leaveMarket(PaddockParadiseManager manager) {
		GameEnvironment next = new GameEnvironment(manager);
	}
	
	public void performActivity() {
		/**
		 *  Do stuff
		 * 
		 */
		playGame(scanner);
	}
	
}
