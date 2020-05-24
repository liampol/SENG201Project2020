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

public class OpenMarket1 {

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
		openMarketWindow.setBounds(100, 100, 1025, 700);
		openMarketWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openMarketWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		
		JLabel andyImg = new JLabel("");
		andyImg.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/shopKeeper.png")));
		andyImg.setBounds(25, 58, 130, 102);
		openMarketWindow.getContentPane().add(andyImg);
		
		JLabel marketTitle = new JLabel("<html>WELCOME TO THE GENERAL MARKET!</html>");
		marketTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		marketTitle.setHorizontalAlignment(SwingConstants.CENTER);
		marketTitle.setBounds(232, 11, 407, 38);
		openMarketWindow.getContentPane().add(marketTitle);
		
		JLabel border1 = new JLabel("");
		border1.setFont(new Font("Tahoma", Font.BOLD, 13));
		border1.setBounds(10, 46, 421, 125);
		border1.setBorder(border);
		openMarketWindow.getContentPane().add(border1);
		
		JLabel andyDialog = new JLabel("<html>Hi,  I'm the shop Keeper, you can call me Andy.<br><br>How can I help you today</html>");
		andyDialog.setFont(new Font("Tahoma", Font.BOLD, 13));
		andyDialog.setBounds(182, 58, 174, 72);
		openMarketWindow.getContentPane().add(andyDialog);
		
		JLabel border2 = new JLabel("");
		border2.setBounds(10, 182, 989, 433);
		border2.setBorder(border);
		openMarketWindow.getContentPane().add(border2);
		
		JLabel soldTitle = new JLabel("Items Sold At Market:");
		soldTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		soldTitle.setBounds(423, 194, 143, 14);
		openMarketWindow.getContentPane().add(soldTitle);
		
		JLabel cropBorder = new JLabel("");
		cropBorder.setBounds(25, 215, 393, 385);
		cropBorder.setBorder(border);
		openMarketWindow.getContentPane().add(cropBorder);
		
		JLabel lblNewLabel = new JLabel("Crops:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(159, 225, 115, 25);
		openMarketWindow.getContentPane().add(lblNewLabel);
		
		JLabel listCrops = new JLabel("<html> " + manager.cauliflower.getType() +  ":<br>State:" + manager.cauliflower.getState() + "<br>Sell Price: " +  
		+ manager.avocado.getDetails() + "<br><br>"
		+ manager.potato.getDetails() + "<br><br>"
		+ manager.broccoli.getDetails() + "<br><br>"
		+ manager.capsicum.getDetails( )+ "<br><br>"
		+ manager.carrot.getDetails() + "<br><br>");
		listCrops.setBounds(34, 250, 373, 338);
		openMarketWindow.getContentPane().add(listCrops);
	}

}
