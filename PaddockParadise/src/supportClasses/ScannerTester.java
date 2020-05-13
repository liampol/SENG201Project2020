package supportClasses;
import java.util.Scanner;
public class ScannerTester {
	
	String newName;
	
	public static void ScannerTest() {
		String name = getName();
		System.out.println("Hello " + name);
		
	}
	
	public static String getName() {
		Scanner scanName = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = scanName.nextLine();
		return name;
	}
	
	public static void main(String[] args) {
		ScannerTest();
		
	}

}
