package baseutility;

import GUIPackage.Aim;
import GUIPackage.HowToPlay;
import GUIPackage.Introduction;
import MainClassesPackage.*;

public class IntroductionManager {
	
	private PaddockParadiseManager manager;
	
	public IntroductionManager(PaddockParadiseManager newManager) {
		
		manager = newManager;
		launchIntroduction();
	}
	
	private void launchIntroduction() {
		Introduction introductionScreen = new Introduction(this);
	}
	
	public void closeIntroductionWindow(Introduction introductionScreen) {
		introductionScreen.closeWindow();
		launchAim();
	}
	
	private void launchAim() {
		Aim aimScreen = new Aim(this);
	}
	
	public void closeAimScreen(Aim aimScreen) {
		aimScreen.closeWindow();
		launchHowToPlay();
	}
	
	public void openPreviousAimWindow(Aim aimScreen) {
		aimScreen.closeWindow();
		launchIntroduction();
	}
	
	private void launchHowToPlay() {
		HowToPlay howToPlayScreen = new HowToPlay(this);
	}
	
	public void openPreviousHowToPlayWindow(HowToPlay howToPlayScreen) {
		howToPlayScreen.closeWindow();
		launchAim();
	}
	
	public void closeHowToPlayWindow(HowToPlay howToPlayScreen) {
		howToPlayScreen.closeWindow();
	}
	public PaddockParadiseManager getManager() {
		return manager;
	}
	
	
	public static void main(String[] args) {

		PaddockParadiseManager newManager = new PaddockParadiseManager();
		
	}
}
