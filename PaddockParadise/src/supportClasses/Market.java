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
	
	public void viewMarketOptions() {
		System.out.println("WELCOME TO THE GENERALMARKET!!\n\nHow can I help you today?");
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
		int firstOption = 0;
		boolean correct = false; 
		
		do {
			System.out.println("Please choose option by typing the corresponding number");
			System.out.println("Would you like to:\n"
					+ "[1] Buy Crops\n"
					+ "[2] Buy Animals\n"
					+ "[3] Buy Farm Supplies\n"
					+ "[4] Sell Crops\n"
					+ "[5] Remove items from cart\n");
			firstOption = frontDesk.nextInt();
			if (firstOption == 1) {
				buyCrops();
				correct = true;
				break;
			}else if (firstOption == 2) {
				buyAnimals();
				correct = true;
				break;
			}else if (firstOption == 3) {
				buySupplies();
				correct = true;
				break;
			}else if (firstOption == 4){
				//Need to implement Sell crops
			}else if (firstOption == 5) {
				
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
				+ "[7] Return to previous window");
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
		boolean end = false;
		System.out.println("What animals would you like to add to cart?\n"
				+ "[1] Sheep $20.00\n"
				+ "[2] Cow $50.00\n"
				+ "[3] Pig $10.00\n"
				+ "[4] Return to previous window");
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
			end = true;
			break;
		}while(!(end));
		
		animalToBuy.close();
		viewMarketOptions();
		
	}
	
	public void buySupplies() {
		
		Scanner suppliesToBuy = new Scanner(System.in);
		int added = 0;
		boolean end = false;
		System.out.println("What supplies would you like to add to cart?\n"
				+ "[1] Grains: Cost = $100.00, Attribute = Keeps animal healthier for 2 days\n"
				+ "[2] Vitamins: Cost = $300.00, Attribute = Keeps animal happy and healthier for 3 days\n"
				+ "[3] Hay: Cost = $100.00, Attribute = Keeps animal happy for 1 day\n"
				+ "[4] Root Boost: Cost = $55.00, Attribute = Boosts chosen crop by 3 days\n"
				+ "[5] Fertiliser:Cost = $20.00, Attribute = Boosts chosen crop by 2 days\n"
				+ "[6] Horse-Dung: Cost = $10.00, Attribute = Boosts chosen crop by 1 days\n"
				+ "[7] Return to previous window");
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
			end = true;
			break;
		}while(!(end));
		
		suppliesToBuy.close();
		viewMarketOptions();
	}
	private void addFertiliser() {
			Fertiliser addedFertiliser = new Fertiliser();
			cartCost += addedFertiliser.getPrice(); 
			suppliesCart.add(addedFertiliser);
			System.out.println("Fertiliser has been added to cart");
	}
	
	/**
	 * Adds Horse-Dung to cart as well as adds the cost to cartCost
	 */
	public void addHorseDung() {
		HorseDung addedHorseDung= new HorseDung();
		cartCost += addedHorseDung.getPrice(); 
		suppliesCart.add(addedHorseDung);
		System.out.println("Horse-Dung has been added to cart");
	}
	
	/**
	 * Adds Root-Boost to cart as well as adds the cost to cartCost
	 */
	public void addRootBoost() {
		RootBoost addedRootBoost= new RootBoost();
		cartCost += addedRootBoost.getPrice(); 
		suppliesCart.add(addedRootBoost);
		System.out.println("RootBoost has been added to cart");
	}
	
	/**
	 * Adds grains to cart as well as adds the cost to cartCost
	 */
	public void addGrains() {
			Grains addedGrains = new Grains();
			cartCost += addedGrains.getPrice(); 
			suppliesCart.add(addedGrains);
			System.out.println("Grains have been added to cart");
	}
	
	/**
	 * Adds Vitamins to cart as well as adds the cost to cartCost
	 */
	public void addVitamins() {
			Vitamins addedVitamins = new Vitamins();
			cartCost += addedVitamins.getPrice(); 
			suppliesCart.add(addedVitamins);
			System.out.println("Vitamins have been added to cart");
	}
	
	/**
	 * Adds Hay to cart as well as adds the cost to cartCost
	 */
	public void addHay() {
		Hay addedHay = new Hay();
		cartCost += addedHay.getPrice(); 
		suppliesCart.add(addedHay);
		System.out.println("Hay has been added to cart");
	}
	
	/**
	 * Adds Cow to cart as well as adds the cost to cartCost
	 */
	private void addCow() {
		Cow addedCow = new Cow();
		cartCost += addedCow.getPrice();
		animalCart.add(addedCow);
		System.out.println("Cow has been added to cart");	
	}
	
	/**
	 * Adds Sheep to cart as well as adds the cost to cartCost
	 */
	private void addSheep() {
		Sheep addedSheep = new Sheep();
		cartCost += addedSheep.getPrice();
		animalCart.add(addedSheep);
		System.out.println("Sheep has been added to cart");	
	}
	
	/**
	 * Adds Pig to cart as well as adds the cost to cartCost
	 */
	private void addPig() {
		Pig addedPig = new Pig();
		cartCost += addedPig.getPrice();
		animalCart.add(addedPig);
		System.out.println("Sheep has been added to cart");	
	}
	
	/**
	 * Adds Carrots to cart as well as adds the cost to cartCost
	 */
	private void addCarrots() {
		Carrot addedCarrots = new Carrot();
		cartCost += addedCarrots.getPrice();
		cropCart.add(addedCarrots);
		System.out.println("Carrots has been added to cart");	
	}
	
	/**
	 * Adds Capsicum to cart as well as adds the cost to cartCost
	 */
	private void addCapsicum() {
		Capsicum addedCapsicum = new Capsicum();
		cartCost += addedCapsicum.getPrice();
		cropCart.add(addedCapsicum);
		System.out.println("Capsicum has been added to cart");	
	}
	
	/**
	 * Adds Potato's to cart as well as adds the cost to cartCost
	 */
	private void addPotato() {
		Potato addedPotatos = new Potato();
		cartCost += addedPotatos.getPrice();
		cropCart.add(addedPotatos);
		System.out.println("Potatos has been added to cart");	
	}
	
	/**
	 * Adds Broccoli to cart as well as adds the cost to cartCost
	 */
	private void addBroccoli() {
		Broccoli addedBroccoli = new Broccoli();
		cartCost += addedBroccoli.getPrice();
		cropCart.add(addedBroccoli);
		System.out.println("Broccoli has been added to cart");	
	}
	
	/**
	 * Adds Cauliflower to cart as well as adds the cost to cartCost
	 */
	private void addCauliflower() {
		Cauliflower addedCauliflower = new Cauliflower();
		cartCost += addedCauliflower.getPrice();
		cropCart.add(addedCauliflower);
		System.out.println("Cauliflower has been added to cart");	
	}
	
	/**
	 * Adds Avocado to cart as well as adds the cost to cartCost
	 */
	private void addAvocado() {
		Avocado addedAvocado = new Avocado();
		cartCost += addedAvocado.getPrice();
		cropCart.add(addedAvocado);
		System.out.println("Avocado has been added to cart");	
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
		//toString("current cart");
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
	
	private void removeFromCart() {
		
		Scanner removeItem = new Scanner(System.in);
		
		System.out.println("What would you like to remove?");
		
		
	}
	
	/**
	 * Removes the specified crop from the cart
	 * @param item
	 */
	private void removeCrop(String item) {
		boolean empty = true;
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
