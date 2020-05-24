package actions;

import mainClassesPackage.Animal;
import mainClassesPackage.PaddockParadiseManager;

/**
 * <h2>PlayWithAnimals</h2>
 * 
 * <p> The action to play with an animal in the player's farm. Action is performed by creating a PlayWithAnimals instance and
 * calling the performAction method.
 *  
 */ 
public class PlayWithAnimals extends Action {
	
	private Animal animalToPlayWith;
	
	/**
	 * 
	 * @param incoming Game environment to give access to the state of the game
	 * @param animalToPlayWith Animal object chosen
	 */
	public PlayWithAnimals(PaddockParadiseManager incoming, Animal animalToPlayWith) {
		super(incoming);
		this.animalToPlayWith = animalToPlayWith;
	}

	@Override
	public void performAction() {
		if (actionsAvailable()) {
			animalToPlayWith.alterEmotionalState(2); // +2 Happiness to animal
			System.out.println("You play with the " + animalToPlayWith.getName() + "!\n");
			System.out.println("The state of " + animalToPlayWith.getName() + " is now - Emotional State: " 
			+ animalToPlayWith.getEmotionalState() 
			+ ", Health State: " + animalToPlayWith.getHealthState() + "\n");
		} else {
			System.out.println("You have performed all of your actions today!\n");
		}
	}
}
