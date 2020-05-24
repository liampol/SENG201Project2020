package actions;

import mainClassesPackage.Crop;
import mainClassesPackage.PaddockParadiseManager;
import mainClassesPackage.Supplies;

/**
 * <h2>TendCrops</h2>
 * 
 * <p> The action to tend to a crop in the player's farm. Action is performed by creating a TendCrops instance and
 * calling the performAction method.
 * 
 */
public class TendCrops extends Action {

	private Crop cropToTend;
	private Supplies supplyToUse;
	
	/**
	 * 
	 * @param incoming Game environment to give access to the state of the game
	 * @param cropToTend Crop object chosen
	 * @param supplyToUse Supplies object chosen
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
