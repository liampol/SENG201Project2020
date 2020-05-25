package MainClassesPackage;


/**
 * The Supplies Class is used as the parent class for the supplies
 * @author Te Wehenga Johnson
 *
 */
public class Supplies {
	
	String bonus;                    // The bonus describes what the item does in the game environment
	String name;                     // The name of the Item
	double buyPrice;                  // The cost of the Item
		
	public Supplies(String newName, String newBonus, double cost) {
		
		bonus = newBonus;
		name = newName;
		buyPrice = cost;
	}
	/**Returns the cost of the Supply
	 * 
	 * @return
	 */
	public double getPrice() {
		return buyPrice;
	}
	
	/**
	 * returns the name of the supply
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns what the supply does
	 * @return
	 */
	public String getBonus() {
		return bonus;
	}
	
	/**
	 * returns full details of a supply
	 * @return
	 */
	public String getDetails() {
		String details = "[Name] " + name + ", "
	+ "[Buy price] $" + buyPrice + ", "
	+ "[Bonus] $" + bonus + ", \n";
		
		return details;
	}
		
	

	
}
