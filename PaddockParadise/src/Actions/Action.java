package Actions;
import MainClassesPackage.PaddockParadiseManager;
import MainClassesPackage.Supplies;

/**
 * <h2>Action</h2>
 * 
 * <p> This class describes an action that can be performed.
 * 
 * @author Liam Pol
 */
public abstract class Action {
	
	protected PaddockParadiseManager manager;
	private final int COST_OF_ACTION = 1;
	/**
	 * Passes the game environment instance, so it can access the state of the game.
	 * 
	 * @param incoming The instance of the game environment
	 */
	public Action(PaddockParadiseManager incoming) {
		manager = incoming;
	}
	/**
	 * Checks if actions are available.
	 * 
	 * @return Whether player has any actions left for the day
	 */
	public boolean actionsAvailable() {
		if (manager.getActivitiesLeft() > 0) {
			manager.setActivitiesLeft((manager.getActivitiesLeft() - COST_OF_ACTION));
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Gives back an action to user in case the action could not be performed.
	 * 
	 */
	public void refundAction() {
		manager.setActivitiesLeft(manager.getActivitiesLeft() + 1);
	}
	
	/**
	 * Removes the Supplies object that is used in performing the action
	 * 
	 * @param supplyToUse the consumed Supplies object
	 */
	public void removeItemFromSupplies(Supplies supplyToUse) {
		for (Supplies supply: manager.getFarm().getCurrentSupplies()) { // ArrayList of Supplies objects
			if (supplyToUse.getName().equals(supply.getName())) {
				manager.getFarm().getCurrentSupplies().remove(supply);
				break;
			}
		}
	}
	/**
	 * Performs the action
	 * 
	 */
	public abstract void performAction();
	
}
