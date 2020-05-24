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

import MainClassesPackage.Market;


public class MarketSupplies {

	private JFrame marketSuppliesWindow;
	private static Market manager;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketSupplies window = new MarketSupplies(manager);
					window.marketSuppliesWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarketSupplies(Market newManager) {
		manager = newManager;
		initialize();
		marketSuppliesWindow.setVisible(true);
	}
	
	public void closeWindow() {
		marketSuppliesWindow.dispose();
	}
	
	private void finishedWindow() {
		manager.closeMarketSuppliesWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		marketSuppliesWindow = new JFrame();
		marketSuppliesWindow.setTitle("Market Supplies");
		marketSuppliesWindow.setBounds(100, 100, 931, 657);
		marketSuppliesWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Border border = BorderFactory.createLineBorder(Color.black);
		Border raiseBorder = BorderFactory.createRaisedBevelBorder();
		marketSuppliesWindow.getContentPane().setLayout(null);
		
		JLabel cartCost = new JLabel("Current Cart Total: $" + manager.getCartCost());
		cartCost.setFont(new Font("Tahoma", Font.BOLD, 18));
		cartCost.setBounds(504, 60, 331, 48);
		marketSuppliesWindow.getContentPane().add(cartCost);
		
		
		JLabel marketTitle = new JLabel("<html>Supplies!</html>");
		marketTitle.setFont(new Font("Tahoma", Font.BOLD, 27));
		marketTitle.setHorizontalAlignment(SwingConstants.CENTER);
		marketTitle.setBounds(281, 11, 278, 31);
		marketSuppliesWindow.getContentPane().add(marketTitle);
		
		JLabel border1 = new JLabel("");
		border1.setFont(new Font("Tahoma", Font.BOLD, 13));
		border1.setBounds(10, 55, 879, 116);
		border1.setBorder(border);
		marketSuppliesWindow.getContentPane().add(border1);
		
		JLabel andyDialog = new JLabel("<html>What would you like to add to your cart?</html>");
		andyDialog.setHorizontalAlignment(SwingConstants.CENTER);
		andyDialog.setFont(new Font("Tahoma", Font.BOLD, 18));
		andyDialog.setBounds(161, 60, 240, 102);
		marketSuppliesWindow.getContentPane().add(andyDialog);
		
		JLabel andyImg = new JLabel("");
		andyImg.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/shopKeeper.png")));
		andyImg.setBounds(21, 60, 130, 102);
		marketSuppliesWindow.getContentPane().add(andyImg);
		
		JLabel displayLbl = new JLabel("");
		displayLbl.setHorizontalAlignment(SwingConstants.CENTER);
		displayLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		displayLbl.setBounds(10, 494, 879, 65);
		displayLbl.setBorder(border);
		displayLbl.setForeground(Color.green);
		marketSuppliesWindow.getContentPane().add(displayLbl);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				
			}
		});
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		closeBtn.setBounds(707, 570, 182, 38);
		closeBtn.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(closeBtn);
		
		JButton addGrains = new JButton("Add Grains");
		addGrains.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addGrains();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Grains has been added to cart!");
			}
		});
		addGrains.setBounds(18, 289, 120, 23);
		addGrains.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(addGrains);
		
		JButton btnAddHay = new JButton("Add Hay");
		btnAddHay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addHay();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Hay has been added to cart!");
			}
		});
		btnAddHay.setBounds(339, 289, 120, 23);
		btnAddHay.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnAddHay);
		
		JButton btnRemoveGrains = new JButton("Remove Grains");
		btnRemoveGrains.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeSupply("Grains");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemoveGrains.setBounds(158, 289, 120, 23);
		btnRemoveGrains.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnRemoveGrains);
		
		JButton btnRemoveHay = new JButton("Remove Hay");
		btnRemoveHay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeSupply("Hay");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
			}
		});
		btnRemoveHay.setBounds(468, 289, 120, 23);
		btnRemoveHay.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnRemoveHay);
		
		JButton btnAddFertiliser = new JButton("Add Fertiliser");
		btnAddFertiliser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addFertiliser();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Fertiliser has been added to cart!");
			}
		});
		btnAddFertiliser.setBounds(21, 444, 127, 23);
		btnAddFertiliser.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnAddFertiliser);
		
		JButton btnRemoveFertiliser = new JButton("Remove Fertiliser");
		btnRemoveFertiliser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeSupply("Fertiliser");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemoveFertiliser.setBounds(158, 444, 130, 23);
		btnRemoveFertiliser.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnRemoveFertiliser);
		
		JButton btnAddHorseDung = new JButton("Add Horse-Dung");
		btnAddHorseDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addHorseDung();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("HorseDung has been added to cart!");
			}
		});
		btnAddHorseDung.setBounds(339, 444, 120, 23);
		btnAddHorseDung.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnAddHorseDung);
		
		JButton btnRemoveHorseDung = new JButton("Remove Horse-Dung");
		btnRemoveHorseDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeSupply("Horse Dung");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemoveHorseDung.setBounds(468, 444, 120, 23);
		btnRemoveHorseDung.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnRemoveHorseDung);
		
		JButton btnAddRootBoost = new JButton("Add Root-Boost");
		btnAddRootBoost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addRootBoost();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Root-Boost has been added to cart!");
			}
		});
		btnAddRootBoost.setBounds(623, 444, 120, 23);
		btnAddRootBoost.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnAddRootBoost);
		
		JButton btnRemoveRootBoost = new JButton("Remove Root-Boost");
		btnRemoveRootBoost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeSupply("Root Boost");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemoveRootBoost.setBounds(753, 444, 120, 23);
		btnRemoveRootBoost.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnRemoveRootBoost);
		
		JButton btnAddVitamins = new JButton("Add Vitamins");
		btnAddVitamins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addVitamins();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Vitamins has been added to cart!");
				
			}
		});
		btnAddVitamins.setBounds(623, 289, 120, 23);
		btnAddVitamins.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnAddVitamins);
		
		JButton btnRemoveVitamins = new JButton("Remove Vitamins");
		btnRemoveVitamins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeSupply("Vitamins");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
			}
		});
		btnRemoveVitamins.setBounds(753, 289, 120, 23);
		btnRemoveVitamins.setBorder(raiseBorder);
		marketSuppliesWindow.getContentPane().add(btnRemoveVitamins);
		
		JLabel grainsBorder = new JLabel("");
		grainsBorder.setBounds(10, 182, 291, 145);
		grainsBorder.setBorder(border);
		marketSuppliesWindow.getContentPane().add(grainsBorder);
		
		JLabel grainsImage = new JLabel("");
		grainsImage.setIcon(new ImageIcon(MarketSupplies.class.getResource("/Images/SupliesImages/grains.png")));
		grainsImage.setBounds(25, 196, 66, 55);
		marketSuppliesWindow.getContentPane().add(grainsImage);
		
		JLabel hayBorder = new JLabel("");
		hayBorder.setFont(new Font("Tahoma", Font.BOLD, 13));
		hayBorder.setBounds(327, 182, 278, 145);
		hayBorder.setBorder(border);
		marketSuppliesWindow.getContentPane().add(hayBorder);
		
		JLabel fertBorder = new JLabel();
		fertBorder.setBounds(10, 338, 291, 145);
		fertBorder.setBorder(border);
		marketSuppliesWindow.getContentPane().add(fertBorder);
		
		JLabel hayImage = new JLabel();
		hayImage.setIcon(new ImageIcon(MarketSupplies.class.getResource("/Images/SupliesImages/Hay.png")));
		hayImage.setBounds(339, 196, 66, 55);
		marketSuppliesWindow.getContentPane().add(hayImage);
		
		JLabel vitaminsBorder = new JLabel("");
		vitaminsBorder.setBounds(617, 182, 272, 145);
		vitaminsBorder.setBorder(border);
		marketSuppliesWindow.getContentPane().add(vitaminsBorder);
		
		JLabel horseDungBorder = new JLabel("");
		horseDungBorder.setBounds(323, 338, 278, 145);
		horseDungBorder.setBorder(border);
		marketSuppliesWindow.getContentPane().add(horseDungBorder);
		
		JLabel rootBoostBorder = new JLabel("");
		rootBoostBorder.setBounds(617, 338, 272, 145);
		rootBoostBorder.setBorder(border);
		marketSuppliesWindow.getContentPane().add(rootBoostBorder);
		
		
		JLabel vitamins = new JLabel();
		vitamins.setIcon(new ImageIcon(MarketSupplies.class.getResource("/Images/SupliesImages/vitamins.png")));
		vitamins.setBounds(623, 196, 66, 55);
		marketSuppliesWindow.getContentPane().add(vitamins);
		
		JLabel rootBoostImage = new JLabel();
		rootBoostImage.setIcon(new ImageIcon(MarketSupplies.class.getResource("/Images/SupliesImages/rootBoost.png")));
		rootBoostImage.setBounds(623, 351, 66, 55);
		marketSuppliesWindow.getContentPane().add(rootBoostImage);
		
		
		JLabel horseDungImage = new JLabel();
		horseDungImage.setIcon(new ImageIcon(MarketSupplies.class.getResource("/Images/SupliesImages/horseDung.png")));
		horseDungImage.setBounds(339, 351, 66, 44);
		marketSuppliesWindow.getContentPane().add(horseDungImage);
		
		JLabel fertImage = new JLabel();
		fertImage.setIcon(new ImageIcon(MarketSupplies.class.getResource("/Images/SupliesImages/fertiliser.png")));
		fertImage.setBounds(18, 351, 66, 55);
		marketSuppliesWindow.getContentPane().add(fertImage);
		
		JLabel grainsStat = new JLabel("<html>Cost: $" + manager.grain.getPrice() 
		+ "<br>Attribute: " + manager.grain.getBonus() + "</html>");
		grainsStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		grainsStat.setBounds(106, 196, 182, 82);
		marketSuppliesWindow.getContentPane().add(grainsStat);
		
		JLabel hayStat = new JLabel("<html>Cost: $" + manager.hay.getPrice() 
		+ "<br>Attribute: " + manager.hay.getBonus() + "</html>");
		hayStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		hayStat.setBounds(419, 196, 182, 82);
		marketSuppliesWindow.getContentPane().add(hayStat);
		
		JLabel vitaminStat = new JLabel("<html>Cost: $" + manager.vitamin.getPrice() 
		+ "<br>Attribute: " + manager.vitamin.getBonus() + "</html>");
		vitaminStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		vitaminStat.setBounds(699, 196, 175, 82);
		marketSuppliesWindow.getContentPane().add(vitaminStat);
		
		JLabel fertStat = new JLabel("<html>Cost: $" + manager.fertiliser.getPrice() 
		+ "<br>Attribute: " + manager.fertiliser.getBonus() + "</html>");
		fertStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		fertStat.setBounds(91, 351, 197, 82);
		marketSuppliesWindow.getContentPane().add(fertStat);
		
		JLabel horsedungStat = new JLabel("<html>Cost: $" + manager.horseDung.getPrice() 
		+ "<br>Attribute: " + manager.horseDung.getBonus() + "</html>");
		horsedungStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		horsedungStat.setBounds(421, 351, 167, 82);
		marketSuppliesWindow.getContentPane().add(horsedungStat);
		
		JLabel rootBoostStats = new JLabel("<html>Cost: $" + manager.rootBoost.getPrice() 
		+ "<br>Attribute: " + manager.rootBoost.getBonus() + "</html>");
		rootBoostStats.setFont(new Font("Tahoma", Font.BOLD, 13));
		rootBoostStats.setBounds(717, 351, 156, 82);
		marketSuppliesWindow.getContentPane().add(rootBoostStats);
		

	}

}
