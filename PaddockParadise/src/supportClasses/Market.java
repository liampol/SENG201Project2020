package supportClasses;
import animalExtend.*;

import cropExtend.*;
import java.util.ArrayList;
import MainClassesPackage.*;
import extendSupplies.*;
import java.util.Scanner;
import GUIPackage.*;



public class Market {
	
	private ArrayList<Crop> cropCart;            // This variable is used to keep track of Crops added to cart
	private ArrayList<Animal> animalCart;        // This variable is used to keep track of Crops added to cart
	private ArrayList<Supplies> suppliesCart;    // This variable is used to keep track of Crops added to cart
	private double cartCost;
	private Farm farmOwner;
	
	// Crops on display
	Cauliflower cauliflower = new Cauliflower();
	Carrot carrot = new Carrot();
	Potato potato = new Potato();
	Capsicum capsicum = new Capsicum();
	Avocado avocado = new Avocado();
	Broccoli broccoli = new Broccoli();
	
	// Animals on display
	Pig pig = new Pig();
	Cow cow = new Cow();
	Sheep sheep = new Sheep();
	
	//Supplies on  display
	RootBoost rootBoost = new RootBoost();
	Fertiliser fertiliser = new Fertiliser();
	HorseDung horseDung = new HorseDung();
	Grains grain = new Grains();
	Hay hay = new Hay();
	Vitamins vitamin = new Vitamins();
	
	// track number of each item added to cart
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
	public Market(Farm currentFarmOwner) {
		
		
		farmOwner = currentFarmOwner;
		animalCart = new ArrayList<Animal>();
		cropCart = new ArrayList<Crop>();
		suppliesCart = new ArrayList<Supplies>();
		cartCost = 0.00;
		viewMarketOptions();
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
		System.out.printf("Your CURRENT BALANCE: $" + farmOwner.getMoney()+ "\n");
		System.out.println("CURRENT CART COST: $" + cartCost);
		printCart();
		Scanner frontDesk = new Scanner(System.in);
		int option = 0;
		boolean correct = false; 
		
		do {
			System.out.println("Please choose option by typing the corresponding number");
			System.out.println("Would you like to:\n"
					+ "[1] Buy Crops\n"
					+ "[2] Buy Animals\n"
					+ "[3] Buy Farm Supplies\n"
					+ "[4] Sell Crops\n"
					+ "[5] Remove items from cart\n"
					+ "[6] Checkout\n"
					+ "[7] EXIT SHOP\n");  // Need to implement some notification to double check user would like to 
			option = frontDesk.nextInt();
			if (option == 1) {
				buyCrops();
				correct = true;
				break;
			}else if (option == 2) {
				buyAnimals();
				correct = true;
				break;
			}else if (option == 3) {
				buySupplies();
				correct = true;
				break;
			}else if (option == 4){
				//Need to implement Sell crops
			}else if (option == 5) {
				removeFromCart();
			}else if(option == 6) {
				// need to implement checkout
				}else {
					System.out.println("Invalid option please choose again");
				}
			}while (!(correct));
		frontDesk.close();
	}
	
	/**
	 * Adds Fertiliser to cart as well as adds the cost to cartCost
	 */
	
	public void buyCrops() {
		
		Scanner cropToBuy = new Scanner(System.in);
		int added = 0;
		boolean endSwitch = true; // Should always be true to end switch
		boolean endDo = false;     // Only true when Do-while ends and returns to previous menu
		do {
		System.out.println("What crops would you like to add to cart?\n"
				+ "[1] Carrot $10.00\n"
				+ "[2] Broccoli $15.00\n"
				+ "[3] Capsicum $20.00\n"
				+ "[4] Avocado $30.00\n"
				+ "[5] Potato $15.00\n"
				+ "[6] Cauliflower$30.00\n"
				+ "[7] Return to 'FRONT DESK'");
		added = cropToBuy.nextInt();
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
		cropToBuy.close();
	}
	
	public void buyAnimals() {
		
		Scanner animalToBuy = new Scanner(System.in);
		int added = 0;
		boolean endSwitch = true; // Always ends through each iteration
		boolean endDo = false;    // Ends only when user wants to return to "FRONT DESK"
		
		do {
			System.out.println("What animals would you like to add to cart?\n"
					+ "[1] Sheep $20.00\n"
					+ "[2] Cow $50.00\n"
					+ "[3] Pig $10.00\n"
					+ "[4] Return to 'FRONT DESK'");
			added = animalToBuy.nextInt();
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
		animalToBuy.close();
		
	}
	
	public void buySupplies() {
		
		Scanner suppliesToBuy = new Scanner(System.in);
		int added = 0;
		boolean endSwitch = true; // Always exit Switch after each iteration
		boolean endDo = false;    // Only exit do-while loop when returning back to "FRONT DESK"
		do {
				
			System.out.println("What supplies would you like to add to cart?\n"
					+ "[1] Grains: Cost = $100.00, Attribute = Keeps animal healthier for 2 days\n"
					+ "[2] Vitamins: Cost = $300.00, Attribute = Keeps animal happy and healthier for 3 days\n"
					+ "[3] Hay: Cost = $100.00, Attribute = Keeps animal happy for 1 day\n"
					+ "[4] Root Boost: Cost = $55.00, Attribute = Boosts chosen crop by 3 days\n"
					+ "[5] Fertiliser:Cost = $20.00, Attribute = Boosts chosen crop by 2 days\n"
					+ "[6] Horse-Dung: Cost = $10.00, Attribute = Boosts chosen crop by 1 days\n"
					+ "[7] Return to 'FRONT DESK'");
			added = suppliesToBuy.nextInt();
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
		suppliesToBuy.close();
	}
	private void addFertiliser() {
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
	private void addCow() {
		Cow addedCow = new Cow();
		cartCost += addedCow.getPrice();
		animalCart.add(addedCow);
		cowCount ++;
		System.out.println("Cow has been added to cart\n");	
	}
	
	/**
	 * Adds Sheep to cart as well as adds the cost to cartCost
	 */
	private void addSheep() {
		Sheep addedSheep = new Sheep();
		cartCost += addedSheep.getPrice();
		animalCart.add(addedSheep);
		sheepCount ++;
		System.out.println("Sheep has been added to cart\n");	
	}
	
	/**
	 * Adds Pig to cart as well as adds the cost to cartCost
	 */
	private void addPig() {
		Pig addedPig = new Pig();
		cartCost += addedPig.getPrice();
		animalCart.add(addedPig);
		pigCount ++;
		System.out.println("Sheep has been added to cart\n");	
	}
	
	/**
	 * Adds Carrots to cart as well as adds the cost to cartCost
	 */
	private void addCarrots() {
		Carrot addedCarrots = new Carrot();
		cartCost += addedCarrots.getPrice();
		cropCart.add(addedCarrots);
		carrotCount  ++;
		System.out.println("Carrot has been added to cart\n");	
	}
	
	/**
	 * Adds Capsicum to cart as well as adds the cost to cartCost
	 */
	private void addCapsicum() {
		Capsicum addedCapsicum = new Capsicum();
		cartCost += addedCapsicum.getPrice();
		cropCart.add(addedCapsicum);
		capsCount ++;
		System.out.println("Capsicum has been added to cart\n");	
	}
	
	/**
	 * Adds Potato's to cart as well as adds the cost to cartCost
	 */
	private void addPotato() {
		Potato addedPotatos = new Potato();
		cartCost += addedPotatos.getPrice();
		cropCart.add(addedPotatos);
		potaCount ++;
		System.out.println("Potatos has been added to cart\n");	
	}
	
	/**
	 * Adds Broccoli to cart as well as adds the cost to cartCost
	 */
	private void addBroccoli() {
		Broccoli addedBroccoli = new Broccoli();
		cartCost += addedBroccoli.getPrice();
		cropCart.add(addedBroccoli);
		broccoliCount ++;
		System.out.println("Broccoli has been added to cart\n");	
	}
	
	/**
	 * Adds Cauliflower to cart as well as adds the cost to cartCost
	 */
	private void addCauliflower() {
		Cauliflower addedCauliflower = new Cauliflower();
		cartCost += addedCauliflower.getPrice();
		cropCart.add(addedCauliflower);
		cauliCount ++;
		System.out.println("Cauliflower has been added to cart\n");	
	}
	
	/**
	 * Adds Avocado to cart as well as adds the cost to cartCost
	 */
	private void addAvocado() {
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
	
	/**
	 * Calls the toString() method to print a the current cart cost as a dollar
	 */
	public void printCartCost() {
		toString("cart cost");
	}
	
	/*
	 * Calls the toString() method to print the current items in the cart
	 */
	private void printCart() {
		ArrayList<Integer> intItems = new ArrayList<Integer>();
		
		intItems.add(broccoliCount);
		intItems.add(carrotCount);
		intItems.add(cauliCount);
		intItems.add(avoCount);
		intItems.add(potaCount);
		intItems.add(capsCount);
		intItems.add(rootBoostCount);
		intItems.add(fertCount);
		intItems.add(grainCount);
		intItems.add(dungCount);
		intItems.add(hayCount);
		intItems.add(vitCount);
		intItems.add(cowCount);
		intItems.add(sheepCount);
		intItems.add(pigCount);

    // Prints only what items have incremented which is done only when added to cart
		if (cropCart.isEmpty() && animalCart.isEmpty() && suppliesCart.isEmpty()) {
			System.out.println("Cart is currently empty!");
			boolean end = true;
		}else {
			for (int item : intItems) {
				if (item > 0 && item == carrotCount) {
					System.out.println("Carrot: " + carrotCount);
					}else if (item > 0 && item == cauliCount) {
						System.out.println("Cauliflower: " + cauliCount);
					}else if (item > 0 && item == avoCount) { 
						System.out.println("Avocado: " + avoCount);
					}else if (item > 0 && item == potaCount) {
						System.out.println("Potato: " + potaCount);
					}else if (item > 0 && item == capsCount) {
						System.out.println("Capsicum: " + capsCount);
					}else if (item > 0 && item == broccoliCount) {
						System.out.println("Broccoli: " + broccoliCount);
					}else if (item > 0 && item == cowCount) {
						System.out.println("Cow: " + cowCount);
					}else if (item > 0 && item == pigCount) {
						System.out.println("Pig: " + pigCount);
					}else if (item > 0 && item == sheepCount) {
						System.out.println("Sheep: " + sheepCount);
					}else if (item > 0 && item == fertCount) {
						System.out.println("Fertiliser: " + fertCount);
					}else if (item > 0 && item == rootBoostCount) {
						System.out.println("Root Boost: " + rootBoostCount);
					}else if (item > 0 && item == dungCount) {
						System.out.println("Horse Dung: " + dungCount);
					}else if (item > 0 && item == hayCount) {
						System.out.println("Hay: " + hayCount);
					}else if (item > 0 && item == rootBoostCount) {
						System.out.println("Root Boost: " + rootBoostCount);
					}else if (item > 0 && item == grainCount){
						System.out.println("Grains: " + grainCount);
					}else {
						//Do Nothing
					}
			}
		}
	
	}
	
	
	private void removeFromCart() {
		
		Scanner removeItem = new Scanner(System.in);
		
		System.out.println("What would you like to remove?");
		System.out.println("[1] Crops\n"
				+ "[2] Animals\n"
				+ "[3] Supplies\n"
				+ "[4] Return to 'FRONT DESK'");
		
	}
	
	private void removeCropFromCart() {
		
	}
	
	/**
	 * Removes the specified crop from the cart
	 * @param item
	 */
	private void removeCrop(String item) {
		boolean empty = true;   // If item is not in cart
		for (Crop toRemove : cropCart) {
			if (toRemove.getType() == item) {
				double cost = toRemove.getPrice();
				cropCart.remove(toRemove);
				cartCost -= cost;
				System.out.println(item + " has been removed\n");
				empty = false;
				break;
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
		}else {
			// Pass
		}
		if (empty) {
		System.out.println("Sorry that item is not in your cart");
		}
	}
	
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
		}else if ( item == "Horse  Dung"  && dungCount > 0) {
			 dungCount --;
		}else if ( item == "Vitamins" && vitCount > 0) {
			vitCount --;
		}else if ( item == "Fertiliser" && fertCount > 0){
			fertCount --;
		}else {
			// Pass
		}
		
		if (empty) {
			System.out.println("Sorry " + item + " is not in your cart");
		}
	}
	
	private void removeAnimal(String item) {
		boolean empty = true;

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
		}else {
			// Pass
		}
		if (empty) {
			System.out.println("Sorry " + item + " is not in your cart");
			}
	}
	
	private void toString(String messageReceived) {
		
		if (messageReceived == "cart cost") {
			System.out.format("CART TOTAL: \n$%.2f \n", cartCost);
		}else if (messageReceived == "current cart") {
			if (suppliesCart.isEmpty() && cropCart.isEmpty() && animalCart.isEmpty()) {
				System.out.println("The cart is currently empty \n");
			}else {
				System.out.println("CART CONTENTS: \n");
				for (Crop item : cropCart) {
					System.out.println(item.getType());
				}
				for (Supplies item : suppliesCart) {
					System.out.println(item.getName());
				}
				for (Animal item : animalCart) {
					System.out.println(item.getType());
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		//Implemented for testing
		Farmer newFarmer = new Farmer();
		Farm newFarm = new Farm(newFarmer);
		
		Market openMarket = new Market(newFarm); // Test Market()
		openMarket.printCartCost();              // Test printCartCost() with no items added
		openMarket.printCart();                  // Test printCart() with no items
		
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
		openMarket.viewMarketOptions();
		
	}
}
