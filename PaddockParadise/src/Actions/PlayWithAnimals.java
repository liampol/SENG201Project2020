package Actions;

import MainClassesPackage.Animal;
import MainClassesPackage.PaddockParadiseManager;

public class PlayWithAnimals extends Action {
	
	private Animal animalToPlayWith;
	
	public PlayWithAnimals(PaddockParadiseManager incoming, Animal animalToPlayWith) {
		super(incoming);
		this.animalToPlayWith = animalToPlayWith;
	}

	@Override
	public void performAction() {
		if (actionsAvailable()) {
			animalToPlayWith.alterEmotionalState(1);
			System.out.println("You play with the " + animalToPlayWith.getName() + "!\n");
			System.out.println("The state of " + animalToPlayWith.getName() + " is now - Emotional State: " 
			+ animalToPlayWith.getEmotionalState() 
			+ ", Health State: " + animalToPlayWith.getHealthState() + "\n");
		} else {
			System.out.println("You have performed all of your actions today!\n");
		}
	}
}
