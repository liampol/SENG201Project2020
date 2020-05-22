package Actions;

import MainClassesPackage.PaddockParadiseManager;

public class TendLand extends Action {
	
	public TendLand(PaddockParadiseManager incoming) {
		super(incoming);
	}

	@Override
	public void performAction() {
		if (actionsAvailable()) {
			System.out.println("The land has been tended to and is looking much better!\n");
			switch (manager.getFarm().getState()) {
			case "Unkept":
				manager.getFarm().setState("Tidy");
				break;
			case "Tidy":
				break;
			}
			manager.getFarm().setDaysBeingTidy(1);
			manager.getFarm().setDaysBeingUnkept(1);
			System.out.println("The state of " + manager.getFarm().getName() + " is now: " 
								+ manager.getFarm().getState() + "\n");
			if (manager.getFarm().getCropLimit() < 6) {
				manager.getFarm().setCropLimit(manager.getFarm().getCropLimit() + 1);
			}
			System.out.println("The crop capacity of " + manager.getFarm().getName()
							+ "is now: " + manager.getFarm().getCropLimit() + " crops\n");
		} else {
			System.out.println("You have performed all of your actions today!\n");
		}
		
	}
	
}
