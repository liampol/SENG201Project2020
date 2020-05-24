package MainClassesPackage;
import cropExtend.*;


/**
 * <h2>Crop</h2>
 * 
 * <p> The animal class models a crop. It has a type (name), sell price, buy price, number of days till harvestable.
 * The Market class creates instances of Crop subclasses - Avacado, Broccoli, Capsicum, Carrot, Cauliflower, Potato
 * 
 * @author Te Wehenga Johnson
 * @see Market
 * @see Avacado
 * @see Broccoli
 * @see Capsicum
 * @see Carrot
 * @see Cauliflower
 * @see Potato
 */
public class Crop {
	
	String type;                    // Carrots, Potatos, Capsicum, Broccoli, Cauliflower, Avocado
	private double sellPrice;               // Price to sell vegetable
	private double buyPrice;                // Price to buy vegetable
	private int daysToHarvest;              // Amount of days to harvest
	private String state;                   // Plants current state ("Harvest", "Sprout") 
	private int stateTracker;               
	private boolean farmBonus;
	
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
	
	/**
	 * Gets the money returned when a crop is harvested and solf
	 * @return
	 */
	public double getSellPrice() {
		return sellPrice;
	}
	
	/**
	 * Gets the state of the crop
	 * @return
	 */
	public String getState() {
		return state;
	}
	
	/**
	 *  setState is called when days of crop is 0, which changes state of Crop to Harvest to allow the Crops to be sold
	 *  @return
	 */
	public void setState() {
		state = "Harvest";
	}
	
	
	/**
	 *  Returns days left till harvest, Current State, Crop type, 
	 * @return
	 */
	public String getDetails() {
		String details = type + ":" 
	+ " [State] " + state + ", " 
	+ " [Buy price] $" + buyPrice
	+ " [Sell price (Only when harvested)] $" + sellPrice + ", " 
	+ " [Days till harvest] " + daysToHarvest + ", \n" ;
		
		return details;
	}
	
	/**
	 * Subtracts a number of days away from the time till harvest of a crop
	 * @param time
	 */
	public void alterCropTime(int time) {
		daysToHarvest -= time;
		if (daysToHarvest <= 0) {
			state = "Harvest";
		}
	}

}
