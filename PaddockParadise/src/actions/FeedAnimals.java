package actions;

import mainClassesPackage.Animal;
import mainClassesPackage.PaddockParadiseManager;
import mainClassesPackage.Supplies;

public class FeedAnimals extends Action {

	/**
	 * <h2>FeedAnimals</h2>
	 * 
	 * <p> The action to feed an animal in the player's farm. Action is performed by creating a FeedAnimals instance and
	 * calling the performAction method.
	 * 
	 */
	
	private Animal animalToFeed;
	private Supplies foodToUse;
	
	/**
	 * 
	 * @param incoming Game environment to give access to the state of the game
	 * @param animalToFeed Animal object chosen
	 * @param foodToUse Supplies object chosen
	 */
	
	public FeedAnimals(PaddockParadiseManager incoming, Animal animalToFeed, Supplies foodToUse) {
		super(incoming);
		this.animalToFeed = animalToFeed;
		this.foodToUse = foodToUse;
	}
	
	/**
	 * 
	 */
	@Override
	public void performAction() {
		if (actionsAvailable()) {
			switch (foodToUse.getName()) {
			case "Hay":
				animalToFeed.alterEmotionalState(3); // Hay = +3 Happiness
				break;
			case "Grains":
				animalToFeed.alterHealthState(3); // Grains = +3 Health
				break;
			case "Vitamins":
				animalToFeed.alterHealthState(3); // Vitamins = +3 Happiness & Health
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
