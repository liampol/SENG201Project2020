package MainClassesPackage;
import cropExtend.*;


/**
 * The Crop class
 * 
 * @author Te Wehenga Johnson
 *
 */
public class Crop {
	
	String type;                    // Carrots, Potatos, Capsicum, Broccoli, Cauliflower, Avocado
	double sellPrice;               // Price to sell vegetable
	double buyPrice;                // Price to buy vegetable
	int daysToHarvest;              // Amount of days to harvest
	String state;                   // Plants current state ("Harvest", "Sprout") 
	int stateTracker;               
	boolean farmBonus;
	
	/**
	 * Constructor of Crop with parameters passed in from the class of vegetable being created 
	 * @param currentVegetable
	 * @param sellCost
	 * @param buyCost
	 * @param harvestTime
	 */
	public Crop(String currentVegetable, double sellCost, double buyCost, int harvestTime) {
		
		type = currentVegetable;
		sellPrice = sellCost;
		buyPrice = buyCost;
		daysToHarvest = harvestTime;
		state = "Sprout";
	}
	
	/**
	 * Returns the crop vegetable type
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Gets the amount of days left to harvest crop
	 * @return
	 */
	public int getDaysToHarvest() {
		return daysToHarvest;
	}
	
	/**
	 * Gets the cost to purchase crop
	 * @return
	 */
	public double getPrice() {
		return buyPrice;
	}
	
	public double getSellPrice() {
		return sellPrice;
	}
	
	public String getState() {
		return state;
	}
	
	/**
	 *  State is called when days of crop is 0, which changes state of Crop to Harvest to allow the Crops to be sold
	 */
	public void setState() {
		state = "Harvest";
	}
	
	
	/**
	 *  Returns,days left till harvest, Current State, Crop type, 
	 * @return
	 */
	public String getDetails() {
		String details = type + ":\n" 
	+ " [State] " + state + ",\n" 
	+ " [Buy price] $" + buyPrice + ",\n"
	+ " [Sell price (Only when harvested)] $" + sellPrice + ",\n" 
	+ " [Days till harvest] " + daysToHarvest + ",\n" ;
		
		return details;
	}

	public void alterCropTime(int time) {
		daysToHarvest -= time;
		if (daysToHarvest <= 0) {
			state = "Harvest";
		}
	}
	
	public static void main(String[] args) {
		
		
		//Implemented for testing
		Carrot carrot = new Carrot();
		Avocado avo = new Avocado();
		avo.alterCropTime(2);
		System.out.println(avo.getDaysToHarvest());
		System.out.println(carrot.getDetails());
		
	}
}
