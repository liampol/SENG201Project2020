package MainClassesPackage;
import java.util.Scanner;
import baseutility.GameEnvironment;
import GUIPackage.*;
import GUIPackage.ChooseFarmer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaddockParadiseManager {
	
	private static Farmer newFarmer;
	private static Farm newFarm;
	private static int currentDay;
	
	/**
	 * Launches the WelcomeScreen that welcomes the user to the game
	 *      and gets the amount of days the user would like to play for
	 * 
	 */
	public static void launchWelcomeWindow(PaddockParadiseManager manager) {
		//WelcomeScreen welcomeWindow = new WelcomeScreen(this);
		System.out.println("Welcome to Paddock Paradise");
		Scanner daysToPlay = new Scanner(System.in);
		int days = 0;
		do {
			System.out.println("How long would you like to play for? (Please type in a number between 5 and 10)");
			days = daysToPlay.nextInt();
			if (days < 5 || days > 10) {
				System.out.println("sorry that input was invalid, please try again!");
			}else {
				System.out.println("Thank You!");
			}
		}while(days < 5 || days > 10);
		
		currentDay = days; 
		getFarmerDetails(manager);
		daysToPlay.close();
		
	}
	
	/**
	 * This Method is used to get players Farmer details through input then calls the createFarmer()
	 * while passing players details as  parameters
	 * At the end, the getFarmDetails() is called
	 */
	public static void getFarmerDetails(PaddockParadiseManager manager) {
		
		// Used to check input details
		boolean correct = false;
		Pattern letter = Pattern.compile("[a-zA-z]");
	    Pattern nums = Pattern.compile("[0-9]");
	    Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
	    
	    // Gets the name of the Farmer, (MUST BE BETWEEN 3 AND 5 CHARACTERS ND NOT HAVE SPECIAL CHARACTERS OR NUMBERS)
		String newName = "";
		Scanner input = new Scanner(System.in);
		
		// Iterates through the do-while loop until the name meets specification
		do {
			
			System.out.println("Please Enter Name: (Name has to be between 3 and 15 characters and must NOT contain special characters and numbers)\n");
			newName = input.nextLine();
			Matcher hasNums = nums.matcher(newName);
			Matcher hasSpecial = special.matcher(newName);
			
			// Checks name
			if (!(hasNums.find() || hasSpecial.find() || newName.length() < 3 || newName.length() > 15)) {
				correct = true;
			}
			else {
				System.out.println("You thought I wouldn't notice! Please enter a VALID option");
			}
		}while (!correct);
		
		// Gets the age of the farmer age must be between 10 and 100
		int newIntAge = 0;
		correct = false;
		String newStringAge = "";
		
		do {
			System.out.println("Enter Age:(Please type an age between 10 and 100) \n");
			newIntAge = input.nextInt();
			newStringAge = Integer.toString(newIntAge);
			Matcher hasSpecial = special.matcher(newStringAge);
			Matcher hasLetter = letter.matcher(newStringAge);
			if (!(hasLetter.find() || hasSpecial.find() || newIntAge < 10 || newIntAge > 100)) {
				correct = true;
			}else{
				System.out.println("Invalid Input please try again!");
			}
			
			}while(!correct);
		
		// Gets the type of Farmer
		correct = false;
		int newInt = 0;
		String newType = "";
		do {
			System.out.print("Choose Type by typing corresponding number only!:\n"
					+ " [1] Male Farmer\n "
					+ "[2] Female Farmer\n "
					+ "[3] Alien Farmer\n");
			newInt = input.nextInt();
			if (newInt == 1) {
				newType = "Male Farmer";
				correct = true;
			}else if (newInt == 2) {
				newType = "Female Farmer";
				correct = true;
			}else if (newInt == 3) {
				newType = "Alien Farmer";
				correct = true;
			}else {
				System.out.println("That is an invalid option, please choose again");
				}
			}while (!(correct));
			
		System.out.println("These are your Farmer's Details:\n"
				        + "Name: " + newName + "\n"
						+ "Age: " + newIntAge + "\n"
						+ "Type: " + newType + "\n");
		
		createFarmer(newName, newIntAge, newType);
		getFarmDetails(manager);
		input.close();
		
	}
	
	/**
	 * Overloaded Constructor for creating a farmer with user inputs
	 * @param newName
	 * @param newAge
	 * @param newType
	 */
	public static void createFarmer(String newName,int newAge,String newType) {
		newFarmer = new Farmer(newName, newAge, newType);
	}
	
	public static void createFarmer() {
		newFarmer = new Farmer();
	}
	
	public static void getFarmDetails(PaddockParadiseManager manager) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Farm Name:\n");
		String newName = input.nextLine();
		
		
		int newInt = 0;
		String newType = "";
		boolean correct = false;
		
		do {
			System.out.print("Choose Type by typing corresponding number only!:\n"
					+ "[1] Money Tree:\n"
					+ "Gives 20% Extra money bonus at the start ofeach day\n"
					+ "[2] Faster Crop Growth\n"
					+ "Decreases the days till harvest by 1\n"
					+ "[3] Happy Animal\n"
					+ "Animals are happier longer\n"
					+ "[4] Discount Store\n"
					+ "40% Discount added to carton checkout!");
			newInt = input.nextInt();
			if (newInt == 1) {
				newType = "Money Tree";
				correct = true;
			}else if (newInt == 2) {
				newType = "Faster Crop Growth";
				correct = true;
			}else if (newInt == 3) {
				newType = "Happy Animal";
				correct = true;
			}else if (newInt == 4) {
				newType = "Discunt Store";
				correct = true;
			}else {
				System.out.println("Sorry that was an invalid option, please choose again!");
			}
		}while(!(correct));
		
		System.out.println("These are your new Farm Details:\n"
				        + "Farm Name: "+ newName + "\n"
						+ "Farm Type: " + newType + "\n");
		createFarm(newName, newType);
		System.out.println("Lets Play!");
		startGame(manager);
		input.close();
		
	}
	
	
	/**
	 * Overloaded constructor for creating the farm
	 * @param farmName
	 * @param farmType
	 */
	public static void createFarm(String farmName, String farmType) {
		newFarm = new Farm(farmName, newFarmer, farmType);
	}
	
	/**
	 * Default constructor for creating the farm
	 */
	public static void createFarm() {
		newFarm = new Farm(newFarmer);
	}
	
	public void closeWelcomeScreen(WelcomeScreen welcomeWindow) {
		//welcomeWindow.closeWindow();
		//launchChooseFarmer();
	}
	
	public void launchChooseFarmer() {
		//ChooseFarmer chooseFarmerScreen = new ChooseFarmer(this);
	}
		
	public void closeChooseFarmerScreen(ChooseFarmer chooseFarmerScreen) {
		//chooseFarmerScreen.closeWindow();
		//launchChooseFarmType();
	}
	public void launchMainWindow() {
		String currentCrops = newFarm.viewCrops();
	}
	
	public void closeMainWindow() {
		//launchMainWindow.closeWindow();
		
	}
	
	public String toString(String message) {
		return message;
	}
	
	public Farmer getFarmer() {
		return newFarmer;
	}
	
	public Farm getFarm() {
		return newFarm;
	}
	
	public String getDetails() {
		return newFarmer.viewDetails()
				+ newFarm.viewFarmStatus()
				+"Days left to play: " + currentDay + ",\n"; 
		
	}
	
	private static void startGame(PaddockParadiseManager manager) {
//		Create a new game environment here, passing in manager
		GameEnvironment environment = new GameEnvironment(manager);
		
	}
	
	public static void main(String[] args) {
		PaddockParadiseManager manager = new PaddockParadiseManager();
		launchWelcomeWindow(manager);
		manager.getFarm();
		manager.getDetails();
//		Farmer Jack = new Farmer();
//		Farm Johnson = new Farm(Jack);
//		newFarmer = Jack;
//		newFarm = Johnson;
//		startGame();
		
// 
		
		
		
	}

}
