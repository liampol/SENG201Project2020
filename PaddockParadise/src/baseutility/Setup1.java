package baseutility;

	import java.util.Scanner;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import MainClassesPackage.*;
	import GUIPackage.*;

	/**
	 * @author Te Wehenga Johnson
	 *
	 */
public class Setup1 {
	
	private static PaddockParadiseManager manager;
	Scanner input = new Scanner(System.in);
	Pattern letter = Pattern.compile("[a-zA-z]");
    Pattern nums = Pattern.compile("[0-9]");
    Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
    boolean invalid = false;
	
	
	public Setup1(PaddockParadiseManager incomingManager) {
		
		manager = incomingManager;
		launchWelcomeWindow();
	}
	
	public void launchWelcomeWindow() {
		WelcomeScreen welcomeWindow = new WelcomeScreen(this);
	}
	
	public void closeWelcomeScreen(WelcomeScreen welcomeWindow) {
		welcomeWindow.closeWindow();
		launchChooseAvatar();
	}
	
	public void launchChooseAvatar() {
		ChooseAvatar chooseAvatarScreen = new ChooseAvatar(this);
	}
	
	public void closeChooseAvatarScreen(ChooseAvatar chooseAvatarScreen) {
		chooseAvatarScreen.closeWindow();
		launchFarmerDetails();
	}
	
	public void launchFarmerDetails() {
		FarmerDetails farmerDetailsWindow = new FarmerDetails(this);
	}
	
	public void closeFarmerDetailsScreen(FarmerDetails farmerDetailsScreen) {
		farmerDetailsScreen.closeWindow();
	}
	
	public void launchChooseFarmType() {
		ChooseFarmType chooseFarmTypeScreen = new ChooseFarmType(this);
	}
	
	public void closeChooseFarmType(ChooseFarmType chooseFarmTypeScreen) {
		chooseFarmTypeScreen.closeWindow();
	}
	
	public PaddockParadiseManager getManager(){
		return manager;
	}
	
	public int getDays() {
		
		int days = 0;
		String check = "";
		boolean pass = false;
		do {
			System.out.println("How long would you like to play for? (Please type in a number between 5 and 10)\n");
			check = input.nextLine();
			Matcher hasSpecial = special.matcher(check);
			Matcher hasLetter = letter.matcher(check);
			
			if (!(hasSpecial.find() || hasLetter.find())) {
				days = Integer.parseInt(check);
			}
			if (days >= 5 && days <=10) {
				pass = true;
			}
			if (pass == false){
				System.out.println("Sorry that was an invalid input, please try again?");
			}else {
				System.out.println("Nice choice!");
			}
			
		}while(!(pass));
		return days;
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
		boolean valid = false;
		String check = "";
		boolean pass = false;
		String message = "";
		do {
			
			System.out.println("Please enter your age: (Enter a age between 10 and 100)");
			check = input.nextLine();
			valid = checkValidInt(check);
			if (valid) {
				newAge = Integer.parseInt(check);
			}
			while (valid) {
				valid = false;
				if (newAge >= 10 && newAge <=20) {
					pass = true;
					message = " WOW your still young!";
				}else if ( newAge >= 20 && newAge <= 100) {
					pass = true;
					message = "Thank you!";
				}
				if (pass == false){
					System.out.println("Sorry that was an invalid input, please try again?");
				}else {
					System.out.println(message);
				}
			}
			
		}while(!(pass));
		return newAge;
	}
	
	private String getFarmerType() {
		
		
		// Gets the type of Farmer
		invalid = false;
		int newInt = 0;
		String newType = "";
		String check = "";
		boolean inputValid = false;
		
		do {
			System.out.print("Choose Type by typing corresponding number only!:\n"
					+ " [1] Male Farmer\n "
					+ "[2] Female Farmer\n "
					+ "[3] Alien Farmer\n");
			check = input.nextLine();
			inputValid = checkValidInt(check);
			if (inputValid) {
				newInt = Integer.parseInt(check);
			}
			while (inputValid) {
				inputValid = false;
				if (newInt == 1) {
					newType = "Male Farmer";
					invalid = true;
				}else if (newInt == 2) {
					newType = "Female Farmer";
					invalid = true;
				}else if (newInt == 3) {
					newType = "Alien Farmer";
					invalid = true;
				}else {
					System.out.println("That is an invalid option, please choose again");
					}
				}
			}while (!(invalid));
			
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
		String newType = "";
		String option = "";
		boolean correct = false;
		boolean valid = false;
		
		do {
			System.out.print("Choose Type by typing corresponding number only!:\n\n"
					+ "[1] Money Tree:\n"
					+ "Gives 20% Extra money bonus at the start of each day,\n"
					+ "[2] Faster Crop Growth:\n"
					+ "Decreases the days till harvest by 1,\n"                 // implemented
					+ "[3] Happy Animal:\n"
					+ "Animals are happier for 2 extra days when purchased,\n"   // implemented
					+ "[4] Discount Store:\n"
					+ "40% Discount added to cart on checkout!\n");               // implemented
			option = input.nextLine();
			valid = checkValidInt(option);
			if (valid) {
				newInt = Integer.parseInt(option);
			}
			while (valid) {
				valid = false;
			
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
			}
			
		}while(!(correct));
		
		return newType;
	}
	
	private boolean checkValidInt(String toCheck) {
		
		boolean correct = false;
		Matcher hasSpecial = special.matcher(toCheck);
		Matcher hasLetter = letter.matcher(toCheck);
		
		if (!(hasSpecial.find() || hasLetter.find())) {
			correct = true;
		}
		
		return correct;
	}
	
	
	private static void main(String[] args) {
		
		PaddockParadiseManager manager = new PaddockParadiseManager();
		
	//	Setup setup = new Setup();
	//	setup.createFarmer(manager);
		}
		

	}

