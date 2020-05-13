import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerTester {
	
	String newName;
	int age;
	float cost;
	
	public static void ScannerTest() {
		
		boolean confirm = false;
		
		do {
		Scanner scanName = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = scanName.nextLine(); 
		
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		Pattern numbers = Pattern.compile("[0-9]");
		
		Matcher hasNums = numbers.matcher(name);
		Matcher hasSpecial = special.matcher(name);
		boolean confirmSpec = hasSpecial.find();
		boolean confirmNums = hasNums.find();
		
		if (confirmSpec || confirmNums) {
			System.out.println("Nope");
		}else {
			System.out.println("I am a string");
			confirm = true;
			}
		}while (confirm == false);
	}
	
	public static void main(String[] args) {
		ScannerTest();
		
	}

}
