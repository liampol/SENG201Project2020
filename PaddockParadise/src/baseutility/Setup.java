package baseutility;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import MainClassesPackage.*;

/**
 * @author liam
 *
 */
public class Setup {
	
	private static PaddockParadiseManager manager;
	Scanner input = new Scanner(System.in);
	Pattern letter = Pattern.compile("[a-zA-z]");
    Pattern nums = Pattern.compile("[0-9]");
    Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
    boolean invalid = false;
	
	
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
	
	public int getDays() {
		
		int dayNumber;
		do {
			System.out.println("How long would you like to play for? (Please type in a number between 5 and 10)\n");
			dayNumber = returnValidInt(5, 10, "You didn't enter a number!");
		}	while(dayNumber == -1);
		System.out.println("Nice choice!");
		input.nextLine();
		return dayNumber;
	}
	
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
		input.nextLine();
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
		case 2:
			newType = "Female Farmer";
		case 3:
			newType = "Alien Farmer";
		default:
			newType = "Alien Farmer";
		} 
		return newType;
		
	}
	
	
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
	
	
	public String getFarmType() {
		
		
		int newInt = 0;
		String newType ;
		
		do {
			System.out.print("Choose Type by typing corresponding number only!:\n\n"
					+ "[1] Money Tree:\n"
					+ "Gives 20% Extra money bonus at the start of each day,\n"
					+ "[2] Faster Crop Growth:\n"
					+ "Decreases the days till harvest by 1,\n"                 // implemented
					+ "[3] Happy Animal:\n"
					+ "Animals are happier for 2 extra days when purchased,\n"   // implemented
					+ "[4] Discount Store:\n"
					+ "40% Discount added to carton checkout!\n\n"); // implemented
			newInt = returnValidInt(1, 4, "You didn't enter a valid number!");
			switch (newInt) {
			case 1:
				newType = "Money Tree";
			case 2:
				newType = "Faster Crop Growth";
			case 3:
				newType = "Happy Animal";
			case 4:
				newType = "Discount Store";
			default:
				newType = "Money Tree";
			}
		} while(newInt == -1);
		input.nextLine();
		return newType;
	}
	
	private int returnValidInt(int lowerInclusiveBound, int upperInclusiveBound, String errorMessage) {
	
			if (input.hasNextInt()) {
				int number = input.nextInt();
				if (number >= lowerInclusiveBound && number <= upperInclusiveBound) {
					return number;
				} else {
					System.out.println("That number wasn't valid!");
					return -1;
				}
				
			} else {
				System.out.println(errorMessage);
				input.next();
				return -1;
			}
		}
	
	
	private static void main(String[] args) {
		
		PaddockParadiseManager manager = new PaddockParadiseManager();
		
	//	Setup setup = new Setup();
	//	setup.createFarmer(manager);
	}
	
	
	
	
	
	
}
