package Actions;

import MainClassesPackage.Animal;
import MainClassesPackage.PaddockParadiseManager;
import MainClassesPackage.Supplies;

public class FeedAnimals extends Action {

	private Animal animalToFeed;
	private Supplies foodToUse;
	
	/*
	 * performActoin in PaddockParidiseManager will need to contain error handling for if there is
	 * no supplies which are food items.
	 * 
	 */
	
	public FeedAnimals(PaddockParadiseManager incoming, Animal animalToFeed, Supplies foodToUse) {
		super(incoming);
		this.animalToFeed = animalToFeed;
		this.foodToUse = foodToUse;
	}
	
	@Override
	public void performAction() {
		if (actionsAvailable()) {
			switch (foodToUse.getName()) {
			case "Hay":
				animalToFeed.alterEmotionalState(1);
				break;
			case "Grains":
				animalToFeed.alterHealthState(2);
				break;
			case "Vitamins":
				animalToFeed.alterHealthState(3);
				animalToFeed.alterEmotionalState(3);
				break;
			} 
			System.out.println("You feed " + animalToFeed.getName() + " the " + animalToFeed.getType()
								+ "!\n");
			System.out.println(animalToFeed.getName() + " is looking much healther!\n");
			System.out.println("The state of " + animalToFeed.getName() + " is now - Emotional State: " 
			+ animalToFeed.getEmotionalState() 
			+ ", Health State: " + animalToFeed.getHealthState() + "\n");
			removeItemFromSupplies(foodToUse);
		} else {
			System.out.println("You have performed all of your actions today!\n");
		}
	}
	
}
