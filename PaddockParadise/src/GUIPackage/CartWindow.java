package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import MainClassesPackage.Market;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CartWindow {

	private JFrame cartWindow;
	private static Market manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartWindow window = new CartWindow(manager);
					window.cartWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CartWindow(Market newManager) {
		manager = newManager;
		initialize();
		cartWindow.setVisible(true);
	}
	
	public void finishedWindow() {
		manager.closeCartWindow(this);
	}
	
	
	/**
	 * This method is called from the PaddockPAradiseManager class to close this frame
	 */
	public void closeWindow() {
		cartWindow.dispose();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cartWindow = new JFrame();
		cartWindow.setTitle("Cart");
		cartWindow.setBounds(100, 100, 747, 611);
		cartWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cartWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		Border raisedBorder = BorderFactory.createRaisedBevelBorder();
		
		JLabel cartImage = new JLabel("");
		cartImage.setIcon(new ImageIcon(CartWindow.class.getResource("/Images/cartImage.jpg")));
		cartImage.setBounds(31, 57, 158, 130);
		cartWindow.getContentPane().add(cartImage);
		
		JLabel cartCost = new JLabel("Current Cart Cost: $" + manager.getCartCost());
		cartCost.setFont(new Font("Tahoma", Font.BOLD, 20));
		cartCost.setBounds(401, 57, 320, 35);
		cartWindow.getContentPane().add(cartCost);
		
		JLabel cropBorder = new JLabel();
		cropBorder.setBounds(20, 208, 215, 312);
		cropBorder.setBorder(border);
		cartWindow.getContentPane().add(cropBorder);
		
		JLabel animalBorder = new JLabel("");
		animalBorder.setBounds(261, 208, 215, 312);
		animalBorder.setBorder(border);
		cartWindow.getContentPane().add(animalBorder);
		
		JLabel cropsTitle = new JLabel("Current Crops");
		cropsTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		cropsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		cropsTitle.setBounds(66, 219, 117, 22);
		cartWindow.getContentPane().add(cropsTitle);
		
		JLabel animalTitle = new JLabel("Current Animals");
		animalTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		animalTitle.setHorizontalAlignment(SwingConstants.CENTER);
		animalTitle.setBounds(308, 216, 112, 29);
		cartWindow.getContentPane().add(animalTitle);
		
		JLabel suppliesBorder = new JLabel("");
		suppliesBorder.setBounds(498, 208, 215, 312);
		suppliesBorder.setBorder(border);
		cartWindow.getContentPane().add(suppliesBorder);
		
		JLabel suppliesTitle = new JLabel("Current Supplies");
		suppliesTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		suppliesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		suppliesTitle.setBounds(537, 220, 117, 21);
		cartWindow.getContentPane().add(suppliesTitle);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClose.setBounds(598, 531, 112, 35);
		btnClose.setBorder(raisedBorder);
		cartWindow.getContentPane().add(btnClose);
		
		JLabel cartTitle = new JLabel("Cart");
		cartTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		cartTitle.setBounds(308, 11, 112, 35);
		cartWindow.getContentPane().add(cartTitle);
		
		JLabel cartBorder = new JLabel("");
		cartBorder.setBounds(20, 49, 693, 148);
		cartBorder.setBorder(border);
		cartWindow.getContentPane().add(cartBorder);
		
		JLabel lblNewLabel = new JLabel("<html>Carrot: " + manager.getItemCount("Carrots") 
		+ "<br>Capsicum: " + manager.getItemCount("Capsicum") 
		+ "<br>Cauliflower: " + manager.getItemCount("Cauliflower") 
		+ "<br>Broccoli: " + manager.getItemCount("Broccoli") 
		+ "<br>Potatoes: " + manager.getItemCount("Potato") 
		+ "<br>Avocado: " + manager.getItemCount("Avocado") + "</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(31, 366, 183, 140);
		cartWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblAnimallst = new JLabel("<html>Pig: " + manager.getItemCount("Pig") 
		+ "<br>Cow: " + manager.getItemCount("Cow") 
		+ "<br>Sheep: " + manager.getItemCount("Sheep") + "</html>");
		lblAnimallst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnimallst.setBounds(278, 376, 183, 130);
		cartWindow.getContentPane().add(lblAnimallst);
		
		JLabel lblSupplieslist = new JLabel("<html>Hay: " + manager.getItemCount("Hay") 
		+ "<br>Grains: " + manager.getItemCount("Grains") 
		+ "<br>Vitamins: " + manager.getItemCount("Vitamins") 
		+ "<br>Horse-Dung: " + manager.getItemCount("Horse Dung") 
		+ "<br>Fertiliser: " + manager.getItemCount("Fertiliser") 
		+ "<br>Root-Boost: " + manager.getItemCount("Root Boost") + "</html>");
		lblSupplieslist.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSupplieslist.setBounds(514, 366, 183, 140);
		cartWindow.getContentPane().add(lblSupplieslist);
		
		JLabel lblNewLabel_1 = new JLabel("CropImage");
		lblNewLabel_1.setIcon(new ImageIcon(CartWindow.class.getResource("/Images/cropsImage.jpg")));
		lblNewLabel_1.setBounds(63, 252, 126, 103);
		cartWindow.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("CropImage");
		label.setIcon(new ImageIcon(CartWindow.class.getResource("/Images/animalImage.jpg")));
		label.setBounds(290, 256, 158, 118);
		cartWindow.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("CropImage");
		label_1.setIcon(new ImageIcon(CartWindow.class.getResource("/Images/suppliesImage.jpg")));
		label_1.setBounds(526, 252, 158, 118);
		cartWindow.getContentPane().add(label_1);
	}

}
