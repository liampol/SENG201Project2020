package MainClassesPackage;
import java.util.ArrayList;
import java.util.Scanner;
import animalExtend.*;
import cropExtend.*;
import GUIPackage.*;

public class Farm {
	

	private String name;
	private String type;
	private Farmer currentFarmer;
	private ArrayList<Crop> currentCrops;
	private ArrayList<Animal> currentAnimals;
	private static double money;
	private String bonus;
	
	public Farm(String farmName, Farmer newFarmer, String farmType) {
		
		name = farmName;
		currentFarmer = newFarmer;
		type = farmType;
		currentCrops = new ArrayList<Crop>();
		currentAnimals = new ArrayList<Animal>();
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
	 * Method used to allocate the bonus associated with the chosen farmType
	 * 
	 * @param farmType
	 * @return
	 */
	public void applyFarmBonus(String newBonus) {
		bonus = newBonus;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void addCrop(Crop vegetable) {
		currentCrops.add(vegetable);
	}
	
	public boolean removeCrop(Crop vegetable) {
		if (currentCrops.contains(vegetable)) {
			currentCrops.remove(vegetable);
			return true;
			}
		else
			return false;
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
	
	public static void viewWallet() {
		System.out.printf("Current cash balance: $%.2f\n", money);
	}
	
	public void viewAnimals() {
		String returnString = "The current animals that are in the farm are:\n";
		for (Animal animal: currentAnimals) {
			returnString += animal.getType();
			returnString += "\n";
		}
		toString(returnString);
	}
	
	public String viewAnimalsStatus() {
		String status = "";
		if (currentAnimals.isEmpty()) {
			status = "Sorry but you have no Animals to view";
		}else {
			for (Animal animal: currentAnimals) {
				status += animal.getName() + "the " + animal.getType() + "is " + animal.getState() + "\n";
			}
		}
		return status;
	}
	
	
	
	public void viewFarmStatus() {
		viewCrops();
		viewWallet();
	}

	public static void toString(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		
		// Implemented for testing
		Farmer newFarmer = new Farmer("Johnson", 3, "Male Farmer");
		Farm newFarm = new Farm("Johnsons", newFarmer, "Faster Crop Growth") ;
		newFarm.viewFarmStatus();
		Carrot carrot = new Carrot();
		Carrot carrot1 = new Carrot();
		Carrot carrot2 = new Carrot();
		Carrot carrot3 = new Carrot();
		Broccoli broc = new Broccoli();
		Potato potato = new Potato();
		
		newFarm.addCrop(carrot);
		newFarm.addCrop(carrot1);
		newFarm.addCrop(carrot2);
		newFarm.addCrop(carrot3);
		newFarm.addCrop(broc);
		newFarm.addCrop(potato);
		System.out.printf("You have $%.2f left\n", newFarm.getMoney());  // Print to 2 d.p
		newFarm.viewCrops();
		
		newFarm.removeCrop(carrot2);
		System.out.println(carrot3.getDaysToHarvest());
		newFarm.removeCrop(broc);
		newFarm.viewCrops();
		newFarm.viewAnimalsStatus();
		newFarm.viewCropsStatus();
		
		
		
		
	}
}
