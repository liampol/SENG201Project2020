package MainClassesPackage;
import cropExtend.*;
import supportClasses.*;


public class Crop {
	
	String type;                    // Carrots, Potatos, Capsicum, Broccoli, Cauliflower, Avocado
	double sellPrice;               // Price to sell vegetable
	double buyPrice;                // Price to buy vegetable
	int daysToHarvest;              // Amount of days to harvest
	String state;                   // Plants current state (Sprout or Harvest)
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
	public Crop(String currentVegetable, double sellCost, double buyCost, int harvestTime) {
		
		type = currentVegetable;
		sellPrice = sellCost;
		buyPrice = buyCost;
		daysToHarvest = harvestTime;
		state = "Sprout";
		cropTracker(currentVegetable); // Need to implement some way to keep track of all 
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
	
	public void setState() {
		state = "Harvest";
		
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
		daysToHarvest -= bonus;
	}
	
	public static void main(String[] args) {
		
		
		//Implemented for testing
		Carrot carrot = new Carrot();
		Avocado avo = new Avocado();
		avo.alterCropTime(2);
		System.out.println(avo.getDaysToHarvest());
		
		
		
	}
}
