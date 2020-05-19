package MainClassesPackage;
import java.util.ArrayList;
import baseutility.*;
import java.util.Scanner;
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
	private static ArrayList<Integer> options = new ArrayList<Integer>(3);
	private static int activitiesLeft;
	private String optionString;
	private Scanner gameScanner = new Scanner(System.in);
	
	/**
	 * Launches the WelcomeScreen that welcomes the user to the game
	 *      and gets the amount of days the user would like to play for
	 * 
	 */
	public PaddockParadiseManager() {
		activitiesLeft = 2;
		for (int i = 1; i < 4; i++) {
			options.add(i);
		}
		Setup setup = new Setup();
		setup.createFarmer(this);
		//launchWelcomeWindow(this);
		optionString = "What would you like to do?\n"
				+	"[1] View " + newFarm.getName() + "\n"
				+	"[2] Perform an action\n"
				+	"[3] Visit the General Store\n"
				+   "[4] Skip to next day?";
		playGame(gameScanner);
		// Only closes once game is finished, i.e all calls of playGame() is finished.
	}
	
	public void setDays(int day) {
		currentDay = day;
	}
	
	public void setFarmer(Farmer farmer) {
		newFarmer = farmer;
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
		playGame(gameScanner);
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
			//endGame(this); need to implement end game
		}
		newFarm.growCrops();          // decreases the amount of days left for crops to grow
		//newFarm.setAnimalState();   // need to implement a change of state for animal so they need to be tended too, 
		                              // Cant forget to incorporate 'Happy Animal Bonus'
		// Need to implement a reset for activities counts
		// Need to implement a random occurrence for extra credit that occurs every 3rd day??
		playGame(gameScanner);
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
	
	public String viewDetails() {
		return newFarmer.viewDetails()
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
