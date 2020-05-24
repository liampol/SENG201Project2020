package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;

import MainClassesPackage.*;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpenMarket {

	private JFrame openMarketWindow;
	private static PaddockParadiseManager ppmManager;
	private static Market manager;
	private static Farm farm;
	private static Farmer farmer;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenMarket window = new OpenMarket(manager);
					window.openMarketWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OpenMarket(Market newManager) {
		manager = newManager;
		ppmManager = manager.getManager();
		farm = ppmManager.getFarm();
		farmer = ppmManager.getFarmer();
		initialize();
		openMarketWindow.setVisible(true);
	}
	
	private void addCrops() {
		manager.launchMarketCrops();
	}
	
	private void addAnimals() {
		manager.launchMarketAnimals();
	}
	
	
	public void closeWindow() {
		openMarketWindow.dispose();
	}
	
	private void finishedWindow() {
		manager.closeMarketWindow(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		openMarketWindow = new JFrame();
		openMarketWindow.setTitle("General Market");
		openMarketWindow.setBounds(100, 100, 572, 617);
		openMarketWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openMarketWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		Border raiseBorder = BorderFactory.createRaisedBevelBorder();
		
		JLabel andyImg = new JLabel("");
		andyImg.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/shopKeeper.png")));
		andyImg.setBounds(25, 58, 130, 102);
		openMarketWindow.getContentPane().add(andyImg);
		
		JLabel marketTitle = new JLabel("<html>WELCOME TO THE GENERAL MARKET!</html>");
		marketTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		marketTitle.setHorizontalAlignment(SwingConstants.CENTER);
		marketTitle.setBounds(78, 11, 407, 31);
		openMarketWindow.getContentPane().add(marketTitle);
		
		JLabel border1 = new JLabel("");
		border1.setFont(new Font("Tahoma", Font.BOLD, 13));
		border1.setBounds(10, 46, 346, 125);
		border1.setBorder(border);
		openMarketWindow.getContentPane().add(border1);
		
		JLabel andyDialog = new JLabel("<html>Hi,  I'm the shop Keeper, you can call me Andy.<br><br>How can I help you today</html>");
		andyDialog.setFont(new Font("Tahoma", Font.BOLD, 13));
		andyDialog.setBounds(182, 58, 174, 72);
		openMarketWindow.getContentPane().add(andyDialog);
		
		JButton exitBtn = new JButton("Exit Market");
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		exitBtn.setBounds(375, 529, 158, 38);
		exitBtn.setForeground(Color.RED);
		exitBtn.setBorder(raiseBorder);
		openMarketWindow.getContentPane().add(exitBtn);
		
		JButton buyCropBtn = new JButton("Buy Crops");
		buyCropBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCrops();
			}
		});
		buyCropBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		buyCropBtn.setBounds(36, 343, 147, 38);
		buyCropBtn.setBorder(raiseBorder);
		openMarketWindow.getContentPane().add(buyCropBtn);
		
		JButton buyAnimalBtn = new JButton("Buy Animals");
		buyAnimalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAnimals();
			}
		});
		buyAnimalBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		buyAnimalBtn.setBounds(199, 343, 149, 38);
		buyAnimalBtn.setBorder(raiseBorder);
		openMarketWindow.getContentPane().add(buyAnimalBtn);
		
		JButton buySuppliesBtn = new JButton("Buy Supplies");
		buySuppliesBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		buySuppliesBtn.setBounds(375, 343, 158, 38);
		buySuppliesBtn.setBorder(raiseBorder);
		openMarketWindow.getContentPane().add(buySuppliesBtn);
		
		JButton viewCartBtn = new JButton("View Cart");
		viewCartBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		viewCartBtn.setBounds(36, 534, 147, 33);
		viewCartBtn.setBorder(raiseBorder);
		openMarketWindow.getContentPane().add(viewCartBtn);
		
		JLabel cartCostLbl = new JLabel("Cart Cost: $" + manager.getCartCost());
		cartCostLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		cartCostLbl.setBounds(366, 46, 167, 30);
		openMarketWindow.getContentPane().add(cartCostLbl);
		
		JButton checkoutBtn = new JButton("Checkout");
		checkoutBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkoutBtn.setBounds(199, 534, 149, 33);
		checkoutBtn.setBorder(raiseBorder);
		openMarketWindow.getContentPane().add(checkoutBtn);
		
		JLabel cropsImage = new JLabel("");
		cropsImage.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/cropsImage.jpg")));
		cropsImage.setBounds(36, 207, 147, 125);
		openMarketWindow.getContentPane().add(cropsImage);
		
		JLabel animalImage = new JLabel("");
		animalImage.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/animalImage.jpg")));
		animalImage.setBounds(199, 207, 149, 125);
		openMarketWindow.getContentPane().add(animalImage);
		
		JLabel exitImage = new JLabel("");
		exitImage.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/exitImage.jpg")));
		exitImage.setBounds(375, 393, 158, 125);
		openMarketWindow.getContentPane().add(exitImage);
		
		JLabel cartImage = new JLabel("");
		cartImage.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/cartImage.jpg")));
		cartImage.setBounds(36, 392, 147, 131);
		openMarketWindow.getContentPane().add(cartImage);
		
		JLabel checkoutImage = new JLabel("");
		checkoutImage.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/checkout.jpg")));
		checkoutImage.setBounds(199, 392, 147, 131);
		openMarketWindow.getContentPane().add(checkoutImage);
		
		JLabel suppliesImage = new JLabel("");
		suppliesImage.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/suppliesImage.jpg")));
		suppliesImage.setBounds(375, 207, 158, 131);
		openMarketWindow.getContentPane().add(suppliesImage);
	}

}
