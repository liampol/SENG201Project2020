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
			switch (animalToPlayWith.getEmotionalState()) {
				case "Sad":
					animalToPlayWith.setEmotionalState("Saudade");
					break;
				case "Saudade":
					animalToPlayWith.setEmotionalState("Happy");
					break;
				case "Happy":
					animalToPlayWith.setEmotionalState("Happy");
					break;
			}
			System.out.println("You play with the " + animalToPlayWith.getName() + "!\n");
		} else {
			System.out.println("You have performed all of your actions today!\n");
		}
	}
}
