package Actions;

import MainClassesPackage.Crop;
import MainClassesPackage.PaddockParadiseManager;
import MainClassesPackage.Supplies;

public class TendCrops extends Action {

	private Crop cropToTend;
	private Supplies supplyToUse;
	
	/*
	 *  Option to use with supply or not will be prompted from the performActions() function within 
	 *  the environment. If using a supply, then TendCrops will be called with supplyToUse, otherwise
	 *  null.
	 *  cropToTend argument should always be passed in from the list of crops on the farm.
	 */
	
	public TendCrops(PaddockParadiseManager incoming, Crop cropToTend, Supplies supplyToUse) {
		super(incoming);
		this.cropToTend = cropToTend;
		this.supplyToUse = supplyToUse;
	}
	
	
	@Override
	public void performAction() {
		if (actionsAvailable()) {
			if (supplyToUse == null) {
				cropToTend.alterCropTime(1);
				
			} else {
				switch (supplyToUse.getName()) {
				case "Horse Dung":
					cropToTend.alterCropTime(2);
					break;
				case "Fertiliser":
					cropToTend.alterCropTime(3);
					break;
				case "Root Boost":
					cropToTend.alterCropTime(4);
					break;
				}
				//cropToTend.alterCropTime();
			}
			if (supplyToUse == null) {
				System.out.println("The " + cropToTend.getType() +  "s are watered!");
			} else {
				System.out.println("Your " + supplyToUse.getName() + " is used on the " + cropToTend.getType() 
				+ "s!");
				manager.getFarm().removeSupply(supplyToUse);
			}
			String pluralDays = (cropToTend.getDaysToHarvest() == 1) ? "" : "s";
			System.out.println("\nThe " + cropToTend.getType() + "s have been tended to and are looking healthy!\n" +
								"\nThe " + cropToTend.getType() + " crops are now " + cropToTend.getDaysToHarvest() + 
								" day" + pluralDays + " away from being harvested\n");
		} else {
			System.out.println("You have performed all of your actions today!\n");
		}
	}
	
	
	
}
