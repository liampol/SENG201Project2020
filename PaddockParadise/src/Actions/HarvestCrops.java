package Actions;

import MainClassesPackage.Crop;
import MainClassesPackage.PaddockParadiseManager;

/*
 * @author liam
 *  - To sell a crop, make a HarvestCrops object, and use the performAction method.
 *  - To be implemented in the playGame() method under case 2.
 */ 
public class HarvestCrops extends Action {
	
	private Crop cropToHarvest;
	
	public HarvestCrops(PaddockParadiseManager incoming, Crop cropToHarvest) {
		super(incoming);
		this.cropToHarvest = cropToHarvest;
	}

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

