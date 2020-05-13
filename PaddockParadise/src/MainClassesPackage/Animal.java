package MainClassesPackage;
import animalExtend.*;
import GUIPackage.*;
import cropExtend.*;
import baseutility.*;

/**
 * 
 * @author Te Wehenga Johnson
 * @author Liam Pol
 *
 */
public class Animal {
	
	String name;               // Name of animal
        String type;               // Types will be Cows, Sheep, Pigs
	float price;               // Cost of animal
	float moneyBonus;          // Bonus received from each animal
	String healthState;        // Current health state of animal
	String emotionalState;     // Emotional state of animal
	
	
	
	public Animal(String newName, String newType, float newPrice, float newBonus, String newHealthState, String newEmotionalState) {
		name = newName;
		type = newType;
		price = newPrice;
		moneyBonus = newBonus;
		healthState = newHealthState;
		emotionalState = newEmotionalState;
	}
	
	public String getName() {
		return name;
	}
		
	public String getType() {
		return type;
	}
	
	public float getPrice() {
		return price;
	}
	
	public float getMoneyBonus() {
		return moneyBonus;
	}
	
	public String getState() {
		return healthState;
	}
	
	//private void toString() {
		
	
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
	
	
	
	
