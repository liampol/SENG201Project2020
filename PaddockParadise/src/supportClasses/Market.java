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
		System.out.println("Welcome to the General Market\nHow can I help?");
		System.out.println("If you have either:\n"
				+ "Discount Store Farm Type or Faster Crop Growth Farm Type, these bonuses will be shown at checkout:");
		System.out.println("The items sold here are:\n"
				+ "Crops:\n"
				+ "Cauliflower: Cost = $30.00, Sell Price = $60.00 after 4 days, \n"
				+ "Avocado: Cost = $30.00,Sell Price = $60.00 after 4 days,\n"
				+ "Potato: Cost = $15.00, Sell Price = $25.00 after 3 days\n"
				+ "Broccoli: Cost = $15.00, Sell Price = $25.00 after 3 days,\n"
				+ "Capsicum: Cost = $10.00, Sell Price = $17.50.00 after 2 days\n"
				+ "Carrot: Cost = $10.00, Sell Price = $17.50.00 after 2 days,\n"
				+ "Animals:(Animals give money only if tended to)\n"
				+ "Cow: Cost = $50.00, yield = $400.00,\n"
				+ "Sheep: Cost = $20.00, yield = $200.00,\n"
				+ "Pig: Cost = $10.00, yield = $100.00\n"
				+ "Supplies:\n"
				+ "(For Crops)"
				+ "Root Boost: Cost = $55.00, Attribute = Boosts chosen crop by 3 days\n"
				+ "Fertiliser:Cost = $20.00, Attribute = Boosts chosen crop by 2 days\n"
				+ "Horse-Dung: Cost = $10.00, Attribute = Boosts chosen crop by 1 days\n"
				+ "(For Animals)\n"
				+ "Grains: Cost = $100.00, Attribute = Keeps animal healthier for 2 days\n"
				+ "Vitamins: Cost = $300.00, Attribute = Keeps animal happy and healthier for 3 days"
				+ "Hay: Cost = $100.00, Attribute = Keeps animal happy for 1 day");
		Scanner frontDesk = new Scanner(System.in);
		int firstOption = 0;
		boolean correct = false; 
		
		do {
			System.out.println("Please choose option by typing the corresponding number");
			System.out.println("Would you like to:\n"
					+ "[1] Buy Crops\n"
					+ "[2] Buy Animals\n"
					+ "[3] Buy Farm Supplies\n"
					+ "[4] Sell Crops\n");
			firstOption = frontDesk.nextInt();
			if (firstOption <= 4 && firstOption >=1) {
				correct = true;
				}else {
					System.out.println("Invalid option please choose again");
				}
			}while (!(correct));
	}
	
	/**
	 * Adds Fertiliser to cart as well as adds the cost to cartCost
	 */
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
		toString("current cart");
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
		
		// Test for adding Animals
		openMarket.addCow();                     // Test addCow() 
		openMarket.addSheep();                   // Test addSheep()
		openMarket.addPig();                     // Test addPig()
		openMarket.printCart();                  // Test printCart() with multiple items
		openMarket.printCartCost();              // Test printCartCost() with multiple items in cart
		
		// Test for adding Crops
		openMarket.addCarrots();                 // Test addCarrots
		openMarket.addPotato();                  // Test addCarrots
		openMarket.addBroccoli();                // Test addBroccoli
		openMarket.addCapsicum();                // Test addCapsicum
		openMarket.addCauliflower();             // Test addCauliflower
		openMarket.addAvocado();                 // Test addAvocado
		openMarket.printCart();                  // Test printCart() with multiple items
		openMarket.printCartCost();              // Test printCartCost() with multiple items in cart
		
		//Test for adding Supplies
		openMarket.addFertiliser();
		openMarket.addGrains();
		openMarket.addHorseDung();
		openMarket.addRootBoost();
		openMarket.addHay();
		openMarket.addVitamins();
		
		//Test remove items
		openMarket.removeAnimal("Cow");
		openMarket.removeCrop("Carrot");
		openMarket.removeCrop("Carrot");
		openMarket.removeSupply("Fertiliser");
		openMarket.removeSupply("Vitamins");
		
		
	}
}
