package baseutility;

import java.util.Scanner;

/**
 * @author liam
 *
 */
public class Setup {
	
	public static void setupGame() {
		
		System.out.println("Welcome to Paddock Paradise!");
		
		// Scanner is used to get input from the user.
		Scanner scanner = new Scanner(System.in);
		
		String input;
		
		do {
			
			System.out.println("Start a new game? (y/n)\n");
			
			// Reads user input
			input = scanner.next().toLowerCase();
			
			if (input.equals("y")) {
				scanner.close();
				System.out.println("Do something");
			} else if (input.equals("n")) {
				scanner.close();
				System.exit(0);
			} else {
				System.out.println("You didn't enter a valid input!\n");		
			}
		} while (!(input.equals("y") || input.equals("n")));
		
	}
	
	public static void main(String args[]) {
		
		/**
		 *  Instantiate a game environment
		 */
		
		System.out.println("Game is running");
		
		setupGame();
		
	}
	
}
