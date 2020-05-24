package mainClassesPackage;
import java.util.ArrayList;

import suppliesExtend.*;

public class Supplies {
	
	String bonus;                    // The bonus describes what the item does in the game environment
	String name;                     // The name of the Item
	double buyPrice;                  // The cost of the Item
		
	public Supplies(String newName, String newBonus, double cost) {
		
		bonus = newBonus;
		name = newName;
		buyPrice = cost;
	}
	
	public double getPrice() {
		return buyPrice;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBonus() {
		return bonus;
	}
	
	public String getDetails() {
		String details = "[Name] " + name + ", "
	+ "[Buy price] $" + buyPrice + ", "
	+ "[Bonus] " + bonus + ", \n";
		
		return details;
		//System.out.println(details);
	}
		
	

	
}
