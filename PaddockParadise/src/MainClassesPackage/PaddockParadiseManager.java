package MainClassesPackage;
import java.util.Scanner;
import baseutility.GameEnvironment;
import supportClasses.Days;
import GUIPackage.*;
import GUIPackage.ChooseFarmer;

public class PaddockParadiseManager {
	
	private static Farmer newFarmer;
	private static Farm newFarm;
	private Days currentDay;
	
	
	public static void getFarmerDetails() {
		Scanner name = new Scanner(System.in);
		System.out.print("Enter Name:\n");
		String newName = name.nextLine();
		
		
		Scanner age = new Scanner(System.in);
		System.out.print("Enter Age:\n");
		int newAge = age.nextInt();
		
		
		Scanner type = new Scanner(System.in);
		System.out.print("Choose Type by typing corresponding number only!:\n"
				+ " [1] Male Farmer\n "
				+ "[2] Female Farmer\n "
				+ "[3] Alien Farmer\n");
		int newInt = type.nextInt();
		String newType;
		
		if (newInt == 1) {
			newType = "Male Farmer";
		}else if (newInt == 2) {
			newType = "Female Farmer";
		}else if (newInt == 3) {
			newType = "Alien Farmer";
		}else {
			System.out.println("Sorry that was an invalid option, so I have choosen the default Farmer for you\n"
					+ "You are now an Alien Farmer,\n"
					+ "Welcome to Earth!!!\n");
			newType = "Alien Farmer";
		}
		
		
		createFarmer(newName, newAge, newType);
		getFarmDetails();
		name.close();
		type.close();
		age.close();
	}
	
	public static void getFarmDetails() {
		
		Scanner name = new Scanner(System.in);
		System.out.print("Enter Farm Name:\n");
		String newName = name.nextLine();
		
		
		Scanner type = new Scanner(System.in);
		System.out.print("Choose Type by typing corresponding number only!:\n"
				+ "[1] Money Tree\n"
				+ "[2] Faster Crop Growth\n"
				+ "[3] Happy Animal\n"
				+ "[4] Discount Store\n");
		
		int newInt = type.nextInt();
		String newType;
		
		if (newInt == 1) {
			newType = "Money Tree";
		}else if (newInt == 2) {
			newType = "Faster Crop Growth";
		}else if (newInt == 3) {
			newType = "Happy Animal";
		}else if (newInt == 4) {
			newType = "Discunt Store";
		}else {
			System.out.println("Sorry that was an invalid option, so I have choosen the default Farm for you\n"
					+ "You now own a MoneyTree Farm\n");
			newType = "Money Tree";
		}
		
		createFarm(newName, newType);
		name.close();
		type.close();
	}  // Just finished creating method to get details to create farm!!!!!!!!!!!!!
	
	
	public static void createFarmer(String newName,int newAge,String newType) {
		newFarmer = new Farmer(newName, newAge, newType);
	}
	
	public void createFarmer() {
		newFarmer = new Farmer();
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
	/**
	 * Launches the WelcomeScreen that welcomes the user to the game
	 *      and gets the amount of days the user would like to play for
	 * 
	 */
	public static void launchWelcomeWindow() {
		//WelcomeScreen welcomeWindow = new WelcomeScreen(this);
		System.out.println("Welcome to Paddock Paradise");
		getFarmerDetails();
		
		
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
	
	public String toString(String message) {
		return message;
	}
	
	public Farmer getFarmer() {
		return newFarmer;
	}
	
	public Farm getFarm() {
		return newFarm;
	}
	
	
	private void startGame() {
		
//		Create a new game environment here, passing in manager
		
		
	}
	
	public static void main(String[] args) {
//		PaddockParadiseManager manager = new PaddockParadiseManager();
//		manager.launchWelcomeWindow();
		launchWelcomeWindow();
		
//		need to make it so that the variables we set for farm, farmer etc. are passed
//		into a PaddockParadiseManager instance, and are handed over to GameEnvironment to 
//		play
		
		
		
	}

}
