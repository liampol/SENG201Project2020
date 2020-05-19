package MainClassesPackage;
import animalExtend.*;
import GUIPackage.*;
import cropExtend.*;
import baseutility.*;

/**
 * The animal class
 * 
 * @author Te Wehenga Johnson
 * 
 *
 */
public class Animal {
	
	String name;                // Name of animal
    String type;                // Types will be Cows, Sheep, Pigs
	double price;               // Cost of animal
	double profit;          // Bonus received from each animal
	String healthState;         // Current health state of animal ("Healthy", "Sick", "Die");
	String emotionalState;      // Emotional state of animal ("Happy" "Neutral" or "Sad")
	int healthTracker;          // Tracks the health state of the animal in days where (3+ = "Healthy, 2 = "Sick", 0 = "Die")  
	int emotionTracker;         // Tracks the emotional state of the animal in days where (4+ = "Happy", 3 = "Neutral", 1 = "Sad") 
	
	
	
	public Animal(String newName, String newType, double newPrice, double newBonus, String newHealthState, String newEmotionalState) {
		name = newName;
		type = newType;
		price = newPrice;
		profit = newBonus;
		healthState = newHealthState;
		emotionalState = newEmotionalState;
		healthTracker = 1;  // init as "Healthy"
		emotionTracker = 1; // init as "Happy"
	}
	
	public String getName() {
		return name;
	}
		
	public String getType() {
		return type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getMoneyBonus() {
		return profit;
	}
	
	public String getState() {
		return healthState;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * This method alters the healthState by the amount of days passed in as a parameter that changes the heathTracker,
	 * the states are then changed based on the new healthTracker value,
	 * 
	 * @param change
	 */
	public void alterHealthState(int change) {
		
		healthTracker += change;                 // Alters healthTracker by the amount passed as a parameter
		
		if (healthTracker >= 3) {
			healthState = "Healthy";	
		}else if (healthTracker <= 2 && healthTracker > 0) {
			healthState = "Sick";
		}else {
			healthState = "Die";	
		}
	}
	
	/**
	 * This method alters the emotionalState by the amount of days passed in as a parameter that changes the emotionTracker,
	 * The states are then changed based on the new emotionTracker value,
	 * 
	 * @param change
	 */
	public void alterEmotionalState(int change) {
		
		emotionTracker += change;                 // Alters emotionTracker by the amount passed as a parameter
		
		if (emotionTracker >= 3) {
			emotionalState = "Happy";	
		}else if (emotionTracker <= 2 && emotionTracker > 0) {
			emotionalState = "Neutral";
		}else {
			emotionalState = "Sad";	
		}
	}
	
	public double getWorth() {
		
		double worth = 0; 
		if (emotionalState == "Happy") {
				worth = profit;
		}
		return worth;
	}
	
	public String getDetails() {
		String details = type + ": "
	+ "[Name] " + name + ", "
	+ "[Health State] " + healthState + ", "
	+ "[Emotional State] " + emotionalState + ", "
	+ "[Buy price] $" + price + ", "
	+ "[Money Bonus] $" + profit + ", \n";
		
		return details;

	}
		
	
	public static void main(String[] args) {
		
		//Implemented for testing
		Cow cow = new Cow();
		Cow cow1 = new Cow("Belle");
		Pig pig = new Pig();
		Pig pig1 = new Pig("Sir-Oinks-alot");
		Sheep sheep = new Sheep();
		Sheep sheep1 = new Sheep("Baaabara");
		
		System.out.printf("your income for this Sheep is $%.2f per day ",sheep1.getMoneyBonus());
	}

}
	
	
	
	
