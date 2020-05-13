package MainClassesPackage;
import java.util.ArrayList;
public class Farm {
	
	String name;
	String type;
	Farmer currentFarmer;
	ArrayList<Crop> currentCrops;
	ArrayList<Animal> currentAnimals;
	float money;
	
	public Farm(String farmName, Farmer newFarmer, String farmType) {
		
		name = farmName;
		currentFarmer = newFarmer;
		type = chooseFarmType(farmType);
		currentCrops = new ArrayList<Crop>();
		currentAnimals = new ArrayList<Animal>();
		money = (float) 500.00; 
	}
	
	public Farm(Farmer newFarmer) {
		
		name = "Farmer Bob";
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
		
		toString(returnString);
		
	}

	public static void toString(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		
		// Implemented for testing
		Farmer newFarmer = new Farmer("Johnson", 3, "Male Farmer");
		Farm newFarm = new Farm("Johnsons", newFarmer, "Faster Crop Growth") ;
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
