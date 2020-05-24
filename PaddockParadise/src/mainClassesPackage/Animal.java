package mainClassesPackage;
import animalExtend.*;
import baseUtility.*;

/**
 * <h2>Animal</h2>
 * 
 * <p> The animal class models a farm animal. It has a name,type, price, bonus, emotional state, and health state. The Market
 * class creates instances of Animal subclasses - Cow, Pig, Sheep.
 * 
 * @author Te Wehenga Johnson
 * @see Market
 * @see Cow
 * @see Pig
 * @see Sheep
 */
public class Animal {
	private String name;                // Name of animal
    private String type;                // Types will be Cows, Sheep, Pigs
	private double price;               // Cost of animal
	private double profit;          	// Bonus received from each animal
	private String healthState;         // Current health state of animal ("Healthy", "Sick", "Die");
	private String emotionalState;      // Emotional state of animal ("Happy" "Saudade" or "Sad")
	private int healthTracker;          // Tracks the health state of the animal in days where (3+ = "Healthy, 2 = "Sick", 0 = "Dead")  
	private int emotionTracker;         // Tracks the emotional state of the animal in days where (3+ = "Happy", 2 = "Neutral", 0 = "Sad") 
	
	
	
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
	 * @return integer value corresponding to emotional state of animal
	 */
	public int getEmotionTracker() {
		return this.emotionTracker;
	}
	
	/** 
	 * @return integer value corresponding to health state of animal
	 */
	public int getHealthTracker() {
		return this.healthTracker;
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
	
	/**
	 * Adds a emotion bonus to the animal
	 * 
	 */
	public void addEmotionBonus() {
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
	
	/**
	 * Returns the health state of the animal
	 * @return
	 */
	public String getHealthState() {
		return healthState;
	}

	/**
	 * Sets emotional state of the animal
	 * @param emotionalState value to set emotional state to
	 */
	public void setEmotionalState(String emotionalState) {
		this.emotionalState = emotionalState;
	}
	
	/** 
	 * Gets emotional state of the animal
	 * @return 
	 */
	public String getEmotionalState() {
		return emotionalState;
	}
	
	/**
	 * Sets the health state of the animal
	 * @param healthState
	 */
	public void setState(String healthState) {
		this.healthState = healthState;
	}
	
	/**
	 * Sets the name of the animal
	 * @param newName
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Alters the healthState by the amount of days passed in as a parameter that changes the heathTracker,
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
	 * Alters the emotionalState by the amount of days passed in as a parameter that changes the emotionTracker,
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
	 * Returns the amount of profit received based on the emotionalState of the animal
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
	
	/**
	 * Gets the details of the animal as a string
	 * @return details of the animal
	 */
	public String getDetails() {
		String details = type + ": "
	+ "[Name] " + name + ", "
	+ "[Health State] " + healthState + ", "
	+ "[Emotional State] " + emotionalState + ", "
	+ "[Buy price] $" + price + ", "
	+ "[Money Bonus] $" + profit + ", \n";
		
		return details;

	}

}
	
	
	
	
