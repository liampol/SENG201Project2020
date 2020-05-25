package baseutility;

	import MainClassesPackage.*;
	import GUIPackage.*;

	/**
	 * 
	 * The Setup1 class is called to control the different GUIs used to receive the inital details from the user using different GUI,
	 * - ChooseFarmer
	 * - ChoosAvatar
	 * - ChoosFarmType
	 * - Input Farmer Name
	 * - Input Farm Name
	 * @author Te Wehenga Johnson
	 *
	 */
public class Setup1 {
	
	private static PaddockParadiseManager manager;
	
	public Setup1(PaddockParadiseManager incomingManager) {
		
		manager = incomingManager;
		launchWelcomeWindow();
	}
	
	public void launchWelcomeWindow() {
		WelcomeScreen welcomeWindow = new WelcomeScreen(this);
	}
	
	public void closeWelcomeScreen(WelcomeScreen welcomeWindow) {
		welcomeWindow.closeWindow();
		launchChooseAvatar();
	}
	
	public void launchChooseAvatar() {
		ChooseAvatar chooseAvatarScreen = new ChooseAvatar(this);
	}
	
	public void closeChooseAvatarScreen(ChooseAvatar chooseAvatarScreen) {
		chooseAvatarScreen.closeWindow();
		launchFarmerDetails();
	}
	
	public void launchFarmerDetails() {
		FarmerDetails farmerDetailsWindow = new FarmerDetails(this);
	}
	
	public void closeFarmerDetailsScreen(FarmerDetails farmerDetailsScreen) {
		farmerDetailsScreen.closeWindow();
		launchChooseFarmType();
	}
	
	public void launchChooseFarmType() {
		ChooseFarmType chooseFarmTypeScreen = new ChooseFarmType(this);
	}
	
	public void closeChooseFarmType(ChooseFarmType chooseFarmTypeScreen) {
		chooseFarmTypeScreen.closeWindow();
		launchFarmName();
	}
	
	public void launchFarmName() {
		FarmName farmNameScreen = new FarmName(this);
	}
	
	public void closeFarmNameWindow(FarmName farmNameScreen) {
		farmNameScreen.closeWindow();
		manager.launchIntroductionManager();
	}
	
	
	public PaddockParadiseManager getManager(){
		return manager;
	}
	
	
	private static void main(String[] args) {
		
	//PaddockParadiseManager manager = new PaddockParadiseManager();
		
	//	Setup setup = new Setup();
	//	setup.createFarmer(manager);
		}
		

	}

