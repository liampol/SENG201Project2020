package MainClassesPackage;
import java.util.ArrayList;
import java.util.Scanner;
import animalExtend.*;
import cropExtend.*;
import GUIPackage.*;

public class Farm {
	
<<<<<<< Updated upstream
	String name;
	String type;
	Farmer currentFarmer;
	ArrayList<Crop> currentCrops;
	ArrayList<Animal> currentAnimals;
	float money;
=======

	private String name;
	private String type;
	private Farmer currentFarmer;
	private ArrayList<Crop> currentCrops;
	private ArrayList<Animal> currentAnimals;
	private static double money;
	private String bonus;
>>>>>>> Stashed changes
	
	public Farm(String farmName, Farmer newFarmer, String farmType) {
		
		name = farmName;
		currentFarmer = newFarmer;
		type = chooseFarmType(farmType);
		currentCrops = new ArrayList<Crop>();
		currentAnimals = new ArrayList<Animal>();
		money = (float) 500.00; 
	}
	
	public Farm(Farmer newFarmer) {
		
<<<<<<< Updated upstream
		name = "Farmer Bob";
=======
		name = newFarmer.getName();
>>>>>>> Stashed changes
		currentFarmer = newFarmer;
		type = chooseFarmType("Money Tree");
		currentCrops = new ArrayList<Crop>();
		currentAnimals = new ArrayList<Animal>();
		money = (float) 500.00; 
	}

	/**
	 * Method used to allocate the bonus associated with the chosen farmType
	 * 
	 * @param farmType
	 * @return
	 */
	public String chooseFarmType(String farmType) {
		if (farmType == "Faster Crop Growth") { // Need to implement crop growth method in Crop class
			return "Faster Crop Growth";
		}else if (farmType == "Happy Animal") { // Need to implement Animal class
			return "Happy Animal";
		}else if (farmType == "Discount Store"){
			return "Discount Store"; // Need to implement Market Class
		}else {
			return "Money Tree"; // Need to implement some type of Income class
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public float getMoney() {
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
	
	public void viewCrops() {
		String returnString = "The current crops you have are:\n";
		for (Crop vegetable: currentCrops) {
			returnString += vegetable.getType();
			returnString += "\n";
		}
		
<<<<<<< Updated upstream
		toString(returnString);
		
	}
	
=======
		
		System.out.println(returnString);
		
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
	
>>>>>>> Stashed changes
	public void viewAnimals() {
		String returnString = "The current animals that are in the farm are:\n";
		for (Animal animal: currentAnimals) {
			returnString += animal.getType();
			returnString += "\n";
		}
		toString(returnString);
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
		Farmer newFarmer = new Farmer();
		Farm newFarm = new Farm(newFarmer) ;
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
		System.out.printf("You have $%.2f money left\n",newFarm.getMoney());  // Print to 2 d.p
		newFarm.viewCrops();
		
		newFarm.removeCrop(carrot2);
		System.out.println(carrot3.getDaysToHarvest());
		newFarm.removeCrop(broc);
		
		newFarm.viewCrops();
		
		
		
		
	}
}
