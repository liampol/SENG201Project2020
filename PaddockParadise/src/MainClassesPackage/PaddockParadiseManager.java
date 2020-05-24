package MainClassesPackage;
import java.util.ArrayList;
import java.util.Random;

import baseutility.*;
import extendSupplies.*;

import java.util.Scanner;
import GUIPackage.*;
import GUIPackage.ChooseFarmer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Actions.*;

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
	
	private int totalDays;
	private static Farmer newFarmer;
	private static Farm newFarm;
	private static int currentDay;
	private static ArrayList<Integer> options;
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
		options = createOptionList(5);
		Setup setup = new Setup(this);
		totalDays = currentDay;
		optionString = "What would you like to do?\n"
				+	"[1] View " + newFarm.getName() + "\n"
				+	"[2] Perform an action\n"
				+	"[3] Visit the General Store\n"
				+   "[4] Skip to next day?\n"
				+ 	"[5] Help\n";
		
		initRandomOccurences();
		// runtime loop
		runGame();
		// Only closes once game is finished, i.e all calls of playGame() is finished.
	}
	
	public void runGame() {
		while (true) {
			try {
				playGame(gameScanner);
			} catch(NullPointerException npe) {
				displayScoreboard();
				break;
			}
		}
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
		
		randomOccurences.add("None");		   // No events
		randomOccurences.add("None");
		randomOccurences.add("None");          
		randomOccurences.add("Thief");         // Lose 40% of money
		randomOccurences.add("None");
		randomOccurences.add("Drought");       // Lose a random amount of Crops
		randomOccurences.add("None");
		randomOccurences.add("Broken Fence");  // Lose a random amount of animals
		randomOccurences.add("County Fair");   // Gets 200% farm worth

	}
	
	
	public void playGame(Scanner scanner) {
		System.out.println(optionString);
		int choice = getValidInput(options, optionString);
		switch (choice) {
		case 1:
			// CHANGED from viewFarmStatus()
			System.out.println(viewDetails());
			break;
		case 2:
			performActivity();
			break;
		case 3:
			visitMarket();
			break;
		case 4:
			skipDay();
		case 5:
			howToPlay();
		}

	}
	
	public ArrayList<Integer> createOptionList(int numOptions) {
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		for (int i = 1; i < numOptions + 1; i++) {
			returnList.add(i);
		}
		return returnList;
	}
	
	public int getValidInput(ArrayList<Integer> optionList, String errorMessage) {
		int choice = getInput(gameScanner);
		while (!isValidInput(optionList, choice)) {
			System.out.println(errorMessage);
			choice = getInput(gameScanner);
		}
		return choice;
	}
	
	public int getValidInput(ArrayList<Integer> optionList, String errorMessage, int function) {
		int choice = getInput(gameScanner);
		while (!isValidInput(optionList, choice)) {
			runFunction(function);
			System.out.println(errorMessage);
			choice = getInput(gameScanner);
		}
		return choice;
	}
	
	public void runFunction(int functionNum) {
		switch (functionNum) {
		case 1:
			foodAvailable();
			break;
		case 2:
			itemAvailable();
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
	
	public boolean existsByName(Supplies supply, ArrayList<Supplies> supplyList) {
		for (Supplies supplyInList: supplyList) {
			if (supplyInList.getName().equals(supply.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasSupply(Supplies supply, ArrayList<Supplies> supplyList) {
		if (!existsByName(supply, supplyList)) {
			System.out.println("You don't have any " + supply.getName() + "!\n");
			return false;
		}
		return true;
	}

	public void viewFarmStatus() {
		System.out.println(newFarm.viewFarmStatus());
	}

	public void visitMarket() {
		try {
			Market openMarket = new Market(this);
		} catch(NullPointerException npe) {
			// try-catch used to abort instantiation and return;
		}
		leaveMarket();
	
	}

	public void leaveMarket() {
		//openMarket.closeWindow()
	}
	
	public void howToPlay() {
		System.out.println("------ Paddock Paradise ------\n"
						+"\nWelcome to Paddock Paradise! "
						+ "You are a farmer trying to make "
						+ "as \nmuch money as possible from your farm "
						+ "lifestyle. The best way to \ndo this is by running "
						+ "your farm as successfully as possible; \nwhich means "
						+ "keeping your animals happy and healthy, and "
						+ "growing as \nmany crops as you can. "
						+ "But although your main priority will be to \nmake money, "
						+ "your score at the end will be determined by the\namount of "
						+ "animals you have and their conditions, as well as your "
						+ "\nextra crops. "
						+ "Now that you have begun your game, you can visit the "
						+ "\ngeneral store to buy crops, animals, and supplies. "
						+ "You can use two \nactions per day, and they can be spent "
						+ "performing a variety of tasks \nthat will help you maintain "
						+ "a successful farm. Once you are out of \nactions, you need to go "
						+ "to the next day to refresh them (and \nprogress the game!).\n\n"
						+ "\n1) Animals - Farm animals give you extra at the end of "
						+ "\neach day. This bonus depends on the emotional state of the animal, so "
						+ "\nmake sure you keep them happy! Make sure you keep your farm animals "
						+ "\nfed as well, otherwise they'll starve!\n"
						+ "\n2) Crops - Crops require a certain amount of time (days) to grow, but "
						+ "\nwill give you extra amount of money once they are ripe and are "
						+ "\nharvested!\n"
						+ "\n3) Actions - You can perform 2 actions a day, which can be any of the "
						+ "\nfollowing tasks - feeding an animal, playing with an animal, tending "
						+ "\nto a crop, harvesting a crop, or tending the land.\n"
						+ "\n4) Viewing your farm - You can view the status of your farm at anytime. "
						+ "\nThis will give you all the information you need on your crops, animals, "
						+ "\nthe state of your farm and much more.\n"
						+ "\n5) Events - At the start of each day, you may find that an event has "
						+ "\noccurred. These may not all be good or bad, but anything can happen out "
						+ "\non the farm so be prepared!\n"
						+ "\nAnd that's all the basics of it. Happy farming!\n");
	}
	
	private void rollRandomOccurence() {
		
		Random random = new Random();
		int marker = random.nextInt(randomOccurences.size());
		String occurence = randomOccurences.get(marker);
		newFarm.runOccurence(occurence);
		
	}

	public void performActivity() {
		if (activitiesLeft > 0) {
			String optionsStr = "What action would you like to perform?\n" 
					+ "[1] Feed a farm animal (Increases the animals healthiness)\n"
					+ "[2] Play with a farm animal (Increases the animals happiness)\n" 
					+ "[3] Tend to a crop (Decreases the time until it can be harvested)\n"
					+ "[4] Tend to the farmland (Allows more crops to be grown)\n"
					+ "[5] Harvest a crop (Harvest and sell a fully grown crop)\n"
					+ "[6] No action - go back.\n";
			System.out.println(optionsStr);
			ArrayList<Integer> activityOptions = createOptionList(6);
			int choice = getValidInput(activityOptions, optionsStr);
			switch (choice) {
			case 1:
				feedAnimal();
				break;
			case 2:
				playWithAnimal();
				break;
			case 3:
				try {
					tendCrops();
				} catch(NullPointerException npe) {
		
				}
				break;
			case 4:
				tendLand();
				break;
			case 5:
				harvestCrops();
			case 6:
				return;
			}
		} else {
			System.out.println("You don't have any actions left for the day!");
		}

	}
	
	public void skipDay() {
		System.out.println("Welcome to the new day");
		currentDay -= 1; 
		if (currentDay < 0) {
			endGame(this); // need to implement end game
		}else {
			newFarm.startNewDay();
			setActivitiesLeft(2);
			rollRandomOccurence();  // Implements the random occurrences that happen at the start of everyday
			
			// Implemented only if the FarmType is Money Tree
			if (newFarm.getType() == "Money Tree"){
				double bonus = newFarm.getFarmWorth();
				bonus = (bonus*0.2);
				newFarm.addToWallet(bonus);
				System.out.println("Your Money Tree has given you $" + bonus + "!\n");
			}

		}
	}
	
	public void feedAnimal() {
		if (!newFarm.getAnimals().isEmpty()) {
			String output = newFarm.viewAnimals() + "\nChoose an animal to feed!"+ "\n[" 
												+ (newFarm.getAnimals().size()+1)+"] Go back.\n";
			System.out.println(output);
			ArrayList<Integer> optionsList = createOptionList(newFarm.getAnimals().size() + 1);
			int choice = getValidInput(optionsList, output);
			if (choice == (newFarm.getAnimals().size()+1)) {
				return;
			}
			Animal animalChosen = newFarm.getAnimals().get(choice - 1);
			String askUser = "What food would you like to use?\n";
			if (foodAvailable()) {
				System.out.println(askUser);
				ArrayList<Integer> nextOptionList = createOptionList(3);
				choice = getValidInput(nextOptionList, askUser, 1);
				Supplies itemChoice;
				boolean successfullyFed = true;
				switch (choice) {
				case 1:
					itemChoice = new Hay();
					if (!hasSupply(itemChoice, newFarm.getCurrentSupplies())) {
						successfullyFed = false;
					}
					break;
				case 2:
					itemChoice = new Grains();
					if (!hasSupply(itemChoice, newFarm.getCurrentSupplies())) {
						successfullyFed = false;
					}
					break;
				case 3:	
					itemChoice = new Vitamins();
					if (!hasSupply(itemChoice, newFarm.getCurrentSupplies())) {
						successfullyFed = false;
					}
					break;
				default:
					itemChoice = new Hay();
				}
				if (successfullyFed) {
					FeedAnimals animalFed = new FeedAnimals(this, animalChosen, itemChoice);
					animalFed.performAction();
				}
				
			} else {
				System.out.println("You don't own any Hay, Grains or Vitamins to feed the animals!\n");
			}
			
		} else {
			System.out.println("There are no animals!\n");
			}
		
	}
	
	private boolean foodAvailable() {
		String outputStr = "Animal food available: \n";
		int hayCount = 0;
		int grainsCount = 0;
		int vitaminsCount = 0;
		for (Supplies supply: newFarm.getCurrentSupplies()) {
			switch (supply.getName()) {
			case "Hay":
				hayCount += 1;
				break;
			case "Grains":
				grainsCount += 1;
				break;
			case "Vitamins":
				vitaminsCount += 1;
				break;
			}
		}
		if (hayCount == 0 && grainsCount == 0 && vitaminsCount == 0) {
			return false;
		}
		outputStr +=    ("[1] Hay - Keeps animals Happier for 3 days, (x" + hayCount + ")\n"
						+ "[2] Grains - Keeps animals Healthier for 3 days, (x" + grainsCount + ")\n"
						+ "[3] Vitamins - Keeps animals Healthier and Happy for 3 days, (x" + vitaminsCount + ")\n");
		System.out.println(outputStr);
		return true;
	}

	public void harvestCrops() {
		if (!newFarm.getCrops().isEmpty()) {
			String output = newFarm.viewCropsStatus() + "\nChoose a crop to harvest!"+ "\n[" 
					+ (newFarm.getCrops().size()+1)+"] Go back.\n";
			System.out.println(output);
			ArrayList<Integer> optionsList = createOptionList(newFarm.getCrops().size() + 1);
			int choice = getValidInput(optionsList, output);
			if (choice == (newFarm.getCrops().size()+1)) {
				return;
			}
			Crop cropChosen = newFarm.getCrops().get(choice - 1);
			HarvestCrops cropHarvest = new HarvestCrops(this, cropChosen);
			cropHarvest.performAction();
		} else {
			System.out.println("There are no crops!\n");
		}
	}
	
	public void playWithAnimal() {
		if (!newFarm.getAnimals().isEmpty()) {
			String output = newFarm.viewAnimals() + "\nChoose an animal to play with!"+ "\n[" 
							+ (newFarm.getAnimals().size()+1)+"] Go back.\n";
			System.out.println(output);
			ArrayList<Integer> optionsList = createOptionList(newFarm.getAnimals().size() + 1);
			int choice = getValidInput(optionsList, output);
			if (choice == (newFarm.getAnimals().size()+1)) {
				return;
			}
			Animal animalChosen = newFarm.getAnimals().get(choice - 1);
			PlayWithAnimals animalPlay = new PlayWithAnimals(this, animalChosen);
			animalPlay.performAction();
		} else {
			System.out.println("There are no animals!\n");
		}
	}
	
	public void tendCrops() {
		if (!newFarm.getCrops().isEmpty()) {
			String output = newFarm.viewCropsStatus() + "\nChoose a crop to tend!"+ "\n[" 
														+ (newFarm.getCrops().size()+1)+"] Go back.\n";
			System.out.println(output);
			ArrayList<Integer> optionsList = createOptionList(newFarm.getCrops().size() + 1);
			int choice = getValidInput(optionsList, output);
			if (choice == (newFarm.getCrops().size()+1)) {
				return;
			}
			Crop cropChosen = newFarm.getCrops().get(choice - 1);
			String askUser = "What item would you like to use?\n";
			boolean successfullyTended = true;
			if (itemAvailable()) {
				System.out.println(askUser);
				ArrayList<Integer> nextOptionList = createOptionList(4);
				choice = getValidInput(nextOptionList, askUser, 2);
				Supplies itemChoice;
				switch (choice) {
				case 2:
					itemChoice = new HorseDung();
					if (!hasSupply(itemChoice, newFarm.getCurrentSupplies())) {
						successfullyTended = false;
					}
					break;
				case 3:
					itemChoice = new Fertiliser();
					if (!hasSupply(itemChoice, newFarm.getCurrentSupplies())) {
						successfullyTended = false;
					}
					break;
				case 4:	
					itemChoice = new RootBoost();
					if (!hasSupply(itemChoice, newFarm.getCurrentSupplies())) {
						successfullyTended = false;
					}
					break;
				default:
					itemChoice = null;
				}
				if (successfullyTended) {
					TendCrops cropTended = new TendCrops(this, cropChosen, itemChoice);
					cropTended.performAction();
				}
				
			} else {
				System.out.println(askUser);
				ArrayList<Integer> nextOptionList = createOptionList(2);
				choice = getValidInput(nextOptionList, askUser, 2);
				if (choice == 1) {
					TendCrops cropTended = new TendCrops(this, cropChosen, null);
					cropTended.performAction();
				} else {
					throw new NullPointerException();
				}
			}
			
		} else {
			System.out.println("There are no crops!\n");
			}
	}
	
	private boolean itemAvailable() {
		String outputStr = "Crop items available: \n";
		int horseDungCount = 0;
		int rootBoostCount = 0;
		int fertiliserCount = 0;
		for (Supplies supply: newFarm.getCurrentSupplies()) {
			switch (supply.getName()) {
			case "Horse Dung":
				horseDungCount += 1;
				break;
			case "Fertiliser":
				fertiliserCount += 1;
				break;
			case "Root Boost":
				rootBoostCount += 1;
				break;
			}
		}
		if (horseDungCount == 0 && rootBoostCount == 0 && fertiliserCount == 0) {
			outputStr += "[1] Water - Grows crops faster by 1 day, (UNLIMITED)\n"
						+"[2] No item - go back.";
			System.out.println(outputStr);
			return false;
		}
		outputStr +=    ("[1] Water - Grows crops faster by 1 day, (UNLIMITED)\n"
						+ "[2] Horse Dung - Grows crops faster by 2 day, (x" + horseDungCount+ ")\n"
						+ "[3] Fertiliser - Grows crop faster by 3 days, (x" + fertiliserCount + ")\n"
						+ "[4] Root Boost - Grows crop faster by 4 days, (x" + rootBoostCount + ")\n")
						+ "[5] No item - go back.";
		System.out.println(outputStr);
		return true;
	}
	
	public void tendLand() {
		TendLand landTended = new TendLand(this);
		landTended.performAction();
	}
	
	public void endGame(PaddockParadiseManager manager) {
		System.out.println("You have completed the game!");
		throw new NullPointerException();
	}
	
	public void displayScoreboard() {
		System.out.println("---------------");
		int playerScore = getScore();
		int[] scoreMilestones = {(int) (16000 / totalDays),
								(int) (12000 / totalDays),
								(int) (5000 / totalDays)};
		String title;
		if (playerScore > scoreMilestones[0]) {
			title = "Legendary Farmer";
		} else if (playerScore > scoreMilestones[1] && playerScore <= scoreMilestones[0]) {
			title = "Master Farmer";
		} else if (playerScore > scoreMilestones[2] && playerScore <= scoreMilestones[1]) {
			title = "Amateur Farmer";
		} else {
			title = "Rookie Farmer";
		}
		System.out.println("Your score is " + playerScore + ", and you have reached the title of "
							+ title +".\n\nThanks for playing Paddock Paradise!");
		
	}
		
	public int getScore() {
		int score = (int) (((newFarm.getMoney() + newFarm.getFarmWorth()) / 2) / totalDays);
		return score;
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
	
	public void closeChooseFarmType(ChooseFarmType chooseFarmTypeScreen) {
//		chooseFarmTypeScreen.closeWindow();
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
		String farmStateString = (newFarm.getState().equals("Unkept")) ? "\n\n" + newFarm.getName() + " is unkept! "
				+ "\nYour animals will lose happiness twice as fast and you'll reduce the maximum amount of crops"
				+ " you can plant unless the land is tended to!\n" :
					"\n";
		return newFarmer.viewFarmerStatus() + "\n"
				+ newFarm.viewFarmStatus()
				+ "\nDays left to play: " + currentDay + ","
				+ "\nCrop capacity: " + newFarm.getCropLimit() + ","
				+ "\nActions remaining: " + activitiesLeft
				+ "\nState of Farm: " + newFarm.getState() + ","
				+ farmStateString;
		
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
