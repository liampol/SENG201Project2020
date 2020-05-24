package actions;

import mainClassesPackage.Crop;
import mainClassesPackage.PaddockParadiseManager;

/**
 * <h2>HarvestCrops</h2>
 * 
 * <p> The action to harvest a crop in the player's farm. Action is performed by creating a HarvestCrops instance and
 * calling the performAction method.
 *  
 */ 
public class HarvestCrops extends Action {
	
	private Crop cropToHarvest;
	
	/**
	 * 
	 * @param incoming Game environment to give access to the state of the game
	 * @param cropToHarvest Crop object chosen
	 */
	public HarvestCrops(PaddockParadiseManager incoming, Crop cropToHarvest) {
		super(incoming);
		this.cropToHarvest = cropToHarvest;
	}
	/**
	 * 
	 */
	@Override
	public void performAction() {
		if (actionsAvailable()) {
			if (cropToHarvest.getState().equals("Harvest")) {
				manager.getFarm().removeCrop(cropToHarvest);
				manager.getFarm().addToWallet(cropToHarvest.getSellPrice());
				System.out.println("You harvest and sell the " + cropToHarvest.getType() + "s for " 
									+ cropToHarvest.getSellPrice() + "!\n");
				System.out.println("Your farm now has " + manager.getFarm().getMoney() + "!"
								+ "\n");
			} else {
				System.out.println("This crop is not ready to be harvested yet!");
				refundAction();
			}
		} else {
			System.out.println("You have performed all of your actions today!\n");
		}
		
	}

}

