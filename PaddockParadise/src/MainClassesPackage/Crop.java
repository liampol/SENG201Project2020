package MainClassesPackage;
import cropExtend.*;


public class Crop {
	
	String type;                   // Carrots, Potatos, Capsicum, Broccoli, Cauliflower, Avocado
	float sellPrice;               // Price to sell vegetable
	float buyPrice;                // Price to buy vegetable
	int daysToHarvest;           // Amount of days to harvest
	boolean farmBonus;
	int amountCarrots;
	int amountCapsicum;
	int amountPotato;
	int amountBroccoli;
	int amountAvocado;
	int amountCauliflower;
	
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
		cropTracker(currentVegetable); // Need to implement some way to keep track of all 
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
	public void applyFarmBonus() {
		farmBonus = true;
	}
	
	/**
	 * cropTracker increases the tracking value of the corresponding vegetable
	 * @param vegetable
	 */
	public void cropTracker(String vegetable) {
		if (vegetable == "Carrot") {
			amountCarrots ++;
		}else if (vegetable == "Capsicum") {
			amountCapsicum ++;
		}else if (vegetable == "Avocado"){
			amountAvocado ++;
		}else if (vegetable == "Broccoli") {
			amountBroccoli ++;
		}else if (vegetable == "Cauliflower") {
			amountCauliflower ++;
		}else {
			amountPotato ++;
		}
		
	}
	public void alterCropTime(int bonus) {
		daysToHarvest = (daysToHarvest*bonus);
	}
	
	public static void main(String[] args) {
		
		
		//Implemented for testing
		Carrot carrot = new Carrot();
		
		
		
	}
}
