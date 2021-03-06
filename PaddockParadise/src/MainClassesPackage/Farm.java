package MainClassesPackage;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import cropExtend.*;
import animalExtend.*;
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
	
	private int cropLimit;
	private int daysBeingTidy;
	private int daysBeingUnkept;
	private String state;
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
		state = "Tidy";
		daysBeingTidy = 1;
		cropLimit = 3;
	}
	
	public Farm(Farmer newFarmer) {
		
		name = newFarmer.getName();
		currentFarmer = newFarmer;
		type = "Money Tree";
		currentCrops = new ArrayList<Crop>();
		currentAnimals = new ArrayList<Animal>();
		money =  500.00; 
		state = "Tidy";
	}
	
	/**
	 * retuns the number of crops available to purchase/grow currently;
	 * @return
	 */
	public int getCropLimit() {
		return cropLimit;
	}

	public void setCropLimit(int cropLimit) {
		this.cropLimit = cropLimit; 
	}
	
	public void setDaysBeingTidy(int days) {
		daysBeingTidy = days;
	} 
	
	public void setDaysBeingUnkept(int days) {
		daysBeingUnkept = days;
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
	
	public void setType(String newType) {
		type = newType;
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
	
	public ArrayList<Supplies> getCurrentSupplies() {
		return currentSupplies;
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
	
	public ArrayList<Animal> getAnimals() {
		return currentAnimals;
	}
	
	/**
	 * returns the state of the farm
	 * @return String
	 */
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
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
			status = "Sorry but you have no crops to view,";
		}else {
			status += "The current crops that are in the farm are:";
			for (int i = 0; i < currentCrops.size(); i++) {
				status += "\n[" + (i+1) + "] " + currentCrops.get(i).getType() + " - Days to harvest: " 
						+ currentCrops.get(i).getDaysToHarvest() + ",";
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
		return "Current cash balance: $" + money + ",";
	}
	
	/**
	 * returns a string representation of what animals the farm currently has
	 * @return
	 */
	public String viewAnimals() {
		String returnString = "";
		if (currentAnimals.isEmpty()) {
			return "Sorry but you have no animals to view,";
		}else {
		
		returnString = "The current animals that are in the farm are:";
		for (int i = 0; i < currentAnimals.size(); i++) {
			String emotionString = (currentAnimals.get(i).getEmotionalState() == "Sad") ? "" :
								" (" + daysLeftOfEmotionState(currentAnimals.get(i)) + " days left)";
			returnString += "\n[" +  (i+1) + "] " + currentAnimals.get(i).getName() + " the "
						+  currentAnimals.get(i).getType() 
						+ " - Emotional State: " + currentAnimals.get(i).getEmotionalState() 
						+ emotionString
						+ ", Health State: " + currentAnimals.get(i).getHealthState()
						+ " (" + daysLeftOfHealthState(currentAnimals.get(i)) + " days left)"
						+ ",";
		}
		return returnString;
		}
	}
	
	private int daysLeftOfEmotionState(Animal animal) {
		if (animal.getEmotionTracker() >= 3) {
			return (animal.getEmotionTracker() - 3);
		} else if (animal.getEmotionTracker() <= 2 && animal.getEmotionTracker() > 0) {
			return animal.getEmotionTracker() - 1;
		} else {
			return (int) 10;
		}
	}
	
	private int daysLeftOfHealthState(Animal animal) {
		if (animal.getHealthTracker() >= 3) {
			return (animal.getHealthTracker() - 3);
		} else if (animal.getHealthTracker() <= 2 && animal.getHealthTracker() > 0) {
			return animal.getHealthTracker() - 1;
		} else {
			return -1;
		}
	}
	
	private void growAnimals(String state) {
		
		for (Animal animal : currentAnimals) {
			if (state.equals("Unkept")) {
				animal.alterEmotionalState(-2);
				animal.alterHealthState(-1);
			} else {
				animal.alterEmotionalState(-1);
				animal.alterHealthState(-1);
			}
		}
	}
	
	private void getProfits() {
		
		for (Animal income : currentAnimals) {
			money += income.getWorth();
		}
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
			status = "Sorry but you have no 'Supplies' to view,";
		}else {
			status += "The current supplies that are in the farm are:";
			for (int i = 0; i < currentSupplies.size(); i++) {
				status += "\n["+(i+1)+"] " + currentSupplies.get(i).getName() 
						+ " - " + currentSupplies.get(i).getBonus() + ",";
			}
		}
		return status;
	}
	
	public void runOccurence(String occurence) {
		
		boolean valid = false;
		
		switch(occurence) {
			case "None":
				valid = true;
				break;
			case "Drought":
				try {
					loseCropsOccurence();
				} catch(IllegalArgumentException noCrops) {
					// If no crops, bound it 0 
				}
				valid = true;
				break;
			case "Broken Fence":
				try {
				loseAnimalsOccurence();
				} catch (IllegalArgumentException noAnimals) {
					// If no animals, bound is 0
				}
				valid = true;
				break;
			case "County Fair":
				getCountyFairBonus();
				valid = true;
				break;
			case "Thief":
				implementThiefOccurrence();
				valid = true;
				break;
			default:
				valid = true;
				break;
		}while(!valid);	
	}
	
	private void loseCropsOccurence() {
		
		int lost = 0;
		int amountLost = 0;
		Random cropsLost = new Random();
		amountLost = currentCrops.size() ;
		
		System.out.println("The wells have all dried up and the crops are thirsty!");
		
		//Choosing random integer based on the size of currentCrops
		lost = cropsLost.nextInt(amountLost);
		
		//Init amount of crops to be removed
		amountLost = lost;
		
		System.out.println("You lost " + (lost+1) + " of your 'Crops!',\n" );
		
		//Iterates through, removing crop from currentCrops using amountLost as index
		//    Also gets the type of Crop removed and prints message of what was removed
		while (amountLost >=0) {
			Crop veg = currentCrops.get(amountLost);
			System.out.println("Crop lost: " + veg.getType());
			currentCrops.remove(amountLost);
			amountLost -= 1;
		}
		
		// Displays the Crops left
		System.out.println(viewCrops());

		
	}
	
	private void loseAnimalsOccurence() {
		
		// Initialise
		int counter = 0;
		int gone = 0;
		int amountOfAnimals = currentAnimals.size();
		Random animalsLost = new Random();
		
		// Chooses a random number based on the size of currentAnimals and prints message
		gone = animalsLost.nextInt(amountOfAnimals);
		System.out.println("Oh NO!!");
		System.out.println("The animals have broken the gate and " + (gone+1) + " are gone!!");
		System.out.println("The rest of the animals seem upset!");

		counter = gone;
		System.out.println("Farewell to this list of animals gone: ");
		
		while (counter >= 0) {
			Animal animal = currentAnimals.get(counter);
			System.out.println(animal.getName());
			currentAnimals.remove(animal);
			counter -= 1;	
		}
		//Decrease the emotional State and Health State of the animal
		growAnimals("Tidy");
		
		System.out.println(viewAnimals());
	}
	
	
	private void getCountyFairBonus() {
		
		double bonus = 0;
		
		// 2xthe farms worth
		bonus = (2*bonus);
		System.out.println("Congratulations Your farm has just won first prize at the 'County Fair'\n");
		System.out.println("Your prize is " + bonus);
		money += bonus;
		System.out.println("Your prize has been adding to your wallet!");
	}
	
	public double getFarmWorth() {
		
		
		double bonus = 0;
		
		for (Animal animal : currentAnimals) {
			bonus += animal.getWorth();
		}
		
		for (Crop vegie : currentCrops) {
			bonus += vegie.getSellPrice();
		}
		return bonus;
	}
	
	private void implementThiefOccurrence() {
		
		double stolenAmount = getFarmWorth();
		stolenAmount = stolenAmount * 0.4;
		// Only performs occurrence if the farm has enough to lose 
		if (money > stolenAmount){
			money -= stolenAmount;
			System.out.println("Oh No!!");
			System.out.println("A thief has broken in and stolen $" + stolenAmount + "!\n" );
		}else {
			 // Do nothing
		}
	}
	
	public void startNewDay() {
		if (state.equals("Tidy")) {
			daysBeingTidy += 1;
		} else {
			daysBeingUnkept += 1;
		}
		if (daysBeingTidy == 4) {
			daysBeingTidy = 1;
			state = "Unkept";
		} 
		if (daysBeingUnkept > 1) {
			for (int i = 0; i < 2; i++) {
				if (cropLimit > 3) {
					cropLimit -= 1;
				}
			}
		}
		growCrops();
		growAnimals(this.state);
		checkForDeadAnimals();
		getProfits();
	}
	
	/**
	 * Returns the status of 'Crops', 'Animals' and Supplies
	 *  as well as the amount of money the farm has
	 * @return
	 */
	public String viewFarmStatus() {
		return "Farmer: " + currentFarmer.getName() + ",\n"
				+ "Money: " + viewWallet() + "\n"
				+ "Crops: " + viewCropsStatus() + "\n" 
				+ "Animals: " + viewAnimals() + "\n"
				+ "Supplies: " + viewSupplies();
	}
	
	public void checkForDeadAnimals() {
		
		ArrayList<Animal> deadAnimals = new ArrayList<Animal>();
		for (Animal corpse : currentAnimals) {
			if (corpse.getHealthState().equals("Dead")){
					System.out.println("Rest In Peace " + corpse.getName());
					deadAnimals.add(corpse);
			}
		}
		currentAnimals.removeAll(deadAnimals);
	}
	
	
	private static void toString(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		
		// Implemented for testing
		Farmer newFarmer = new Farmer("Johnson", 3, "Male Farmer");
		Farm newFarm = new Farm("Johnsons", newFarmer, "Faster Crop Growth") ;
		Cow moo = new Cow("Truce");
		Cow moo1 = new Cow("Trail");
		Cow moo2 = new Cow("trace");
		Cow moo3 = new Cow("Trump");
		Cow moo4 = new Cow("Boris");
		Cow moo5 = new Cow("Bettsy");
		Sheep barbra = new Sheep("Benny");
		Sheep barbra1 = new Sheep("Bootsie");
		Sheep barbra2 = new Sheep("Bail");
		Sheep barbra3 = new Sheep("Hoops");
		newFarm.addAnimal(moo);
		newFarm.addAnimal(barbra);
		newFarm.addAnimal(moo);
		newFarm.addAnimal(moo1);
		newFarm.addAnimal(moo2);
		newFarm.addAnimal(moo3);
		newFarm.addAnimal(moo4);
		newFarm.addAnimal(moo5);
		newFarm.addAnimal(barbra1);
		newFarm.addAnimal(barbra2);
		newFarm.addAnimal(barbra3);
		
		System.out.println(newFarm.viewAnimals());

		
//		newFarm.viewAnimalStatus();
//		moo.alterHealthState(-3);
//		moo.alterEmotionalState(2);
//		newFarm.viewAnimalStatus();
//		newFarm.checkForDeadAnimals();
//		newFarm.viewAnimalStatus();
		
		System.out.println(newFarm.viewAnimals());
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
		System.out.println(newFarm.viewCrops());
		
		// Test runOccurences()
		newFarm.runOccurence("Drought");
		System.out.println(newFarm.viewCrops());
		newFarm.runOccurence("Broken Fence");
		System.out.println(newFarm.viewAnimals());
		
		
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
	
		


