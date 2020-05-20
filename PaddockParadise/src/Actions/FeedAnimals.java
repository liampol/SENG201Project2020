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
				animalToFeed.alterHealthState(1);
				break;
			case "Grains":
				animalToFeed.alterHealthState(2);
				break;
			case "Vitamins":
				animalToFeed.alterHealthState(3);
				break;
			} 
			System.out.println("You feed the " + animalToFeed.getName() + " the " + foodToUse.getName()
								+ "!\n");
			System.out.println("The " + animalToFeed.getName() + " is looking much healther!\n");
			System.out.println("The state of " + animalToFeed.getName() + " is now " + animalToFeed.getHealthState() 
								+ "!\n");
			manager.getFarm().getCurrentSupplies().remove(foodToUse);
		} else {
			System.out.println("You have performed all of your actions today!\n");
		}
	}
	
}
