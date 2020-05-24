package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import MainClassesPackage.Market;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarketCrops {

	private JFrame marketCropsWindow;
	private static Market manager;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketCrops window = new MarketCrops(manager);
					window.marketCropsWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarketCrops(Market newManager) {
		manager = newManager;
		initialize();
		marketCropsWindow.setVisible(true);
	}
	
	public void closeWindow() {
		marketCropsWindow.dispose();
	}
	
	private void finishedWindow() {
		manager.closeMarketCrops(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		marketCropsWindow = new JFrame();
		marketCropsWindow.setTitle("Market Crops");
		marketCropsWindow.setBounds(100, 100, 919, 658);
		marketCropsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marketCropsWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		Border raiseBorder = BorderFactory.createRaisedBevelBorder();
		
		JLabel cartCost = new JLabel("Current Cart Total: $" + manager.getCartCost());
		cartCost.setFont(new Font("Tahoma", Font.BOLD, 18));
		cartCost.setBounds(504, 53, 331, 55);
		marketCropsWindow.getContentPane().add(cartCost);
		
		
		JLabel marketTitle = new JLabel("<html>Crops!</html>");
		marketTitle.setFont(new Font("Tahoma", Font.BOLD, 27));
		marketTitle.setHorizontalAlignment(SwingConstants.CENTER);
		marketTitle.setBounds(243, 11, 407, 31);
		marketCropsWindow.getContentPane().add(marketTitle);
		
		JLabel border1 = new JLabel("");
		border1.setFont(new Font("Tahoma", Font.BOLD, 13));
		border1.setBounds(10, 46, 401, 125);
		border1.setBorder(border);
		marketCropsWindow.getContentPane().add(border1);
		
		JLabel andyDialog = new JLabel("<html>What would you like to add to your cart?</html>");
		andyDialog.setHorizontalAlignment(SwingConstants.CENTER);
		andyDialog.setFont(new Font("Tahoma", Font.BOLD, 18));
		andyDialog.setBounds(161, 60, 240, 102);
		marketCropsWindow.getContentPane().add(andyDialog);
		
		JLabel andyImg = new JLabel("");
		andyImg.setIcon(new ImageIcon(OpenMarket.class.getResource("/Images/shopKeeper.png")));
		andyImg.setBounds(21, 60, 130, 102);
		marketCropsWindow.getContentPane().add(andyImg);
		
		JLabel displayLbl = new JLabel("");
		displayLbl.setHorizontalAlignment(SwingConstants.CENTER);
		displayLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		displayLbl.setBounds(10, 494, 879, 65);
		displayLbl.setBorder(border);
		displayLbl.setForeground(Color.green);
		marketCropsWindow.getContentPane().add(displayLbl);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				
			}
		});
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		closeBtn.setBounds(707, 570, 182, 38);
		closeBtn.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(closeBtn);
		
		JButton addCarrot = new JButton("Add Carrots");
		addCarrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addCarrots();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Carrots has been added to cart!");
			}
		});
		addCarrot.setBounds(18, 289, 120, 23);
		addCarrot.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(addCarrot);
		
		JButton btnAddBroccoli = new JButton("Add Broccoli");
		btnAddBroccoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addBroccoli();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Broccoli has been added to cart!");
			}
		});
		btnAddBroccoli.setBounds(339, 289, 120, 23);
		btnAddBroccoli.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnAddBroccoli);
		
		JButton btnRemoveCarrots = new JButton("Remove Carrots");
		btnRemoveCarrots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeCrop("Carrot");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemoveCarrots.setBounds(158, 289, 120, 23);
		btnRemoveCarrots.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnRemoveCarrots);
		
		JButton btnRemoveBroccoli = new JButton("Remove Broccoli");
		btnRemoveBroccoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeCrop("Broccoli");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
			}
		});
		btnRemoveBroccoli.setBounds(468, 289, 120, 23);
		btnRemoveBroccoli.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnRemoveBroccoli);
		
		JButton btnAddCauliflower = new JButton("Add Cauliflower");
		btnAddCauliflower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addCauliflower();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Cauliflower has been added to cart!");
			}
		});
		btnAddCauliflower.setBounds(21, 444, 127, 23);
		btnAddCauliflower.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnAddCauliflower);
		
		JButton btnRemoveCauliflower = new JButton("Remove Cauliflower");
		btnRemoveCauliflower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeCrop("Cauliflower");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemoveCauliflower.setBounds(158, 444, 130, 23);
		btnRemoveCauliflower.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnRemoveCauliflower);
		
		JButton btnAddCapsicum = new JButton("Add Capsicum");
		btnAddCapsicum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addCapsicum();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Capsicum has been added to cart!");
			}
		});
		btnAddCapsicum.setBounds(339, 444, 120, 23);
		btnAddCapsicum.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnAddCapsicum);
		
		JButton btnRemoveCapsicum = new JButton("Remove Capsicum");
		btnRemoveCapsicum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeCrop("Capsicum");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemoveCapsicum.setBounds(468, 444, 120, 23);
		btnRemoveCapsicum.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnRemoveCapsicum);
		
		JButton btnAddAvocado = new JButton("Add Avocado");
		btnAddAvocado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addAvocado();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Avocado has been added to cart!");
			}
		});
		btnAddAvocado.setBounds(623, 444, 120, 23);
		btnAddAvocado.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnAddAvocado);
		
		JButton btnRemoveAvocado = new JButton("Remove Avocado");
		btnRemoveAvocado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeCrop("Avocado");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemoveAvocado.setBounds(753, 444, 120, 23);
		btnRemoveAvocado.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnRemoveAvocado);
		
		JButton btnAddPotatoes = new JButton("Add Potatoes");
		btnAddPotatoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addPotato();
				displayLbl.setForeground(Color.green);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText("Potato has been added to cart!");
				
			}
		});
		btnAddPotatoes.setBounds(623, 289, 120, 23);
		btnAddPotatoes.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnAddPotatoes);
		
		JButton btnRemovePotatoes = new JButton("Remove Potatoes");
		btnRemovePotatoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = manager.removeCrop("Potato");
				displayLbl.setForeground(Color.red);
				cartCost.setText("Current Cart Total: $" + manager.getCartCost());
				displayLbl.setText(message);
				
			}
		});
		btnRemovePotatoes.setBounds(753, 289, 120, 23);
		btnRemovePotatoes.setBorder(raiseBorder);
		marketCropsWindow.getContentPane().add(btnRemovePotatoes);
		
		JLabel carrotBorder = new JLabel("");
		carrotBorder.setBounds(10, 182, 291, 145);
		carrotBorder.setBorder(border);
		marketCropsWindow.getContentPane().add(carrotBorder);
		
		JLabel carrotImage = new JLabel("");
		carrotImage.setIcon(new ImageIcon(MarketCrops.class.getResource("/Images/cropImages/carrot.png")));
		carrotImage.setBounds(25, 196, 55, 44);
		marketCropsWindow.getContentPane().add(carrotImage);
		
		JLabel brocBorder = new JLabel("");
		brocBorder.setFont(new Font("Tahoma", Font.BOLD, 13));
		brocBorder.setBounds(327, 182, 278, 145);
		brocBorder.setBorder(border);
		marketCropsWindow.getContentPane().add(brocBorder);
		
		JLabel cauliBorder = new JLabel();
		cauliBorder.setBounds(10, 338, 291, 145);
		cauliBorder.setBorder(border);
		marketCropsWindow.getContentPane().add(cauliBorder);
		
		JLabel broccoliImage = new JLabel();
		broccoliImage.setIcon(new ImageIcon(MarketCrops.class.getResource("/Images/cropImages/broccoli.png")));
		broccoliImage.setBounds(339, 196, 55, 44);
		marketCropsWindow.getContentPane().add(broccoliImage);
		
		JLabel potatoBorder = new JLabel("");
		potatoBorder.setBounds(617, 182, 272, 145);
		potatoBorder.setBorder(border);
		marketCropsWindow.getContentPane().add(potatoBorder);
		
		JLabel capsBorder = new JLabel("");
		capsBorder.setBounds(323, 338, 278, 145);
		capsBorder.setBorder(border);
		marketCropsWindow.getContentPane().add(capsBorder);
		
		JLabel avoBorder = new JLabel("");
		avoBorder.setBounds(617, 338, 272, 145);
		avoBorder.setBorder(border);
		marketCropsWindow.getContentPane().add(avoBorder);
		
		JLabel potato = new JLabel();
		potato.setIcon(new ImageIcon(MarketCrops.class.getResource("/Images/cropImages/potato.png")));
		potato.setBounds(623, 196, 55, 44);
		marketCropsWindow.getContentPane().add(potato);
		
		JLabel avocadoImage = new JLabel();
		avocadoImage.setIcon(new ImageIcon(MarketCrops.class.getResource("/Images/cropImages/avocado.png")));
		avocadoImage.setBounds(623, 351, 55, 44);
		marketCropsWindow.getContentPane().add(avocadoImage);
		
		JLabel capsicumImage = new JLabel();
		capsicumImage.setIcon(new ImageIcon(MarketCrops.class.getResource("/Images/cropImages/capsicum.jpg")));
		capsicumImage.setBounds(339, 351, 55, 44);
		marketCropsWindow.getContentPane().add(capsicumImage);
		
		JLabel cauliImage = new JLabel();
		cauliImage.setIcon(new ImageIcon(MarketCrops.class.getResource("/Images/cropImages/Cauliflower.png")));
		cauliImage.setBounds(18, 351, 55, 44);
		marketCropsWindow.getContentPane().add(cauliImage);
		
		JLabel carrotStat = new JLabel("<html>Cost: $" + manager.carrot.getPrice() 
		+ "<br>State: " + manager.carrot.getState() 
		+ "<br>Sell Price: $" + manager.carrot.getSellPrice() 
		+ "<br>Days To Harvest: " + manager.carrot.getDaysToHarvest() + "</html>");
		carrotStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		carrotStat.setBounds(106, 196, 182, 72);
		marketCropsWindow.getContentPane().add(carrotStat);
		
		JLabel brocStat = new JLabel("<html>Cost: $" + manager.broccoli.getPrice() 
		+ "<br>State: " + manager.broccoli.getState() 
		+ "<br>Sell Price: $" + manager.broccoli.getSellPrice() 
		+ "<br>Days To Harvest: " + manager.broccoli.getDaysToHarvest() + "</html>");
		brocStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		brocStat.setBounds(404, 196, 197, 72);
		marketCropsWindow.getContentPane().add(brocStat);
		
		JLabel lblPostat = new JLabel("<html>Cost: $" + manager.potato.getPrice() 
		+ "<br>State: " + manager.potato.getState() 
		+ "<br>Sell Price: $" + manager.potato.getSellPrice() 
		+ "<br>Days To Harvest: " + manager.potato.getDaysToHarvest() + "</html>");
		lblPostat.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPostat.setBounds(685, 196, 189, 82);
		marketCropsWindow.getContentPane().add(lblPostat);
		
		JLabel lblCaulistat = new JLabel("<html>Cost: $" + manager.cauliflower.getPrice() 
		+ "<br>State: " + manager.cauliflower.getState() 
		+ "<br>Sell Price: $" + manager.cauliflower.getSellPrice() 
		+ "<br>Days To Harvest: " + manager.cauliflower.getDaysToHarvest() + "</html>");
		lblCaulistat.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCaulistat.setBounds(91, 351, 197, 82);
		marketCropsWindow.getContentPane().add(lblCaulistat);
		
		JLabel lblCapsstat = new JLabel("<html>Cost: $" + manager.capsicum.getPrice() 
		+ "<br>State: " + manager.capsicum.getState() 
		+ "<br>Sell Price: $" + manager.capsicum.getSellPrice() 
		+ "<br>Days To Harvest: " + manager.capsicum.getDaysToHarvest() + "</html>");
		lblCapsstat.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapsstat.setBounds(400, 351, 189, 82);
		marketCropsWindow.getContentPane().add(lblCapsstat);
		
		JLabel avocadoStats = new JLabel("<html>Cost: $" + manager.avocado.getPrice() 
		+ "<br>State: " + manager.avocado.getState() 
		+ "<br>Sell Price: $" + manager.avocado.getSellPrice() 
		+ "<br>Days To Harvest: " + manager.avocado.getDaysToHarvest() + "</html>");
		avocadoStats.setFont(new Font("Tahoma", Font.BOLD, 13));
		avocadoStats.setBounds(688, 351, 197, 82);
		marketCropsWindow.getContentPane().add(avocadoStats);
		
	
	
	
	
	
	}

}
