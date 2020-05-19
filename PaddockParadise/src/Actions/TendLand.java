package Actions;

import MainClassesPackage.PaddockParadiseManager;

public class TendLand extends Action {

	private PaddockParadiseManager manager;
	
	public TendLand(PaddockParadiseManager incoming) {
		super(incoming);
	}

	@Override
	public void performAction() {
		if (actionsAvailable()) {
			System.out.println("The land has been tended to!\n");
			switch (manager.getFarm().getState()) {
			case "Unkept":
				manager.getFarm().setState("Tidy");
				break;
			case "Tidy":
				break;
			}
			System.out.println("The farm land is looking much better!\n");
			System.out.println("The state of " + manager.getFarm().getName() + "is now " 
								+ manager.getFarm().getState() + "!\n");
		} else {
			System.out.println("You have performed all of your actions today!\n");
		}
		
	}
	
}
