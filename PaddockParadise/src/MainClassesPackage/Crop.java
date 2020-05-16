package MainClassesPackage;
import cropExtend.*;


public class Crop {
	
	String type;                   // Carrots, Potatos, Capsicum, Broccoli, Cauliflower, Avocado
	float sellPrice;               // Price to sell vegetable
	float buyPrice;                // Price to buy vegetable
	int daysToHarvest;           // Amount of days to harvest
	boolean farmBonus;
	
	/**
	 * Constructor of Crop with parameters passed in from the class of vegetable being created 
	 * @param currentVegetable
	 * @param sellCost
	 * @param buyCost
	 * @param harvestTime
	 */
	public Crop(String currentVegetable, float sellCost, float buyCost, int harvestTime) {
		
		type = currentVegetable;
		sellPrice = sellCost;
		buyPrice = buyCost;
		
		if (farmBonus == true) {
			daysToHarvest -= harvestTime%2;   // Applies a 20% less time to grow to all crops if farmBonus is true
		}else {
			daysToHarvest = harvestTime;
		}
		
		daysToHarvest = harvestTime;
<<<<<<< Updated upstream
		cropTracker(currentVegetable); // Need to implement some way to keep track of all 
=======
		state = "Sprout";
>>>>>>> Stashed changes
	}
	
	/**
	 * Returns the crop vegetable type
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	public int getDaysToHarvest() {
		return daysToHarvest;
	}
	/**
	 * Method used to confirm if farmBonus has been applied
	 */
<<<<<<< Updated upstream
	public void applyFarmBonus() {
		farmBonus = true;
=======
	public double getPrice() {
		return buyPrice;
	}
	
	public double getSellPrice() {
		return sellPrice;
	}
	
	public String getState() {
		return state;
	}
	
	// When state is called when days of crop is 0, which changes state of Crop to Harvest to allow the Crops to be sold
	public void setState() {
		state = "Harvest";
>>>>>>> Stashed changes
	}
	
	// Returns,days left till harvest, Current State, Crop type, 
	public String getDetails() {
		String details = type + ": " 
	+ "[State] " + state + ", " 
	+ "[Buy price] $" + buyPrice +", "
	+ "[Sell price (Only when harvested)] $" + sellPrice + ", " 
	+ "[Days till harvest] " + daysToHarvest+ ", \n" ;
		
		return details;
		//System.out.println(details);
	}

	public void alterCropTime(int bonus) {
		daysToHarvest = (daysToHarvest*bonus);
	}
	
	public static void main(String[] args) {
		
		
		//Implemented for testing
		Carrot carrot = new Carrot();
<<<<<<< Updated upstream
=======
		Avocado avo = new Avocado();
		avo.alterCropTime(2);
		System.out.println(avo.getDaysToHarvest());
		carrot.getDetails();
>>>>>>> Stashed changes
		
		
		
	}
}
