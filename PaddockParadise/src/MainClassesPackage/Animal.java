package MainClassesPackage;
import animalExtend.*;
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
	String emotionalState;      // Emotional state of animal ("Happy" "Saudade" or "Sad")
	int healthTracker;          // Tracks the health state of the animal in days where (3+ = "Healthy, 2 = "Sick", 0 = "Dead")  
	int emotionTracker;         // Tracks the emotional state of the animal in days where (3+ = "Happy", 2 = "Neutral", 0 = "Sad") 
	
	
	
	public Animal(String newName, String newType, double newPrice, double newBonus, String newHealthState, String newEmotionalState) {
		name = newName;
		type = newType;
		price = newPrice;
		profit = newBonus;
		healthState = newHealthState;
		emotionalState = newEmotionalState;
		healthTracker = 3;  // init as "Healthy"
		emotionTracker = 3; // init as "Happy"
	}
	/**
	 * Returns the name of the animal
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns the type of animal
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Returns the cost of the animal
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	public void addHealthBonus() {
		healthTracker += 2;
		emotionTracker += 2;
	}
	
	/**
	 * Returns the profit from the animal based on "Health State"
	 * @return
	 */
	public double getMoneyBonus() {
		double currentProfit = getWorth();
		return currentProfit;
	}
	
	
	public String getHealthState() {
		return healthState;
}

	public void setEmotionalState(String emotionalState) {
		this.emotionalState = emotionalState;
	}
	
	public String getEmotionalState() {
		return emotionalState;
	}
	
	public void setState(String healthState) {
		this.healthState = healthState;
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
			healthState = "Dead";	
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
		}else if (emotionTracker > 0 && emotionTracker <= 2) {
			emotionalState = "Saudade";
		}else {
			emotionalState = "Sad";	
		}
	}
	/**
	 * This method returns the amount of profit received bassed on the emotionalState of the animal
	 * @return
	 */
	public double getWorth() {
		
		double worth = 0; 
		if (emotionalState == "Happy") {
				worth = profit;
		}else if ( emotionalState == "Saudade") {
			worth = profit - (profit*0.40);    // 40% less profit
		}else {
			worth = 0;
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
//		Cow cow = new Cow();
//		Cow cow1 = new Cow("Belle");
//		Pig pig = new Pig();
//		Pig pig1 = new Pig("Sir-Oinks-alot");
//		Sheep sheep = new Sheep();
//		Sheep sheep1 = new Sheep("Baaabara");
//		
//		System.out.printf("your income for this Sheep is $%.2f per day ",sheep1.getMoneyBonus());
	}

}
	
	
	
	
