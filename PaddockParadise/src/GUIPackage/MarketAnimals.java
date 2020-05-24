package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import MainClassesPackage.Farm;
import MainClassesPackage.Farmer;
import MainClassesPackage.Market;
import MainClassesPackage.PaddockParadiseManager;

public class MarketAnimals {

	private JFrame marketAnimalsWindow;
	private static Market manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketAnimals window = new MarketAnimals(manager);
					window.marketAnimalsWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarketAnimals(Market newManager) {
		manager = newManager;
		initialize();
		marketAnimalsWindow.setVisible(true);
		
	}
	
	public void closeWindow() {
		marketAnimalsWindow.dispose();
	}
	
	private void finishedWindow() {
		manager.closeMarketAnimals(this);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		marketAnimalsWindow = new JFrame();
		marketAnimalsWindow.setTitle("Market Animal");
		marketAnimalsWindow.setBounds(100, 100, 930, 660);
		marketAnimalsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Border border = BorderFactory.createLineBorder(Color.black);
		Border raiseBorder = BorderFactory.createRaisedBevelBorder();
		marketAnimalsWindow.getContentPane().setLayout(null);
		
		JLabel cartCost = new JLabel("Current Cart Total: $");
		cartCost.setFont(new Font("Tahoma", Font.BOLD, 18));
		cartCost.setBounds(525, 71, 291, 65);
		marketAnimalsWindow.getContentPane().add(cartCost);
		
		
		JLabel marketTitle = new JLabel("<html>Animals!</html>");
		marketTitle.setFont(new Font("Tahoma", Font.BOLD, 27));
		marketTitle.setHorizontalAlignment(SwingConstants.CENTER);
		marketTitle.setBounds(243, 11, 407, 31);
		marketAnimalsWindow.getContentPane().add(marketTitle);
		
		JLabel border1 = new JLabel("");
		border1.setFont(new Font("Tahoma", Font.BOLD, 13));
		border1.setBounds(10, 55, 879, 116);
		border1.setBorder(border);
		marketAnimalsWindow.getContentPane().add(border1);
		
		JLabel andyDialog = new JLabel("<html>What would you like to add to your cart?</html>");
		andyDialog.setHorizontalAlignment(SwingConstants.CENTER);
		andyDialog.setFont(new Font("Tahoma", Font.BOLD, 18));
		andyDialog.setBounds(161, 60, 240, 102);
		marketAnimalsWindow.getContentPane().add(andyDialog);
		
		JLabel andyImg = new JLabel("");
		andyImg.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/shopKeeper.png")));
		andyImg.setBounds(21, 60, 130, 102);
		marketAnimalsWindow.getContentPane().add(andyImg);
		
		JLabel displayLbl = new JLabel("");
		displayLbl.setHorizontalAlignment(SwingConstants.CENTER);
		displayLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		displayLbl.setBounds(10, 494, 879, 65);
		displayLbl.setBorder(border);
		displayLbl.setForeground(Color.green);
		marketAnimalsWindow.getContentPane().add(displayLbl);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				
			}
		});
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		closeBtn.setBounds(707, 570, 182, 38);
		closeBtn.setBorder(raiseBorder);
		marketAnimalsWindow.getContentPane().add(closeBtn);
		
		JButton addCarrot = new JButton("Add Cow");
		addCarrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addCow();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Cow has been added to cart!");
			}
		});
		addCarrot.setBounds(21, 444, 120, 23);
		addCarrot.setBorder(raiseBorder);
		marketAnimalsWindow.getContentPane().add(addCarrot);
		
		JButton btnAddBroccoli = new JButton("Add Pig");
		btnAddBroccoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addPig();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Pig has been added to cart!");
			}
		});
		btnAddBroccoli.setBounds(338, 444, 120, 23);
		btnAddBroccoli.setBorder(raiseBorder);
		marketAnimalsWindow.getContentPane().add(btnAddBroccoli);
		
		JButton btnRemoveCarrots = new JButton("Remove Cow");
		btnRemoveCarrots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeAnimal("Cow");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemoveCarrots.setBounds(161, 444, 120, 23);
		btnRemoveCarrots.setBorder(raiseBorder);
		marketAnimalsWindow.getContentPane().add(btnRemoveCarrots);
		
		JButton btnRemoveBroccoli = new JButton("Remove Pig");
		btnRemoveBroccoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeAnimal("Pig");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
			}
		});
		btnRemoveBroccoli.setBounds(468, 444, 120, 23);
		btnRemoveBroccoli.setBorder(raiseBorder);
		marketAnimalsWindow.getContentPane().add(btnRemoveBroccoli);
		
		JButton btnAddPotatoes = new JButton("Add Sheep");
		btnAddPotatoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addSheep();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Potato has been added to cart!");
				
			}
		});
		btnAddPotatoes.setBounds(626, 444, 120, 23);
		btnAddPotatoes.setBorder(raiseBorder);
		marketAnimalsWindow.getContentPane().add(btnAddPotatoes);
		
		JButton btnRemovePotatoes = new JButton("Remove Sheep");
		btnRemovePotatoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeCrop("Sheep");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemovePotatoes.setBounds(756, 444, 120, 23);
		btnRemovePotatoes.setBorder(raiseBorder);
		marketAnimalsWindow.getContentPane().add(btnRemovePotatoes);
		
		JLabel cowBorder = new JLabel("");
		cowBorder.setBounds(10, 182, 291, 301);
		cowBorder.setBorder(border);
		marketAnimalsWindow.getContentPane().add(cowBorder);
		
		JLabel cowImage = new JLabel("");
		cowImage.setIcon(new ImageIcon(MarketAnimals.class.getResource("/Images/animals/cow.png")));
		cowImage.setBounds(77, 196, 140, 84);
		marketAnimalsWindow.getContentPane().add(cowImage);
		
		JLabel pigBorder = new JLabel("");
		pigBorder.setFont(new Font("Tahoma", Font.BOLD, 13));
		pigBorder.setBounds(327, 182, 278, 301);
		pigBorder.setBorder(border);
		marketAnimalsWindow.getContentPane().add(pigBorder);
		
		JLabel pigImage = new JLabel();
		pigImage.setIcon(new ImageIcon(MarketAnimals.class.getResource("/Images/animals/pig.png")));
		pigImage.setBounds(398, 196, 140, 84);
		marketAnimalsWindow.getContentPane().add(pigImage);
		
		JLabel sheepBorder = new JLabel("");
		sheepBorder.setBounds(617, 182, 272, 301);
		sheepBorder.setBorder(border);
		marketAnimalsWindow.getContentPane().add(sheepBorder);
		
		JLabel sheepImage = new JLabel();
		sheepImage.setIcon(new ImageIcon(MarketAnimals.class.getResource("/Images/animals/sheep.png")));
		sheepImage.setBounds(676, 196, 140, 84);
		marketAnimalsWindow.getContentPane().add(sheepImage);
		
		JLabel cowStat = new JLabel("<html>Name: " + manager.sheep.getName() 
		+ "<br>Cost: $" + manager.sheep.getPrice() 
		+ "<br>Health State: " + manager.sheep.getHealthState() 
		+ "<br>Emotional State: " + manager.sheep.getEmotionalState()
		+ "<br>Daily Max Profit: $" + manager.sheep.getMoneyBonus() + "</html>");
		cowStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		cowStat.setBounds(21, 291, 260, 142);
		marketAnimalsWindow.getContentPane().add(cowStat);
		
		JLabel pigStat = new JLabel("<html>Name: " + manager.pig.getName() 
		+ "<br>Cost: $" + manager.pig.getPrice() 
		+ "<br>Health State: " + manager.pig.getHealthState() 
		+ "<br>Emotional State: " + manager.pig.getEmotionalState()
		+ "<br>Daily Max Profit: $" + manager.pig.getMoneyBonus() + "</html>");
		pigStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		pigStat.setBounds(338, 291, 250, 142);
		marketAnimalsWindow.getContentPane().add(pigStat);
		
		JLabel sheepStat = new JLabel("<html>Name: " + manager.cow.getName() 
		+ "<br>Cost: $" + manager.cow.getPrice() 
		+ "<br>Health State: " + manager.cow.getHealthState() 
		+ "<br>Emotional State: " + manager.cow.getEmotionalState()
		+ "<br>Daily Max Profit: $" + manager.cow.getMoneyBonus() + "</html>"); 
		sheepStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		sheepStat.setBounds(626, 291, 248, 142);
		marketAnimalsWindow.getContentPane().add(sheepStat);
	}

}

