
package GUIPackage;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;
import javax.swing.JButton;
import MainClassesPackage.*;
import baseutility.Setup1;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseFarmType {

	private JFrame chooseFarmType;
	private static PaddockParadiseManager manager;
	private static Setup1 setup;
	private Farm farm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseFarmType window = new ChooseFarmType(setup);
					window.chooseFarmType.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseFarmType(Setup1 newSetup) {
		setup = newSetup;
		manager = setup.getManager();
		farm = manager.getFarm();
		initialize();
		chooseFarmType.setVisible(true);
	}
	
	private void setFarmType(String newType) {
		farm.setType(newType);
		
	}
	
	private void setFarmTypeImage(String newImageType) {
		farm.setImageType(newImageType);
	}
	

	
	public void farmTypeConfirm(String type) {
		int choice = JOptionPane.showConfirmDialog(chooseFarmType, "Are you sure you want  " + type + " Farm?", "Choose Yes or No", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			finishedWindow();
		} else if (choice == JOptionPane.NO_OPTION) {                                                                    // Deleting Object created
			JOptionPane.showMessageDialog(chooseFarmType, "Please re-choose Farm Type");        // Re-choosing Farmer
			
		} else {
		JOptionPane.showMessageDialog(chooseFarmType, "You need to select yes or no!", "Oops!", JOptionPane.ERROR_MESSAGE);
		farmTypeConfirm(type);
		}
	}
	
	public void closeWindow() {
		chooseFarmType.dispose();
	}
	
	private void finishedWindow() {
		setup.closeChooseFarmType(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chooseFarmType = new JFrame();
		chooseFarmType.setTitle("Choose Farm Type");
		chooseFarmType.setBounds(100, 100, 770, 525);
		chooseFarmType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chooseFarmType.getContentPane().setLayout(null);
		
		JLabel speedCropLabel = new JLabel("");
		speedCropLabel.setIcon(new ImageIcon(ChooseFarmType.class.getResource("/Images/FarmTypeImages/SpeedCropImage.jpg")));
		speedCropLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		speedCropLabel.setBounds(20, 70, 170, 129);
		chooseFarmType.getContentPane().add(speedCropLabel);
		
		JLabel happyAnimalLabel = new JLabel("");
		happyAnimalLabel.setIcon(new ImageIcon(ChooseFarmType.class.getResource("/Images/FarmTypeImages/HappyAnimalImage.png")));
		happyAnimalLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		happyAnimalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		happyAnimalLabel.setBounds(393, 70, 170, 129);
		chooseFarmType.getContentPane().add(happyAnimalLabel);
		
		JLabel moneyTreeLabel = new JLabel("");
		moneyTreeLabel.setIcon(new ImageIcon(ChooseFarmType.class.getResource("/Images/FarmTypeImages/MoneyTree.jpg")));
		moneyTreeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		moneyTreeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyTreeLabel.setBounds(20, 286, 170, 145);
		chooseFarmType.getContentPane().add(moneyTreeLabel);
		
		JLabel discountFarmLabel = new JLabel("");
		discountFarmLabel.setIcon(new ImageIcon(ChooseFarmType.class.getResource("/Images/FarmTypeImages/DiscountFarmImage.jpg")));
		discountFarmLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		discountFarmLabel.setHorizontalAlignment(SwingConstants.CENTER);
		discountFarmLabel.setBounds(393, 282, 170, 145);
		chooseFarmType.getContentPane().add(discountFarmLabel);
		
		JLabel chooseFarmTypeLabel = new JLabel("Please choose farm type:");
		chooseFarmTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		chooseFarmTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseFarmTypeLabel.setBounds(129, 11, 424, 43);
		chooseFarmType.getContentPane().add(chooseFarmTypeLabel);
		
		JButton speedCropButton = new JButton("Faster Crop Growth");
		speedCropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFarmType("Faster Crop Growth");
				setFarmTypeImage("/Images/FarmTypeImages/SpeedCropImage.jpg");
				farmTypeConfirm("Faster Crop growth");
			}
		});
		speedCropButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		speedCropButton.setBorder(BorderFactory.createRaisedBevelBorder());
		speedCropButton.setBounds(20, 210, 170, 33);
		chooseFarmType.getContentPane().add(speedCropButton);
		
		JLabel speedCropStatsLabel = new JLabel("");
		speedCropStatsLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		speedCropStatsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		speedCropStatsLabel.setBorder(border);
		speedCropStatsLabel.setBounds(10, 63, 337, 197);
		chooseFarmType.getContentPane().add(speedCropStatsLabel);
		
		JButton happyAnimalBtn = new JButton("Happy Animal");
		happyAnimalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFarmType("Happy Animal");
				setFarmTypeImage("/Images/FarmTypeImages/HappyAnimalImage.png");
				farmTypeConfirm("Happy Animal");
			}
		});
		happyAnimalBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		happyAnimalBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		happyAnimalBtn.setBounds(393, 210, 170, 33);
		chooseFarmType.getContentPane().add(happyAnimalBtn);
		
		JLabel happyAnimalStatsLabel = new JLabel("\r\n");
		happyAnimalStatsLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		happyAnimalStatsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		happyAnimalStatsLabel.setBorder(border);
		happyAnimalStatsLabel.setBounds(377, 63, 354, 197);
		chooseFarmType.getContentPane().add(happyAnimalStatsLabel);
		
		JButton moneyTreeBtn = new JButton("Money Tree");
		moneyTreeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFarmType("MoneyTree");
				setFarmTypeImage("/Images/FarmTypeImages/MoneyTree.jpg");
				farmTypeConfirm("Money Tree");
			}
		});
		moneyTreeBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		moneyTreeBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		moneyTreeBtn.setBounds(20, 426, 170, 33);
		chooseFarmType.getContentPane().add(moneyTreeBtn);
		
		JLabel moneyTreeStatsLbl = new JLabel("");
		moneyTreeStatsLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		moneyTreeStatsLbl.setHorizontalAlignment(SwingConstants.TRAILING);
		moneyTreeStatsLbl.setBorder(border);
		moneyTreeStatsLbl.setBounds(10, 271, 337, 204);
		moneyTreeStatsLbl.setBorder(border);
		chooseFarmType.getContentPane().add(moneyTreeStatsLbl);
		
		JButton discountStoreBtn = new JButton("Discount Store");
		discountStoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFarmType("Discount Store");
				setFarmTypeImage("/Images/FarmTypeImages/DiscountFarmImage.jpg");
				farmTypeConfirm("Discount Store");
			}
		});
		discountStoreBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		discountStoreBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		discountStoreBtn.setBounds(393, 424, 170, 37);
		chooseFarmType.getContentPane().add(discountStoreBtn);
		
		JLabel discountStoreStatsLbl = new JLabel("");
		discountStoreStatsLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		discountStoreStatsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		discountStoreStatsLbl.setBorder(border);
		discountStoreStatsLbl.setBounds(377, 271, 354, 204);
		chooseFarmType.getContentPane().add(discountStoreStatsLbl);
		
		JLabel bonusLbl1 = new JLabel("Bonus:");
		bonusLbl1.setFont(new Font("Tahoma", Font.BOLD, 13));
		bonusLbl1.setHorizontalAlignment(SwingConstants.CENTER);
		bonusLbl1.setBounds(213, 329, 92, 33);
		chooseFarmType.getContentPane().add(bonusLbl1);
		
		JLabel speedCropBordLbl = new JLabel("");
		speedCropBordLbl.setBounds(200, 70, 134, 173);
		Border lblBorder = BorderFactory.createLineBorder(Color.blue);
		speedCropBordLbl.setBorder(lblBorder);
		chooseFarmType.getContentPane().add(speedCropBordLbl);
		
		JLabel moneyTreeBonus = new JLabel("<html>Recieve 20% of the Farms worth everyday</html>");
		moneyTreeBonus.setFont(new Font("Tahoma", Font.BOLD, 13));
		moneyTreeBonus.setBounds(210, 355, 124, 67);
		chooseFarmType.getContentPane().add(moneyTreeBonus);
		
		JLabel moneyTreeBordLbl = new JLabel("\r\n");
		moneyTreeBordLbl.setBounds(200, 286, 134, 173);
		moneyTreeBordLbl.setBorder(lblBorder);
		chooseFarmType.getContentPane().add(moneyTreeBordLbl);
		
		JLabel lblNewLabel = new JLabel("Bonus:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(226, 111, 68, 26);
		chooseFarmType.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Decrease the days to harvest by 1 day</html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(213, 138, 108, 77);
		chooseFarmType.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\r\n");
		lblNewLabel_2.setBounds(581, 70, 134, 173);
		lblNewLabel_2.setBorder(lblBorder);
		chooseFarmType.getContentPane().add(lblNewLabel_2);
		
		JLabel bonusLbl3 = new JLabel("Bonus:");
		bonusLbl3.setFont(new Font("Tahoma", Font.BOLD, 13));
		bonusLbl3.setHorizontalAlignment(SwingConstants.CENTER);
		bonusLbl3.setBounds(614, 111, 57, 26);
		chooseFarmType.getContentPane().add(bonusLbl3);
		
		JLabel anmalBonDescrip = new JLabel("<html>Animals are happier for 2 extra days when purchased</html>");
		anmalBonDescrip.setFont(new Font("Tahoma", Font.BOLD, 12));
		anmalBonDescrip.setBounds(592, 138, 108, 92);
		chooseFarmType.getContentPane().add(anmalBonDescrip);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(581, 286, 134, 173);
		lblNewLabel_5.setBorder(lblBorder);
		chooseFarmType.getContentPane().add(lblNewLabel_5);
		
		JLabel bonusLbl2 = new JLabel("Bonus:");
		bonusLbl2.setFont(new Font("Tahoma", Font.BOLD, 13));
		bonusLbl2.setBounds(614, 329, 50, 26);
		chooseFarmType.getContentPane().add(bonusLbl2);
		
		JLabel discountDescrip = new JLabel("<html>40% Discount added to cart on checkout from Market!</html>");
		discountDescrip.setFont(new Font("Tahoma", Font.BOLD, 12));
		discountDescrip.setBounds(592, 354, 112, 77);
		chooseFarmType.getContentPane().add(discountDescrip);
	}
}