package Actions;
import MainClassesPackage.PaddockParadiseManager;

/*
 * @author liam
 * 
 */
public abstract class Action {
	
	protected PaddockParadiseManager manager;
	public final int COST_OF_ACTION = 1;
	
	public Action(PaddockParadiseManager incoming) {
		manager = incoming;
	}
	
	public boolean actionsAvailable() {
		if (manager.getActivitiesLeft() > 0) {
			manager.setActivitiesLeft((manager.getActivitiesLeft() - COST_OF_ACTION));
			return true;
		} else {
			return false;
		}
	}
	
	public void refundAction() {
		manager.setActivitiesLeft(manager.getActivitiesLeft() + 1);
	}
	
	public abstract void performAction();
	
}
