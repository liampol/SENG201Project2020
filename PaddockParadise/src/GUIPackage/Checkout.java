package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import MainClassesPackage.Farm;
import MainClassesPackage.Farmer;
import MainClassesPackage.Market;
import MainClassesPackage.PaddockParadiseManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Checkout {

	private JFrame checkoutWindow;
	private static Market manager;
	private static PaddockParadiseManager ppmManager;
	private static Farm farm;
	private static Farmer farmer;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkout window = new Checkout(manager);
					window.checkoutWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Checkout(Market newManager) {
		manager = newManager;
		ppmManager = manager.getManager();
		farm = ppmManager.getFarm();
		farmer = ppmManager.getFarmer();
		initialize();
		checkoutWindow.setVisible(true);
	}
	
	private void applyBonus(String bonus) {
		
	}
	
	
	public void finishedWindow() {
		manager.closeCheckoutWindow(this);
	}
	
	
	/**
	 * This method is called from the Market class to close this frame
	 */
	public void closeWindow() {
		checkoutWindow.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		checkoutWindow = new JFrame();
		checkoutWindow.setTitle("Checkout");
		checkoutWindow.setBounds(100, 100, 516, 365);
		checkoutWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkoutWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		Border raisedBorder = BorderFactory.createRaisedBevelBorder();
		
		JLabel image = new JLabel("");
		image.setBounds(24, 63, 158, 123);
		image.setIcon(new ImageIcon(Checkout.class.getResource("/Images/checkout.jpg")));
		checkoutWindow.getContentPane().add(image);
		
		JLabel title = new JLabel("Checkout");
		title.setBounds(192, 11, 142, 38);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 26));
		checkoutWindow.getContentPane().add(title);
		
		JLabel cartCost = new JLabel("Cart Cost: $");
		cartCost.setBounds(192, 63, 288, 30);
		cartCost.setFont(new Font("Tahoma", Font.BOLD, 16));
		checkoutWindow.getContentPane().add(cartCost);
		
		JButton payBtn = new JButton("Pay for Cart");
		payBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.completeCheckout();
				finishedWindow();
			}
		});
		payBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		payBtn.setBounds(306, 277, 184, 38);
		payBtn.setBorder(raisedBorder);
		checkoutWindow.getContentPane().add(payBtn);
		
		JButton returnBtn = new JButton("Return To Market");
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		returnBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		returnBtn.setBounds(10, 277, 184, 38);
		returnBtn.setBorder(raisedBorder);
		checkoutWindow.getContentPane().add(returnBtn);
		
		JLabel dialog = new JLabel("");
		dialog.setFont(new Font("Tahoma", Font.BOLD, 22));
		dialog.setHorizontalAlignment(SwingConstants.CENTER);
		dialog.setBounds(10, 197, 480, 69);
		checkoutWindow.getContentPane().add(dialog);
		
		JLabel farmBonus = new JLabel("");
		farmBonus.setFont(new Font("Tahoma", Font.BOLD, 15));
		farmBonus.setBounds(192, 143, 305, 43);
		String bonus = "";
		if (farm.getType() == "Discount Store") {
			 bonus = "Discount Store";
			 farmBonus.setText("Farm Bonus :" + bonus);
			 applyBonus(bonus);
			 dialog.setForeground(Color.green);
			 dialog.setText("Discount has been Applied!");
			 
		}else if (farm.getType() == "Faster Crop Growth") {
			bonus = "Faster Crop Growth";
			farmBonus.setText("Farm Bonus :" + bonus);
		}else if (farm.getType() == "Happy Animal") {
			bonus = "Happy Animal";
			farmBonus.setText("Farm Bonus :" + bonus);
			
		}
		
		checkoutWindow.getContentPane().add(farmBonus);
		

		

	}
}
