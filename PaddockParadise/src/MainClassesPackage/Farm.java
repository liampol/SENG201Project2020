package MainClassesPackage;
import java.util.ArrayList;
import java.util.Scanner;
import animalExtend.*;
import cropExtend.*;
import GUIPackage.*;

/**
 * The Farm class that is called from the PaddockParadiseManager to initialise a farm, 
 * The Attributes of the Farm:
 *        -name            (String)
 *        -type            (String)
 *        -currentFarmer   (Farmer)
 *        -currentCrops    (ArrayList<Crops>)
 *        -currentAnimals  (ArrayList<Animal>)
 *        -currentSupplies (ArrayList<Supplies>)   
 *        -money           (double)
 *
 * @author Te wehenga Johnson
 *
 */
public class Farm {
	

	private String name;
	private String type;
	private Farmer currentFarmer;
	private ArrayList<Crop> currentCrops;
	private ArrayList<Animal> currentAnimals;
	private ArrayList<Supplies> currentSupplies;
	private static double money;

	
	public Farm(String farmName, Farmer newFarmer, String farmType) {
		
		name = farmName;
		currentFarmer = newFarmer;
		type = farmType;
		currentCrops = new ArrayList<Crop>();
		currentAnimals = new ArrayList<Animal>();
		currentSupplies =new ArrayList<Supplies>();
		money = 500.00; 
	}
	
	public Farm(Farmer newFarmer) {
		
		name = newFarmer.getName();
		currentFarmer = newFarmer;
		type = "Money Tree";
		currentCrops = new ArrayList<Crop>();
		currentAnimals = new ArrayList<Animal>();
		money =  500.00; 
	}

	/**
	 * retuns the name of the Farm
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * returns the Type of farm
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * returns the amount of money the farm currently has
	 * @return
	 */
	public double getMoney() {
		return money;
	}
	
	/**
	 * Adds the amount of profit from selling crops to Farms money 
	 * @param profit
	 */
	public void addToWallet(double profit) {
		money += profit;
	}
	
	/**
	 * adds crop to list of crops
	 * @param vegetable
	 */
	public void addCrop(Crop vegetable) {
		currentCrops.add(vegetable);
	}
	
	/**
	 * removes a crop from the crop list
	 * @param vegetable
	 * @return
	 */
	public boolean removeCrop(Crop vegetable) {
		if (currentCrops.contains(vegetable)) {
			currentCrops.remove(vegetable);
			return true;
			}
		else
			return false;
	}
	
	/**
	 * Adds supply to list of supplies
	 * @param item
	 */
	public void addSupply(Supplies item) {
		currentSupplies.add(item);
	}
	
	/**
	 * removes a supply from list of supplies
	 * @param item
	 */
	public void removeSupply(Supplies item) {
		currentSupplies.remove(item);
	}
	
	/**
	 * adds animal to list of animals
	 * @param animal
	 */
	public void addAnimal(Animal animal) {
		currentAnimals.add(animal);
	}
	
	/**
	 *returns the ArrayList of crops the farm has
	 * @return
	 */
	public ArrayList<Crop> getCrops() {
		return currentCrops;
	}
	
	public String viewCrops() {
		String returnString = "The current crops you have are:\n";
		int numCarrots = 0;
		int numBroccoli = 0;
		int numCapsicum = 0;
		int numPotato = 0;
		int numAvocado = 0;
		int numCauliflower = 0;
		
		
		for (Crop vegetable: currentCrops) {
			if (vegetable.getType() == "Carrot") {
				numCarrots ++;
				
			}else if (vegetable.getType() == "Cauliflower"){
				numCauliflower ++;
				
			}else if (vegetable.getType() == "Capsicum"){
				numCapsicum ++;
				
			}else if (vegetable.getType() == "Potato"){
				numPotato ++;
				
			}else if (vegetable.getType() == "Broccoli"){
				numBroccoli ++;
				
			}else if(vegetable.getType() == "Avocado"){
				numAvocado ++;
				}
			returnString = ("Carrots: " + numCarrots + "\n" 
			        + "Capsicum: " + numCapsicum + "\n" 
					+ "Potatoes: " + numPotato + "\n" 
			        + "Cauliflower: " + numCauliflower + "\n" 
					+ "Avocado: " + numAvocado + "\n" 
			        + "Broccoli: " + numBroccoli + "\n") ;
			}
		return returnString;
		
	}
	
	/**
	 * returns a String representation of the status of the crops
	 * @return
	 */
	public String viewCropsStatus() {
		String status = "";
		if (currentCrops.isEmpty()) {
			status = "Sorry but you have no crops to view";
		}else {
			for (Crop vegetable: currentCrops) {
				status += vegetable.getType() + " Days to harvest: " + vegetable.getDaysToHarvest() + "\n";
			}
		}
		return status;
	}
	
	public void growCrops() {
		
		for (Crop vegetable : currentCrops) {
			if (vegetable.getState() == "Sprout"){
			vegetable.alterCropTime(1);	
			}
		}
	}
	
	/**
	 * returns a string representation of the amount of money the farm current has
	 * @return
	 */
	public String viewWallet() {
		return "Current cash balance: $" + money + ",\n";
	}
	
	/**
	 * returns a string representation of what animals the farm currently has
	 * @return
	 */
	public String viewAnimals() {
		String returnString = "";
		if (currentAnimals.isEmpty()) {
			return "Sorry but you have no animals to view";
		}else {
		returnString = "The current animals that are in the farm are:\n";
		for (Animal animal: currentAnimals) {
			returnString += animal.getType();
			returnString += "\n";
		}
	}
		return returnString;
	}
	
	/**
	 * returns the current state the animals are in:
	 * -Emotional
	 * -Health
	 * @return
	 */
	public String getAnimalsStatus() {
		String status = "";
		if (currentAnimals.isEmpty()) {
			status = "Sorry but you have no Animals to view";
		}else {
			for (Animal animal: currentAnimals) {
				status += animal.getName() 
						+ " the " + animal.getType() 
						+ " is " + animal.getHealthState() 
						+ " and feeling " + animal.getEmotionalState() + "\n";
			}
		}
		return status;
	}
	
	public void viewAnimalStatus() {
		
		String message = getAnimalsStatus();
		toString(message);
	}
	
	/**
	 * Returns a string of Supplies that the Farm owns
	 * @return
	 */
	public String viewSupplies() {
		String status = "";
		if (currentSupplies.isEmpty()) {
			status = "Sorry but you have no 'Supplies' to view";
		}else {
			for (Supplies supply: currentSupplies) {
				status += supply.getName() + ": " + supply.getBonus() + ",\n";
			}
		}
		return status;
	}
	
	/**
	 * Returns the status of 'Crops', 'Animals' and Supplies
	 *  as well as the amount of money the farm has
	 * @return
	 */
	public String viewFarmStatus() {
		return "Crops: " + viewCropsStatus() + ",\n" 
				+ "Animals: " + viewAnimals() + ",\n"
				+ "Money: " + viewWallet() + ",\n"
				+ "Supplies: " + viewSupplies() + ",\n";
	}
	
	public void checkForDeadAnimals() {
		
		for (Animal corpse : currentAnimals) {
			if (corpse.getHealthState().equals("Dead")){
					System.out.println("Rest In Peace " + corpse.getName());
					currentAnimals.remove(corpse);
			}
		}
	}
	
	public void checkForDeadCrops() {
		
	}
	
	public void startNewDay() {
		
	}
	
	private static void toString(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		
		// Implemented for testing
		Farmer newFarmer = new Farmer("Johnson", 3, "Male Farmer");
		Farm newFarm = new Farm("Johnsons", newFarmer, "Faster Crop Growth") ;
		Cow moo = new Cow();
		Sheep barbra = new Sheep();
		newFarm.addAnimal(moo);
		newFarm.addAnimal(barbra);
		
		newFarm.viewAnimalStatus();
		moo.alterHealthState(-3);
		moo.alterEmotionalState(2);
		newFarm.viewAnimalStatus();
		newFarm.checkForDeadAnimals();
		newFarm.viewAnimalStatus();
		
//		newFarm.viewFarmStatus();
//		Carrot carrot = new Carrot();
//		Carrot carrot1 = new Carrot();
//		Carrot carrot2 = new Carrot();
//		Carrot carrot3 = new Carrot();
//		Broccoli broc = new Broccoli();
//		Potato potato = new Potato();
//		
//		newFarm.addCrop(carrot);
//		newFarm.addCrop(carrot1);
//		newFarm.addCrop(carrot2);
//		newFarm.addCrop(carrot3);
//		newFarm.addCrop(broc);
//		newFarm.addCrop(potato);
//		System.out.printf("You have $%.2f left\n", newFarm.getMoney());  // Print to 2 d.p
//		newFarm.viewCrops();
//		
//		newFarm.removeCrop(carrot2);
//		System.out.println(carrot3.getDaysToHarvest());
//		newFarm.removeCrop(broc);
//		newFarm.viewCrops();
//		newFarm.viewAnimalsStatus();
//		newFarm.viewCropsStatus();
//		
		
		
		
	}
}
