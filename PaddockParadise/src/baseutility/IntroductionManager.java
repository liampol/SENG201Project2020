package baseutility;

import GUIPackage.Aim;
import GUIPackage.HowToPlay;
import GUIPackage.Introduction;
import MainClassesPackage.*;
/**
 * This class managers all G.U.I windows for introduction and how to play by calling the GUI's that show instructions
 * 
 * @author Te Wehenga Johnson
 *
 */
public class IntroductionManager {
	
	private PaddockParadiseManager manager;
	
	public IntroductionManager(PaddockParadiseManager newManager) {
		
		manager = newManager;
		launchIntroduction();
	}
	
	/**
	 * Launches the Introduction window 
	 */
	private void launchIntroduction() {
		Introduction introductionScreen = new Introduction(this);
	}
	/**
	 * Closes the introduction window
	 * @param introductionScreen
	 */
	public void closeIntroductionWindow(Introduction introductionScreen) {
		introductionScreen.closeWindow();
		launchAim();
	}
	
	/**
	 * Launches the Aim window
	 */
	private void launchAim() {
		Aim aimScreen = new Aim(this);
	}
	
	/**
	 * Closes the Aim window
	 * @param aimScreen
	 */
	public void closeAimScreen(Aim aimScreen) {
		aimScreen.closeWindow();
		launchHowToPlay();
	}
	
	/**
	 * Returns back to the previous window which is the Introduction window
	 * @param aimScreen
	 */
	public void openPreviousAimWindow(Aim aimScreen) {
		aimScreen.closeWindow();
		launchIntroduction();
	}
	
	/**
	 * Launches the how to play window
	 */
	private void launchHowToPlay() {
		HowToPlay howToPlayScreen = new HowToPlay(this);
	}
	
	/**
	 * Returns to the previous window which is the Aim window
	 * @param howToPlayScreen
	 */
	public void openPreviousHowToPlayWindow(HowToPlay howToPlayScreen) {
		howToPlayScreen.closeWindow();
		launchAim();
	}
	
	/**
	 * Closes the HowToPlay window and returns back to the PadockParadiseManager
	 * @param howToPlayScreen
	 */
	public void closeHowToPlayWindow(HowToPlay howToPlayScreen) {
		howToPlayScreen.closeWindow();
		manager.launchMainWindow();
	}
	
	
	public PaddockParadiseManager getManager() {
		return manager;
	}
	
	
	public static void main(String[] args) {

		PaddockParadiseManager newManager = new PaddockParadiseManager();
		
	}
}
