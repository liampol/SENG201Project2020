package baseUtility;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mainClassesPackage.*;

/**
 * <h2>Setup</h2>
 * 
 * <p> The setup class is instantiated by the game environment, PaddockParadiseManager, and contains all the methods 
 * which ask the user for the input needed to setup various other objects.
 * 
 * @author Liam Pol
 * @see PaddockParadiseManager
 */
public class Setup {
	
	
	private static PaddockParadiseManager manager;
	Scanner input = new Scanner(System.in);
	Pattern letter = Pattern.compile("[a-zA-z]"); // Regex pattern to find any letter
    Pattern nums = Pattern.compile("[0-9]"); // Regex pattern to find any number
    Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]"); // Regex pattern to find any special character
    boolean invalid = false;
	
	/**
	 * Runs the methods to get the days, farmer name, farmer type, farmer age, farm name, and farm type
	 * 
	 * @param incomingManager The instance of the game environment
	 */
	public Setup(PaddockParadiseManager incomingManager) {
		
		manager = incomingManager;
		// Gets days to play
		int day = getDays();
		manager.setDays(day);
		
		// Gets details for a farmer
		String name = getName();
		int age = getAge();
		String type = getFarmerType();
		//Create Farmer
		Farmer farmer = new Farmer(name, age, type);
		farmer.viewFarmerStatus();
		manager.setFarmer(farmer);
		
		// Get details for farm
		String farmType = getFarmType();
		String farmName = getFarmName();
		// Create Farm
		Farm newFarm = new Farm(farmName, manager.getFarmer(), farmType);
		newFarm.viewFarmStatus();
		manager.setFarm(newFarm);
		
		System.out.println("Welcome to Paddock Paradise!\n");
		
		
	}
	/**
	 * <h2>getDays</h2>
	 * 
	 * <p> Asks the user to input a valid number of days to play the game for. 
	 * 
	 * @return The number of days to play for
	 */
	public int getDays() {
		
		int dayNumber;
		do {
			System.out.println("How long would you like to play for? (Please type in a number between 5 and 10)\n");
			dayNumber = returnValidInt(5, 10, "You didn't enter a number!");
		}	while(dayNumber == -1); // Iterate for as long as number is invalid
		System.out.println("Nice choice!");
		input.nextLine(); // Clear the scanner buffer of the invalid input
		return dayNumber;
	}
	
	/**
	 * <h2>getName</h2>
	 * 
	 * <p> Asks the user to input a valid name for the farmer/player. 
	 * 
	 * @return The name of the farmer/player
	 */
	public String getName() {
		
		String newName ="";
		
		// Iterates through the do-while loop until the name meets specification
		do {
			
			System.out.println("Please Enter Name: (Name has to be between 3 and 15 characters and must NOT contain special characters and numbers)\n");
			newName = input.nextLine();
			Matcher hasNums = nums.matcher(newName);
			Matcher hasSpecial = special.matcher(newName);
			
			// Checks name
			if (!(hasNums.find() || hasSpecial.find() || newName.length() < 3 || newName.length() > 15)) {
				invalid = true;
			}
			else {
				System.out.println("You thought I wouldn't notice! \nPlease enter a VALID name\n");
			}
		}while (!invalid);
		
		return newName;
	}
	
	/**
	 * <h2>getAge</h2>
	 * 
	 * <p> Asks the user to input a valid number for the age of the farmer/player. 
	 * 
	 * @return The age of the farmer/player
	 */
	private int getAge() {
		
		int newAge = 0;
		String message = "";
		do {
			System.out.println("Please enter your age: (Enter an age between 10 and 100)\n");
			newAge = returnValidInt(10, 100, "You didn't enter a number!");
			if (newAge >= 10 && newAge <=20) {
				message = "WOW you're still young!\n";
			}else if ( newAge >= 20 && newAge <= 100) {
				message = "Thank you!\n";
			}
			
		} while (newAge == -1);
		System.out.println(message);
		input.nextLine(); // clear the scanner buffer of the newline character
		return newAge;
	}
	
	private String getFarmerType() {
		
		// Gets the type of Farmer
		int newInt = 0;
		String newType;
		
		do {
			System.out.print("Choose Type by typing corresponding number only!:\n"
					+ "[1] Male Farmer\n"
					+ "[2] Female Farmer\n"
					+ "[3] Alien Farmer\n\n");
			newInt = returnValidInt(1, 3, "You didn't enter a number!");
			} while (newInt == -1);
		switch (newInt) {
		case 1:
			newType = "Male Farmer";
			break;
		case 2:
			newType = "Female Farmer";
			break;
		case 3:
			newType = "Alien Farmer";
			break;
		default:
			newType = "Alien Farmer";
			break;
		} 
		return newType;
		
	}
	
	/**
	 * <h2>getName</h2>
	 * 
	 * <p> Asks the user to input a valid name for the farm. 
	 * 
	 * @return The name of the farm
	 */
	public String getFarmName() {
		
		String newName ="";
		invalid = false;
		// Iterates through the do-while loop until the name meets specification
		do {
			
			System.out.println("Please Enter a Farm Name:(Name has to be between 3 and 15 characters and must NOT contain special characters and numbers)\n");
			newName = input.nextLine();
			Matcher hasNums = nums.matcher(newName);
			Matcher hasSpecial = special.matcher(newName);
			
			// Checks name
			if (!(hasNums.find() || hasSpecial.find() || newName.length() < 3 || newName.length() > 15)) {
				invalid = true;
			}
			else {
				System.out.println("You thought I wouldn't notice! \nPlease enter a VALID name\n");
			}
		}while (!invalid);
		
		return newName;
	}
	
	/**
	 * <h2>getFarmType</h2>
	 * 
	 * <p> Asks the user to input a valid number, corresponding to the farm type they want.
	 * 
	 * @return The type of farm (farm bonus)
	 */
	public String getFarmType() {
		
		
		int newInt = 0;
		String newType ;
		
		do {
			System.out.print("Choose Type by typing corresponding number only!:\n\n"
					+ "[1] Money Tree:\n"
					+ "Gives 20% Extra money bonus at the start of each day,\n"
					+ "[2] Faster Crop Growth:\n"
					+ "Decreases the days till harvest by 1,\n"
					+ "[3] Happy Animal:\n"
					+ "Animals are happier for 2 extra days when purchased,\n"
					+ "[4] Discount Store:\n"
					+ "40% Discount added to carton checkout!\n\n");
			newInt = returnValidInt(1, 4, "You didn't enter a valid number!");
			switch (newInt) {
			case 1:
				newType = "Money Tree";
				break;
			case 2:
				newType = "Faster Crop Growth";
				break;
			case 3:
				newType = "Happy Animal";
				break;
			case 4:
				newType = "Discount Store";
				break;
			default:
				newType = "Money Tree";
			}
		} while(newInt == -1);
		input.nextLine(); // clear the scanner buffer of the newline character
		return newType;
	}
	
	/**
	 * <h2>returnValidInt</h2>
	 * 
	 * <p> Helper method to ask the user for an integer number between lowerInclusiveBound and upperInclusiveBound. errorMessage
	 * is displayed if the input was not an integer. 
	 * 
	 * @param lowerInclusiveBound the inclusive lower bound for the range of integers
	 * @param upperInclusiveBound the inclusive upper bound for the range of integers
	 * @param errorMessage the error message to display if the user did not enter an integer
	 * @return The name of the farmer/player
	 */
	private int returnValidInt(int lowerInclusiveBound, int upperInclusiveBound, String errorMessage) {
	
			if (input.hasNextInt()) { // true if the scanner sees an integer ahead
				int number = input.nextInt(); 
				if (number >= lowerInclusiveBound && number <= upperInclusiveBound) {
					return number;
				} else {
					System.out.println("That number wasn't valid!");
					return -1;
				}
				
			} else {
				System.out.println(errorMessage);
				input.next(); // clear the scanner buffer
				return -1;
			}
		}
	
}
