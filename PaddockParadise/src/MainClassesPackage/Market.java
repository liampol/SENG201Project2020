package MainClassesPackage;
import animalExtend.*;
import cropExtend.*;
import java.util.ArrayList;
import MainClassesPackage.*;
import extendSupplies.*;
import java.util.Scanner;
import GUIPackage.*;


/**
 * The Market Class that implements the shop that allows the player to purchase 'SUPPLIES', 'ANIMALS', and 'CROPS',
 * The player is also able to Sell crops that have a 'HARVESTED" State
 * @author Te Wehenga Johnson
 *
 */
public class Market {
	
	PaddockParadiseManager manager;
	public ArrayList<Crop> cropCart;            // This variable is used to keep track of Crops added to cart
	public ArrayList<Animal> animalCart;        // This variable is used to keep track of Crops added to cart
	public ArrayList<Supplies> suppliesCart;    // This variable is used to keep track of Crops added to cart
	public double cartCost;
	private Farm farmOwner;
	private Scanner input = new Scanner(System.in);
	
	// Crops on display
	public Cauliflower cauliflower = new Cauliflower();
	public Carrot carrot = new Carrot();
	public Potato potato = new Potato();
	public Capsicum capsicum = new Capsicum();
	public Avocado avocado = new Avocado();
	public Broccoli broccoli = new Broccoli();
	
	// Animals on display
	public Pig pig = new Pig();
	public Cow cow = new Cow();
	public Sheep sheep = new Sheep();
	
	//Supplies on  display
	public RootBoost rootBoost = new RootBoost();
	public Fertiliser fertiliser = new Fertiliser();
	public HorseDung horseDung = new HorseDung();
	public Grains grain = new Grains();
	public Hay hay = new Hay();
	public Vitamins vitamin = new Vitamins();
	
	// track amount of each item added to cart
	int carrotCount = 0;
	int broccoliCount = 0;
	int cauliCount = 0;
	int avoCount = 0;
	int potaCount = 0;
	int capsCount = 0;
	int rootBoostCount = 0;
	int fertCount = 0;
	int grainCount = 0;
	int dungCount = 0;
	int hayCount = 0;
	int vitCount =0;
	int cowCount = 0;
	int sheepCount =0;
	int pigCount = 0;
	
	
	/**
	 * Instantiates a Market to purchase supplies, Crops, and Animals for your farm
	 * @param currentFarmOwner
	 */
	public Market(PaddockParadiseManager incoming) {
		
		
		farmOwner = incoming.getFarm();
		animalCart = new ArrayList<Animal>();
		cropCart = new ArrayList<Crop>();
		suppliesCart = new ArrayList<Supplies>();
		cartCost = 0.00;
		manager = incoming;
		launchOpenMarket();
	}
	
	/**
	 * This is the main menu for the Market where the user is shown:
	 * All items for sale,
	 * Farms current cash balance, and What is currently in the cart
	 * The user is also given different options that they can choose from by pressing the corresponding number to the option they would like to choose,
	 * The options are:
	 * 		[1] Buy Crops
	 *		[2] Buy Animals
	 *		[3] Buy Farm Supplies
	 *		[4] Sell Crops
	 *		[5] Remove items from cart
	 *      [6] Checkout
	 *		[7] EXIT SHOP
	 */
	
	public void addFertiliser() {
			Fertiliser addedFertiliser = new Fertiliser();
			cartCost += addedFertiliser.getPrice(); 
			suppliesCart.add(addedFertiliser);
			fertCount ++;

	}
	
	/**
	 * Adds Horse-Dung to cart as well as adds the cost to cartCost
	 */
	public void addHorseDung() {
		HorseDung addedHorseDung= new HorseDung();
		cartCost += addedHorseDung.getPrice(); 
		suppliesCart.add(addedHorseDung);
		dungCount ++;

	}
	
	/**
	 * Adds Root-Boost to cart as well as adds the cost to cartCost
	 */
	public void addRootBoost() {
		RootBoost addedRootBoost= new RootBoost();
		cartCost += addedRootBoost.getPrice(); 
		suppliesCart.add(addedRootBoost);
		rootBoostCount ++;

	}
	
	/**
	 * Adds grains to cart as well as adds the cost to cartCost
	 */
	public void addGrains() {
			Grains addedGrains = new Grains();
			cartCost += addedGrains.getPrice(); 
			suppliesCart.add(addedGrains);
			grainCount ++;
	}
	
	/**
	 * Adds Vitamins to cart as well as adds the cost to cartCost
	 */
	public void addVitamins() {
			Vitamins addedVitamins = new Vitamins();
			cartCost += addedVitamins.getPrice(); 
			suppliesCart.add(addedVitamins);
			vitCount ++;
	}
	
	/**
	 * Adds Hay to cart as well as adds the cost to cartCost
	 */
	public void addHay() {
		Hay addedHay = new Hay();
		cartCost += addedHay.getPrice(); 
		suppliesCart.add(addedHay);
		hayCount ++;
	}
	
	/**
	 * Adds Cow to cart as well as adds the cost to cartCost
	 */
	public void addCow() {
		Cow addedCow = new Cow();
		cartCost += addedCow.getPrice();
		animalCart.add(addedCow);
		cowCount ++;
	}
	
	/**
	 * Adds Sheep to cart as well as adds the cost to cartCost
	 */
	public void addSheep() {
		Sheep addedSheep = new Sheep();
		cartCost += addedSheep.getPrice();
		animalCart.add(addedSheep);
		sheepCount ++;	
	}
	
	/**
	 * Adds Pig to cart as well as adds the cost to cartCost
	 */
	public void addPig() {
		Pig addedPig = new Pig();
		cartCost += addedPig.getPrice();
		animalCart.add(addedPig);
		pigCount ++;
	
	}
	
	/**
	 * Adds Carrots to cart as well as adds the cost to cartCost
	 */
	public void addCarrots() {
		Carrot addedCarrots = new Carrot();
		cartCost += addedCarrots.getPrice();
		cropCart.add(addedCarrots);
		carrotCount  ++;
	}
	
	/**
	 * Adds Capsicum to cart as well as adds the cost to cartCost
	 */
	public void addCapsicum() {
		Capsicum addedCapsicum = new Capsicum();
		cartCost += addedCapsicum.getPrice();
		cropCart.add(addedCapsicum);
		capsCount ++;	
	}
	
	/**
	 * Adds Potato's to cart as well as adds the cost to cartCost
	 */
	public void addPotato() {
		Potato addedPotatos = new Potato();
		cartCost += addedPotatos.getPrice();
		cropCart.add(addedPotatos);
		potaCount ++;
	}
	
	/**
	 * Adds Broccoli to cart as well as adds the cost to cartCost
	 */
	public void addBroccoli() {
		Broccoli addedBroccoli = new Broccoli();
		cartCost += addedBroccoli.getPrice();
		cropCart.add(addedBroccoli);
		broccoliCount ++;	
	}
	
	/**
	 * Adds Cauliflower to cart as well as adds the cost to cartCost
	 */
	public void addCauliflower() {
		Cauliflower addedCauliflower = new Cauliflower();
		cartCost += addedCauliflower.getPrice();
		cropCart.add(addedCauliflower);
		cauliCount ++;
	}
	
	/**
	 * Adds Avocado to cart as well as adds the cost to cartCost
	 */
	public void addAvocado() {
		Avocado addedAvocado = new Avocado();
		cartCost += addedAvocado.getPrice();
		cropCart.add(addedAvocado);
		avoCount ++;
	}
	
	/**
	 * Gets the current cost of the cart as a Type "Double"
	 * @return
	 */
	public double getCartCost() {
		return cartCost;
	}
	/**
	 * Takes a String of the item name/type to be removed,
	 * and returns the amount of that item in the cart,
	 * @param item
	 * @return
	 */
	public int getItemCount(String item) {
		
		int amount = 0;
		switch (item) {
		case "Carrots":
			amount = carrotCount;
			break;
		case "Broccoli":
			amount = broccoliCount;
			break;
		case "Cauliflower":
			amount = cauliCount;
			break;
		case "Avocado":
			amount = avoCount;
			break;
		case "potato":
			amount = potaCount;
			break;
		case "Capsicum":
			amount = capsCount;
			break;
		case "Root Boost":
			amount = rootBoostCount;
			break;
		case "Fertiliser":
			amount = fertCount;
			break;
		case "Grains":
			amount = grainCount;
			break;
		case "Horse Dung":
			amount = dungCount;
			break;
		case "Hay":
			amount = hayCount;
			break;
		case "Vitamins":
			amount = vitCount;
			break;
		case "Cow":
			amount = cowCount;
			break;
		case "Sheep":
			amount = sheepCount;
			break;
		case "Pig":
			amount = pigCount;
			break;
		}
		if (amount <= 0){
			amount = 0;
		}
		
		return amount;
	}
	
	
	
	/**
	 * Removes the specified crop from the cart
	 * @param item
	 */
	public String removeCrop(String item) {
		String message = "";
		
		boolean invalid = true;                      // If item is not in cart the invalid is true
		for (Crop toRemove : cropCart) {         
			if (toRemove.getType() == item) {        // Compares each type to the item parameter to ensure the correct item is removed
				double cost = toRemove.getPrice();   // Gets the price of item to remove
				cropCart.remove(toRemove);           // removes item object from cart
				cartCost -= cost;                    // Decrements the cost of the item from cart cost
				System.out.println(item + " has been removed\n");
				invalid = false;                     // Item was in cart,invalid is false
				break;                               // End loop
				}
		}

		// Decrements the corresponding Crop counter
		if (item == "Carrot" && carrotCount > 0) {
			carrotCount --;
		}else if ( item == "Broccoli"  && broccoliCount > 0) {
			broccoliCount --;
		}else if ( item == "Cauliflower" && cauliCount > 0) {
			cauliCount --;
		}else if ( item == "Capsicum"  && capsCount > 0) {
			capsCount --;
		}else if ( item == "Avocado" && avoCount > 0) {
			avoCount --;
		}else if ( item == "Potato" && potaCount > 0){
			potaCount --;
		}
		if (invalid) {                                // If item is not in cart
		message = "Sorry " + item +" is not in your cart";
		
		}else {
			message = item + " has been removed from cart!";
		}
		
		return message;
		
	}
	

	/**
	 * Removes the specified supply,
	 * @param
	 */
	public String removeSupply(String item) {
		String  message = "";
		boolean empty = true; 
		for (Supplies toRemove : suppliesCart) {
			if (toRemove.getName() == item) {
				double cost = toRemove.getPrice();
				suppliesCart.remove(toRemove);
				cartCost -= cost;
				System.out.println(item + " has been removed\n");
				empty = false;
				break;
				}
		}

		// Decrements the corresponding Supply item counter
		if (item == "Root Boost" && rootBoostCount > 0) {
			rootBoostCount --;
		}else if ( item == "Hay"  && hayCount > 0) {
			hayCount --;
		}else if ( item == "Grains" && grainCount > 0) {
			grainCount --;
		}else if ( item == "Horse Dung" && dungCount > 0) {
			 dungCount --;
		}else if ( item == "Vitamins" && vitCount > 0) {
			vitCount --;
		}else if ( item == "Fertiliser" && fertCount > 0){
			fertCount --;
		}
		
		if (empty) {
			message = "Sorry " + item + " is not in your cart";
		}else {
			message = item + " has been removed from cart!";
		}
		return message;
	}
	

	/**
	 * Removes a 'Animal' that has been passed as a string parameter 
	 * @param item
	 */
	public String removeAnimal(String item) {
		boolean empty = true;
		String message = "";
		for (Animal toRemove : animalCart) {
			if (toRemove.getType() == item) {
				double cost = toRemove.getPrice();
				animalCart.remove(toRemove);
				cartCost -= cost;
				System.out.println(item + " has been removed\n");
				empty = false;
				break;
			}
		}
		// Decrements the corresponding Supply item counter
		if (item == "Cow" && cowCount > 0) {
			cowCount --;
		}else if ( item == "Sheep"  && sheepCount > 0) {
			sheepCount --;
		}else if ( item == "Pig" && pigCount > 0) {
			pigCount --;
		}
		if (empty) {
			message = "Sorry " + item + " is not in your cart";
			}else {
				message = item + " has been removed from cart!";
			}
		return message;
	}
	

	public void applyDiscount() {
		
		cartCost = cartCost-(cartCost*0.4);
		
	}
	
	public void applyHappyAnimal() {
		

		if (!(animalCart.isEmpty())) {
			for (Animal animal : animalCart) {
				animal.addHealthBonus();
				
			}
		}
	}
	
	public void applyFasterCropGrowth() {
		
		if (!(cropCart.isEmpty())) {
			for (Crop vegetable : cropCart) {
				vegetable.alterCropTime(1);
			}
		}
	}

		
	
	private void launchOpenMarket() {
		OpenMarket openMarketScreen = new OpenMarket(this);
	}
	
	public void launchMarketCrops(OpenMarket openMarketScreen) {
		openMarketScreen.closeWindow();
		MarketCrops marketCropsScreen = new MarketCrops(this);
	}
	
	public void closeMarketCrops(MarketCrops marketCropsScreen) {
		marketCropsScreen.closeWindow();
		launchOpenMarket();
	}
	
	public void launchMarketAnimals(OpenMarket openMarketScreen) {
		openMarketScreen.closeWindow();
		MarketAnimals marketAnimalsScreen = new MarketAnimals(this);
		
	}
	
	public void closeMarketAnimals(MarketAnimals marketAnimalsScreen) {
		marketAnimalsScreen.closeWindow();
		launchOpenMarket();
	}
	
	public void launchMarketSupplies(OpenMarket openMarketScreen) {
		openMarketScreen.closeWindow();
		MarketSupplies marketSuppliesWindow = new MarketSupplies(this);
	}
	
	public void closeMarketSuppliesWindow(MarketSupplies marketSuppliesScreen) {
		marketSuppliesScreen.closeWindow();
		launchOpenMarket();
	}
	
	public void launchCartWindow(OpenMarket openMarketScreen) {
		openMarketScreen.closeWindow();
		CartWindow cartScreen = new CartWindow(this);
	}
	
	public void closeCartWindow(CartWindow cartScreen) {
		cartScreen.closeWindow();
		launchOpenMarket();
	}
	
	public void launchCheckout(OpenMarket openMarketScreen) {
		openMarketScreen.closeWindow();
		Checkout checkoutScreen = new Checkout(this);
		
	}
	
	public void closeCheckoutWindow(Checkout checkoutScreen) {
		checkoutScreen.closeWindow();
		launchOpenMarket();
	}
	
	public void closeMarketWindow(OpenMarket openMarketScreen) {
		openMarketScreen.closeWindow();
		manager.launchMainWindow();
	}
	
	public PaddockParadiseManager getManager() {
		return manager;
	}
	
	public static void exit() {
		throw new NullPointerException();
		// throw an exception in order to abort construction, and not go through the
		// rest of the methods on call stack
	}
	
	public static void main(String[] args) {
		
		//Implemented for testing
		
		
		
//		Market openMarket = new Market(newFarm); // Test Market()
//openMarket.printCart();                  // Test printCart() with no items
		
//		// Test for adding Animals
//		openMarket.addCow();                     // Test addCow() 
//		openMarket.addSheep();                   // Test addSheep()
//		openMarket.addPig();                     // Test addPig()
//		openMarket.printCart();                  // Test printCart() with multiple items
//		openMarket.printCartCost();              // Test printCartCost() with multiple items in cart
//		
//		// Test for adding Crops
//		openMarket.addCarrots();                 // Test addCarrots
//		openMarket.addPotato();                  // Test addCarrots
//		openMarket.addBroccoli();                // Test addBroccoli
//		openMarket.addCapsicum();                // Test addCapsicum
//		openMarket.addCauliflower();             // Test addCauliflower
//		openMarket.addAvocado();                 // Test addAvocado
//		openMarket.printCart();                  // Test printCart() with multiple items
//		openMarket.printCartCost();              // Test printCartCost() with multiple items in cart
//		
//		//Test for adding Supplies
//		openMarket.addFertiliser();
//		openMarket.addGrains();
//		openMarket.addHorseDung();
//		openMarket.addRootBoost();
//		openMarket.addHay();
//		openMarket.addVitamins();
//		
//		//Test remove items
//		openMarket.removeAnimal("Cow");
//		openMarket.removeCrop("Carrot");
//		openMarket.removeCrop("Carrot");
//		openMarket.removeSupply("Fertiliser");
//		openMarket.removeSupply("Vitamins");
//		openMarket.viewMarketOptions();
		
	}
}
