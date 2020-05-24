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
	private ArrayList<Crop> cropCart;            // This variable is used to keep track of Crops added to cart
	private ArrayList<Animal> animalCart;        // This variable is used to keep track of Crops added to cart
	private ArrayList<Supplies> suppliesCart;    // This variable is used to keep track of Crops added to cart
	private double cartCost;
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
	public void viewMarketOptions() {
		System.out.println("WELCOME TO THE GENERAL MARKET!!\n\nThis is the 'FRONT DESK' How can I help you today?");
		System.out.println("(If your farm type is either:\n"
				+ "'Discount Store' or 'Faster Crop Growth', these bonuses will be shown at checkout)\n");
		System.out.println("The items sold here are:\n"
				//String cauliDets = cauli.getDetails();
				+ "Crops:\n"
				+ cauliflower.getDetails()
				+ avocado.getDetails()
				+ potato.getDetails() 
				+ broccoli.getDetails()
				+ capsicum.getDetails()
				+ carrot.getDetails() + "\n"
				+ "Animals:(Animals give money only if tended to)\n"
				+ cow.getDetails() 
				+ sheep.getDetails()
				+ pig.getDetails() + "\n"
				+ "Supplies:\n"
				+ "(For Crops)\n"
				+ rootBoost.getDetails()
				+ fertiliser.getDetails()
				+ horseDung.getDetails()
				+ "(For Animals)\n"
				+ grain.getDetails()
				+ vitamin.getDetails()
				+ hay.getDetails() + "\n");
		System.out.printf("YOUR CURRENT BALANCE: $" + farmOwner.getMoney()+ "\n");
		System.out.println("CURRENT CART COST: $" + cartCost);
		System.out.println("Your Current Cart:");
		printCart();
		
		int option = 0;
		boolean correct = false; 
		
		do {
			System.out.println("Please choose option by typing the corresponding number,");
			System.out.println("Would you like to:\n"
					+ "[1] Buy Crops\n"
					+ "[2] Buy Animals\n"
					+ "[3] Buy Farm Supplies\n"
					+ "[4] Sell Crops\n"
					+ "[5] Remove items from cart\n"
					+ "[6] Checkout\n"
					+ "[7] EXIT SHOP\n");  // Need to implement some notification to double check user would like to 
			option = input.nextInt();
			switch(option) {
			case 1:
				buyCrops();
				correct = true;
				break;
			case 2:
				buyAnimals();
				correct = true;
				break;
			case 3:
				buySupplies();
				correct = true;
				break;
			case 4:
				sellCrops();
				correct = true;
				break;
			case 5:
				removeFromCart();
				correct = true;
				break;
			case 6:
				checkout();
				correct = true;
				break;
			case 7:
				correct = true;
				System.out.print("You left the market\n");
				exit();
				break;
				}
			}while (!(correct));
		
		
	}
	
	/**
	 * Adds Fertiliser to cart as well as adds the cost to cartCost
	 */
	
	public void buyCrops() {
		
		int added = 0;
		boolean endSwitch = true; // Should always be true to end switch
		boolean endDo = false;     // Only true when Do-while ends and returns to previous menu
		do {
		System.out.println("\nPlease choose option by typing the corresponding number, and adding one item at a time, \n"
			             + "(EXAMPLE : press 1, then enter, for carrot, then press 2, then enter to also add broccoli)\n ");

		System.out.println("What crops would you like to add to cart?\n"
				+ "[1] Carrot      $10.00\n"
				+ "[2] Broccoli    $15.00\n"
				+ "[3] Capsicum    $20.00\n"
				+ "[4] Avocado     $30.00\n"
				+ "[5] Potato      $15.00\n"
				+ "[6] Cauliflower $30.00\n"
				+ "[7] Return to 'FRONT DESK'");
		added = input.nextInt();
		switch(added) {
		case 1:
			addCarrots();
			break;
		case 2:
			addBroccoli();
			break;
		case 3:
			addCapsicum();
			break;
		case 4:
			addAvocado();
			break;
		case 5:
			addPotato();
			break;
		case 6:
			addCauliflower();
			break;
		case 7:
			endDo = true;
			break;
			}while(!endSwitch);  // End switch when endSwitch is true
		}while(!endDo);          // End do-while loop while endDo is true
		
		viewMarketOptions();
		
	}
	
	public void buyAnimals() {
		
		int added = 0;
		boolean endSwitch = true; // Always ends through each iteration
		boolean endDo = false;    // Ends only when user wants to return to "FRONT DESK"
		
		do {
			System.out.println("What animals would you like to add to cart?\n"
					+ "[1] Sheep $20.00\n"
					+ "[2] Cow   $50.00\n"
					+ "[3] Pig  $10.00\n"
					+ "[4] Return to 'FRONT DESK'");
			added = input.nextInt();
			switch(added) {
			case 1:
				addSheep();
				break;
			case 2:
				addCow();
				break;
			case 3:
				addPig();
				break;
			case 4:
				endDo = true;
				break;
			}while(!(endSwitch));
		}while(!(endDo));
		
		viewMarketOptions();
		
		
	}
	
	public void buySupplies() {
		
		int added = 0;
		boolean endSwitch = true; // Always exit Switch after each iteration
		boolean endDo = false;    // Only exit do-while loop when returning back to "FRONT DESK"
		do {
				
			System.out.println("What supplies would you like to add to cart?\n"
					+ "[1] Grains:     [Cost] $100.00, [Attribute] Keeps animal healthier for 2 days,\n"
					+ "[2] Vitamins:   [Cost] $300.00, [Attribute] Keeps animal happy and healthier for 3 days,\n"
					+ "[3] Hay:        [Cost] $100.00, [Attribute] Keeps animal happy for 1 day,\n"
					+ "[4] Root Boost: [Cost] $55.00,  [Attribute] Boosts chosen crop by 3 days,\n"
					+ "[5] Fertiliser: [Cost] $20.00,  [Attribute] Boosts chosen crop by 2 days,\n"
					+ "[6] Horse-Dung: [Cost] $10.00,  [Attribute] Boosts chosen crop by 1 days,\n"
					+ "[7] Return to 'FRONT DESK'");
			
			added = input.nextInt();
			switch(added) {
			case 1:
				addGrains();
				break;
			case 2:
				addVitamins();
				break;
			case 3:
				addHay();
				break;
			case 4:
				addRootBoost();
				break;
			case 5:
				addFertiliser();
				break;
			case 6:
				addHorseDung();
				break;
			case 7:
				endDo = true;
				break;
			}while(!(endSwitch));
		}while(!(endDo));
		
		viewMarketOptions();
		
	}
	public void addFertiliser() {
			Fertiliser addedFertiliser = new Fertiliser();
			cartCost += addedFertiliser.getPrice(); 
			suppliesCart.add(addedFertiliser);
			fertCount ++;
			System.out.println("Fertiliser has been added to cart\n");
	}
	
	/**
	 * Adds Horse-Dung to cart as well as adds the cost to cartCost
	 */
	public void addHorseDung() {
		HorseDung addedHorseDung= new HorseDung();
		cartCost += addedHorseDung.getPrice(); 
		suppliesCart.add(addedHorseDung);
		dungCount ++;
		System.out.println("Horse-Dung has been added to cart\n");
	}
	
	/**
	 * Adds Root-Boost to cart as well as adds the cost to cartCost
	 */
	public void addRootBoost() {
		RootBoost addedRootBoost= new RootBoost();
		cartCost += addedRootBoost.getPrice(); 
		suppliesCart.add(addedRootBoost);
		rootBoostCount ++;
		System.out.println("RootBoost has been added to cart\n");
	}
	
	/**
	 * Adds grains to cart as well as adds the cost to cartCost
	 */
	public void addGrains() {
			Grains addedGrains = new Grains();
			cartCost += addedGrains.getPrice(); 
			suppliesCart.add(addedGrains);
			grainCount ++;
			System.out.println("Grains have been added to cart\n");
	}
	
	/**
	 * Adds Vitamins to cart as well as adds the cost to cartCost
	 */
	public void addVitamins() {
			Vitamins addedVitamins = new Vitamins();
			cartCost += addedVitamins.getPrice(); 
			suppliesCart.add(addedVitamins);
			vitCount ++;
			System.out.println("Vitamins have been added to cart\n");
	}
	
	/**
	 * Adds Hay to cart as well as adds the cost to cartCost
	 */
	public void addHay() {
		Hay addedHay = new Hay();
		cartCost += addedHay.getPrice(); 
		suppliesCart.add(addedHay);
		hayCount ++;
		System.out.println("Hay has been added to cart\n");
	}
	
	/**
	 * Adds Cow to cart as well as adds the cost to cartCost
	 */
	public void addCow() {
		Cow addedCow = new Cow();
		cartCost += addedCow.getPrice();
		animalCart.add(addedCow);
		cowCount ++;
		System.out.println("Cow has been added to cart\n");	
	}
	
	/**
	 * Adds Sheep to cart as well as adds the cost to cartCost
	 */
	public void addSheep() {
		Sheep addedSheep = new Sheep();
		cartCost += addedSheep.getPrice();
		animalCart.add(addedSheep);
		sheepCount ++;
		System.out.println("Sheep has been added to cart\n");	
	}
	
	/**
	 * Adds Pig to cart as well as adds the cost to cartCost
	 */
	public void addPig() {
		Pig addedPig = new Pig();
		cartCost += addedPig.getPrice();
		animalCart.add(addedPig);
		pigCount ++;
		System.out.println("Sheep has been added to cart\n");	
	}
	
	/**
	 * Adds Carrots to cart as well as adds the cost to cartCost
	 */
	public void addCarrots() {
		Carrot addedCarrots = new Carrot();
		cartCost += addedCarrots.getPrice();
		cropCart.add(addedCarrots);
		carrotCount  ++;
		System.out.println("Carrot has been added to cart\n");	
	}
	
	/**
	 * Adds Capsicum to cart as well as adds the cost to cartCost
	 */
	public void addCapsicum() {
		Capsicum addedCapsicum = new Capsicum();
		cartCost += addedCapsicum.getPrice();
		cropCart.add(addedCapsicum);
		capsCount ++;
		System.out.println("Capsicum has been added to cart\n");	
	}
	
	/**
	 * Adds Potato's to cart as well as adds the cost to cartCost
	 */
	public void addPotato() {
		Potato addedPotatos = new Potato();
		cartCost += addedPotatos.getPrice();
		cropCart.add(addedPotatos);
		potaCount ++;
		System.out.println("Potatos has been added to cart\n");	
	}
	
	/**
	 * Adds Broccoli to cart as well as adds the cost to cartCost
	 */
	public void addBroccoli() {
		Broccoli addedBroccoli = new Broccoli();
		cartCost += addedBroccoli.getPrice();
		cropCart.add(addedBroccoli);
		broccoliCount ++;
		System.out.println("Broccoli has been added to cart\n");	
	}
	
	/**
	 * Adds Cauliflower to cart as well as adds the cost to cartCost
	 */
	public void addCauliflower() {
		Cauliflower addedCauliflower = new Cauliflower();
		cartCost += addedCauliflower.getPrice();
		cropCart.add(addedCauliflower);
		cauliCount ++;
		System.out.println("Cauliflower has been added to cart\n");	
	}
	
	/**
	 * Adds Avocado to cart as well as adds the cost to cartCost
	 */
	public void addAvocado() {
		Avocado addedAvocado = new Avocado();
		cartCost += addedAvocado.getPrice();
		cropCart.add(addedAvocado);
		avoCount ++;
		System.out.println("Avocado has been added to cart\n");	
	}
	
	/**
	 * Gets the current cost of the cart as a Type "Double"
	 * @return
	 */
	public double getCartCost() {
		return cartCost;
	}
	
	
	/*
	 * Calls the toString() method to print the current items in the cart
	 */
	private void printCart() {

    // Prints only what items have incremented which is done only when added to cart
		if (cropCart.isEmpty() && animalCart.isEmpty() && suppliesCart.isEmpty()) {
			System.out.println("Cart is currently empty!");
			
		}else {
			if (carrotCount > 0) {
				System.out.println("Carrot: " + carrotCount);
			}
			if (cauliCount > 0) {
					System.out.println("Cauliflower: " + cauliCount);
			}if (avoCount > 0) { 
					System.out.println("Avocado: " + avoCount);
			}if (potaCount > 0) {
					System.out.println("Potato: " + potaCount);
			}if (capsCount > 0) {
					System.out.println("Capsicum: " + capsCount);
			}if (broccoliCount > 0) {
					System.out.println("Broccoli: " + broccoliCount);
			}if (cowCount > 0) {
					System.out.println("Cow: " + cowCount);
			}if (pigCount > 0) {
					System.out.println("Pig: " + pigCount);
			}if (sheepCount > 0) {
					System.out.println("Sheep: " + sheepCount);
			}if (fertCount > 0) {
				System.out.println("Fertiliser: " + fertCount);
			}if (rootBoostCount > 0) {
				System.out.println("Root Boost: " + rootBoostCount);
			}if (dungCount > 0) {
				System.out.println("Horse Dung: " + dungCount);
			}if (hayCount > 0) {
				System.out.println("Hay: " + hayCount);
			}if (vitCount > 0) {
				System.out.println("Vitamins: " + vitCount);
			}if (grainCount > 0){
				System.out.println("Grains: " + grainCount);
			}
		}System.out.println("");
	}
	
	/*
	 * Interface for user to decide which item to remove
	 */
	private void removeFromCart() {

		int option =0;            // tracks the option chosen
		boolean endDo = false;    // Ends the do-while loop only when a suitable optional has been chosen 
		boolean endSwitch = true; // Switch ends after every iteration
		do {
		System.out.println("What would you like to remove?");
		System.out.println("[1] Crops\n"
				+ "[2] Animals\n"
				+ "[3] Supplies\n"
				+ "[4] Return to 'FRONT DESK'");
		option = input.nextInt();
		
		switch(option) {
			case 1:
				removeCropFromCart();
				break;
			case 2:
				removeAnimalFromCart();
				break;
			case 3:
				removeSuppliesFromCart();
				break;
			case 4:
				endDo = true;
				break;
				}while(!endSwitch);
		}while(!endDo);
		viewMarketOptions();
	}
	
	/*
	 * Interface for user to decide which crop to remove
	 */
	private void removeCropFromCart() {
		
		int option = 0;            // tracks the option chosen
		boolean endDo = false;    // Ends the do-while loop only when a suitable optional has been chosen 
		boolean endSwitch = true; // Switch ends after every iteration
		do {
		System.out.println("What Crop would you like to remove?");
		System.out.println("[1] Carrot\n"
				+ "[2] Capsicum\n"
				+ "[3] Broccoli\n"
				+ "[4] Potato\n"
				+ "[5] Avocado\n"
				+ "[6] Cauliflower\n"
				+ "[7] Return to 'REMOVE ITEM MENU'");
		option = input.nextInt();
		
			switch(option) {
			case 1:
				removeCrop("Carrot");
				break;
			case 2:
				removeCrop("Capsicum");
				break;
			case 3:
				removeCrop("Broccoli");
				break;
			case 4:
				removeCrop("Potato");
				break;
			case 5:
				removeCrop("Avocado");
				break;
			case 6:
				removeCrop("Cauliflower");
				break;
			case 7:
				endDo = true;
				break;
			}while(!endSwitch);
		}while(!endDo);
		removeFromCart();
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
	
	/*
	 * Interface for user to decide which crop to remove
	 */
	private void removeSuppliesFromCart() {
		
		int option = 0;            // tracks the option chosen
		boolean endDo = false;     // Ends the do-while loop only when a suitable optional has been chosen 
		boolean endSwitch = true;  // Switch ends after every iteration
		do {
		System.out.println("What Supply would you like to remove?");
		System.out.println("[1] RootBoost\n"
				+ "[2] Horse-Dung\n"
				+ "[3] Fertiliser\n"
				+ "[4] Grains\n"
				+ "[5] Hay\n"
				+ "[6] Vitamin\n"
				+ "[7] Return to 'REMOVE ITEM MENU'");
		option = input.nextInt();
		
			switch(option) {
			case 1:
				removeSupply("Root Boost");
				break;
			case 2:
				removeSupply("Horse Dung");
				break;
			case 3:
				removeSupply("Fertiliser");
				break;
			case 4:
				removeSupply("Grains");
				break;
			case 5:
				removeSupply("Hay");
				break;
			case 6:
				removeSupply("Vitamins");
				break;
			case 7:
				endDo = true;
				break;
			}while(!endSwitch);
		}while(!endDo);
		
		removeFromCart();
		
	}
	
	/**
	 * Removes the specified supply,
	 * @param
	 */
	private void removeSupply(String item) {
		
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
			System.out.println("Sorry " + item + " is not in your cart");
		}
	}
	
	/**
	 * User interface to ask what 'Animal' they would like to remove
	 */
	private void removeAnimalFromCart() {
	
		int option = 0;            // tracks the option chosen
		boolean endDo = false;     // Ends the do-while loop only when a suitable optional has been chosen 
		boolean endSwitch = true;  // Switch ends after every iteration
		do {
		System.out.println("What 'Animal' would you like to remove?");
		System.out.println("[1] Pig\n"
				+ "[2] Sheep\n"
				+ "[3] Cow\n"
				+ "[4] Return to 'REMOVE ITEM MENU'");
		option = input.nextInt();
		
			switch(option) {
			case 1:
				removeAnimal("Pig");
				break;
			case 2:
				removeAnimal("Sheep");
				break;
			case 3:
				removeAnimal("Cow");
				break;
			case 4:
				endDo = true;
				break;
			}while(!endSwitch);
		}while(!endDo);
		
		removeFromCart();
		
	}
	/**
	 * Removes the 'Animal' chosen from 'removeAnimalFromCart() interface
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
	
	/**
	 * User interface to get inputs for what 'Crop' to sell
	 */
	private void sellCrops() {
		
		int sell = 0;
		boolean endDo = false;    // Ends the do-while loop only when a suitable optional has been chosen 
		boolean endSwitch = true; // Switch ends after every iteration
		
		do {
		System.out.println("What Crop would you like to sell?");
		System.out.println("[1] Carrot\n"
				         + "[2] Capsicum\n"
				         + "[3] Broccoli\n"
				         + "[4] Potato\n"
			           	 + "[5] Avocado\n"
				         + "[6] Cauliflower\n"
				         + "[7] Return to 'REMOVE ITEM MENU'");
		sell = input.nextInt();
		
			switch(sell) {
			case 1:
				exchangeCrop("Carrot");
				break;
			case 2:
				exchangeCrop("Capsicum");
				break;
			case 3:
				exchangeCrop("Broccoli");
				break;
			case 4:
				exchangeCrop("Potato");
				break;
			case 5:
				exchangeCrop("Avocado");
				break;
			case 6:
				exchangeCrop("Cauliflower");
				break;
			case 7:
				endDo = true;
				break;
			}while(!endSwitch);
		}while(!endDo);
		
		removeFromCart();
	}
	
	/**
	 * Removes the specified crop from the cart
	 * @param item
	 */
	private void exchangeCrop(String item) {
		boolean invalid = true;           // If item is not in farmsCrops the invalid is true
		double profit = 0.00;             // Initialize cost
		
		for (Crop toSell : farmOwner.getCrops()) {         
			if (toSell.getType() == item && toSell.getState() == "Harvest") {   // Finds 'Crop' to sell, once found it checks if the 'State' is 'Harvest'
				profit = toSell.getSellPrice();                                     // Gets the price of item to remove
				farmOwner.removeCrop(toSell);                                   // removes item object from cart
				System.out.println(item + " has been SOLD\n");
				invalid = false;                                                // Item was in cart,invalid is false
				break;                                                          // End loop
				}
		}
		farmOwner.addToWallet(profit);                                          // Increases profit of farm by 'sellPrice'

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
		if (invalid) {    // If item is not in cart
		System.out.println("Sorry " + item +" is not in your cart");
		}
	}
	
	/**
	 * User interface to get input for checkout
	 */
	private void checkout() {
		
		int option = 0;
		
		//Check to see if farmOwner can afford the items in the cart
		if (farmOwner.getMoney() >= cartCost){
		}else {
			System.out.println("Sorry you do not have enough money, "
					         + "Please remove some items from the cart");
			viewMarketOptions();
		}
		
		// Can afford items, so continue
		boolean endDo = false;     // Ends the do-while loop only when a suitable optional has been chosen 
		boolean endSwitch = true;  // Switch ends after every iteration
		do {
		System.out.println("What would you like to do?");
		System.out.println("[1] Pay for cart\n"
				         + "[2] Return to 'FRONT DESK'");
		option = input.nextInt();
		
		switch(option) {
			case 1:
				completeCheckout();
				endDo = true;
				break;
			case 7:
				endDo = true;
				break;
			}while(!endSwitch);
		}while(!endDo);
		
		viewMarketOptions();
	}
	
	
	private void completeCheckout() {
		
		boolean end = false;
		int option = 0;
		String newName = "";
		
		boolean discountStore = false;
		boolean fasterCropGrowth = false;
		boolean happyAnimal = false;
		
		if (farmOwner.getType() == "Discount Store") {
			discountStore = true;
		}else if (farmOwner.getType() == "Faster Crop Growth") {
			fasterCropGrowth = true;
		}else if (farmOwner.getType() == "Happy Animal") {
			happyAnimal = true;
		}
		
		// Checks for Farm Bonus "DISCOUNT STORE"
		if (discountStore) {
			cartCost = cartCost-(cartCost*0.4);
			System.out.println("Your 'Discount Store Bonus has been applied, \n"
					+ "The amount you paid was $" + cartCost + ",\n");
		}
		farmOwner.addToWallet((-1)*cartCost);     // Removes the amount of cartCost from the farmOwners wallet
		
		// Resets cartCost back to zero
		cartCost = 0;
		// Checks the status of the crops in the cart
		if (!(cropCart.isEmpty())) {
			for (Crop vegetable : cropCart) {
				// Checks to see if bonus applies
				if (fasterCropGrowth) {
					vegetable.alterCropTime(1);
				}		
				farmOwner.addCrop(vegetable);    // Adds crop to farm
			}
			cropCart.clear();                    // Clears the ccropCart
		}
		if (!(suppliesCart.isEmpty())) {
			for (Supplies item : suppliesCart) {
				farmOwner.addSupply(item);
			}
			suppliesCart.clear();                // Clears the suppliesCart
		}
		if (!(animalCart.isEmpty())) {
			for (Animal animal : animalCart) {
				end = true;
				System.out.println("Would you like to name your " + animal.getType() + "?\n");
				System.out.println("[1] Yes i would like to name my " + animal.getType() + ",\n"
						         + "[2] No thank you im fine with " + animal.getName() + ",\n");
				
				// Checks to see if bonus applies
				if (happyAnimal) {
					animal.addHealthBonus();
				}
					
				option = input.nextInt();
				switch(option) {
					case 1:
						
						System.out.println("Please Enter new name,");
						newName = input.next();
						animal.setName(newName);     // GETTING SCANNER ERROR WHEN NAMING
						break;
					case 2:
						break;
						
				}while(!(end)); // end do-while
				farmOwner.addAnimal(animal);  // add to farms animals
				}
			animalCart.clear();
			viewMarketOptions();
		}
	}
	
	private void launchOpenMarket() {
		OpenMarket openMarketScreen = new OpenMarket(this);
	}
	
	public void launchMarketCrops() {
		MarketCrops marketCropsScreen = new MarketCrops(this);
	}
	
	public void closeMarketCrops(MarketCrops marketCropsScreen) {
		marketCropsScreen.closeWindow();
		launchOpenMarket();
	}
	
	public void launchMarketAnimals() {
		MarketAnimals marketAnimalsScreen = new MarketAnimals(this);
		
	}
	
	public void closeMarketAnimals(MarketAnimals marketAnimalsScreen) {
		marketAnimalsScreen.closeWindow();
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
