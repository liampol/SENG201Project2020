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
		int day = getDays();
		manager.setDays(day);
		
		String name = getName();
		int age = getAge();
		String type = getType();
		Farmer farmer = new Farmer(name, age, type);
		farmer.viewDetails();
		manager.setFarmer(farmer);
		
		getFarmName();
		getFarmType();
		
		
		return farmer;
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
				System.out.println("You thought I wouldn't notice! \nPlease enter a VALID option\n");
			}
		}while (!invalid);
		
		return newName;
	}
	
	private int getAge() {
		
		int newAge = 0;
		invalid = false;
		String check = "";
		boolean pass = false;
		String message = "";
		do {
			System.out.println("Please enter your age: (Enter a age between 10 and 100)");
			check = input.nextLine();
			Matcher hasSpecial = special.matcher(check);
			Matcher hasLetter = letter.matcher(check);
			
			if (!(hasSpecial.find() || hasLetter.find())) {
				newAge = Integer.parseInt(check);
			}
			if (newAge >= 10 && newAge <=20) {
				pass = true;
				message = " WOW your still young!";
			}else if ( newAge >=20 && newAge <= 100) {
				pass = true;
				message = "Thank you!";
			}
			if (pass == false){
				System.out.println("Sorry that was an invalid input, please try again?");
			}else {
				System.out.println(message);
			}
			
		}while(!(pass));
		return newAge;
	}
	
	private String getType() {
		
		
		// Gets the type of Farmer
		invalid = false;
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
			}while (!(invalid));
			
		return newType;
		
	}
	
	
	public String getFarmName() {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Farm Name:\n");
		String newName = input.nextLine();
		
		return newName;
	}
	
	public String getFarmType() {
		
		
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
	}
	
	
	private static void main(String[] args) {
		
		PaddockParadiseManager manager = new PaddockParadiseManager();
		
		Setup setup = new Setup();
		setup.createFarmer(manager);
	}
	
	
	
	
	
	
}
