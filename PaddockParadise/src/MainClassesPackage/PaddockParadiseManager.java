package MainClassesPackage;
import java.util.ArrayList;
import java.util.Random;

import baseutility.*;
import java.util.Scanner;
import GUIPackage.*;
import GUIPackage.ChooseFarmer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * PaddockParadiseManager is the game environment,
 *
 * @author Te Wehenga Johnson
 * @author Liam Pol
 *
 */
public class PaddockParadiseManager {
	
	private static Farmer newFarmer;
	private static Farm newFarm;
	private static int currentDay;
	private static ArrayList<Integer> options = new ArrayList<Integer>(4);
	private static int activitiesLeft;
	private String optionString;
	private ArrayList<String> randomOccurences = new ArrayList<String>();
	private Scanner gameScanner = new Scanner(System.in);
	
	/**
	 * Launches the WelcomeScreen that welcomes the user to the game
	 *      and gets the amount of days the user would like to play for
	 * 
	 */
	public PaddockParadiseManager() {
		activitiesLeft = 2;
		for (int i = 1; i < 5; i++) {
			options.add(i);
		}
		Setup setup = new Setup(this);
		
		optionString = "What would you like to do?\n"
				+	"[1] View " + newFarm.getName() + "\n"
				+	"[2] Perform an action\n"
				+	"[3] Visit the General Store\n"
				+   "[4] Skip to next day?";
		initRandomOccurences();          
		playGame(gameScanner);
		// Only closes once game is finished, i.e all calls of playGame() is finished.
	}
	
	public static void launchWelcomeWindow(PaddockParadiseManager manager) {
		//WelcomeScreen welcomeWindow = new WelcomeScreen(this);
		System.out.println("Welcome to Paddock Paradise");
	}
	
	public void setDays(int day) {
		currentDay = day;
	}
	
	public void setFarmer(Farmer farmer) {
		newFarmer = farmer;
	}
	
	public Farmer getFarmer() {
		return newFarmer;
	}
	
	public void setFarm(Farm farm) {
		newFarm = farm;
	}
	
	public Farm getFarm() {
		return newFarm;
	}
	
	private void initRandomOccurences() {
		
		randomOccurences.add("None");
		randomOccurences.add("Flood");         // lose one animal and 4 crops
		randomOccurences.add("Thief");         // Lose 40% of money
		randomOccurences.add("None");
		randomOccurences.add("Drought");       // Lose a random amount of Crops
		randomOccurences.add("None");
		randomOccurences.add("Fox");           // lose all Sheep
		randomOccurences.add("Broken Fence");  // Lose a random amount of animals
		randomOccurences.add("County Fair");   // Gets 200% Farm worth

	}
	
	
	public void playGame(Scanner scanner) {
		System.out.println(optionString);
		int choice = getInput(scanner);
		while (!isValidInput(options, choice)) {
			System.out.println(optionString);
			choice = getInput(scanner);
		}
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
		case 4:
			skipDay();
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
	
	public void setActivitiesLeft(int activitiesLeft) {
		this.activitiesLeft = activitiesLeft;
	}
	
	public int getActivitiesLeft() {
		return activitiesLeft;
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
		System.out.println(newFarm.viewFarmStatus());
		playGame(gameScanner);
	}

	public void visitMarket() {
		Market openMarket = new Market(this);
		leaveMarket();
	
	}

	public void leaveMarket() {
		//openMarket.closeWindow()
		playGame(gameScanner);
	}
	
	private void rollRandomOccurence() {
		
		Random random = new Random();
		int marker = random.nextInt(randomOccurences.size());
		String occurence = randomOccurences.get(marker);
		newFarm.runOccurence(occurence);
		
	}

	public void performActivity() {
	/**
	 *  Do stuff
	 * 
	 */
		playGame(gameScanner);
	}
	
	public void skipDay() {
		System.out.println("Welcome to the new day");
		currentDay -= 1; 
		if (currentDay < 0) {
			endGame(this); // need to implement end game
		}else {
			newFarm.startNewDay();
			setActivitiesLeft(2);
			rollRandomOccurence();
			// Need to implement a random occurrence for extra credit that occurs every 3rd day??
		playGame(gameScanner);
		}
	}
	
	public void endGame(PaddockParadiseManager manager) {
		System.out.println("You have completed the game!");
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
		//String currentCrops = newFarm.viewCrops();
	}
	
	public void closeMainWindow() {
		//launchMainWindow.closeWindow();
		
	}
	
	public String toString(String message) {
		return message;
	}
	
	public String viewDetails() {
		return newFarmer.viewFarmerStatus()
				+ newFarm.viewFarmStatus()
				+"Days left to play: " + currentDay + ",\n"; 
		
	}
	
	
	public static void main(String[] args) {
		PaddockParadiseManager manager = new PaddockParadiseManager();
		manager.gameScanner.close();
		
		// MOVED launchWelcomeWindow to CONSTRUCTOR
//		manager.getFarm();
//		manager.viewDetails();
//		Farmer Jack = new Farmer();
//		Farm Johnson = new Farm(Jack);
//		newFarmer = Jack;
//		newFarm = Johnson;
//		startGame();		
// 
		
		
		
	}

}
