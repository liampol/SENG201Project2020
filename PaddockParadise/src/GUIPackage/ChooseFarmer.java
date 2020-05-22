package GUIPackage;

import animalExtend.*;
import cropExtend.*;
import MainClassesPackage.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseFarmer {

	private JFrame chooseFarmerWindow;
	private static PaddockParadiseManager manager;
	public Farmer newFarmer;

	/**
	 * "ChooseFarmer" window is open which allows the player to choose one avatar to play as through the game,
	 *      The player can choose from being a "FemaleFarmer", "MaleFarmer", or an "AlienFarmer".
	 *      NOTE: Avatars do not have special abilities or bonuses associated, they also do not change gameplay
	 *       
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseFarmer window = new ChooseFarmer(manager);
					window.chooseFarmerWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseFarmer(PaddockParadiseManager incomingManager) {
		manager = incomingManager;
		initialize();
		chooseFarmerWindow.setVisible(true);
	}
	
	
	/*
	 * Confirms the choice of avatar from user and if the user does not want the chosen avatar, they are then prompted to re-choose
	 */
	public void farmerTypeConfirm() {
		int choice = JOptionPane.showConfirmDialog(chooseFarmerWindow, "Are you sure you want to be " + newFarmer.getType() + " ?", "Choose Yes or No", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			finishedWindow();
		} else if (choice == JOptionPane.NO_OPTION) {
			newFarmer = null;                                                                    // Deleting Object created
			JOptionPane.showMessageDialog(chooseFarmerWindow, "Please re-choose Farmer");        // Re-choosing Farmer
			
		} else {
		JOptionPane.showMessageDialog(chooseFarmerWindow, "You need to select yes or no!", "Oops!", JOptionPane.ERROR_MESSAGE);
		farmerTypeConfirm();
		}
	}
	
	public void closeWindow() {
		chooseFarmerWindow.dispose();
	}
	
	public void finishedWindow() {
		manager.closeChooseFarmerScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chooseFarmerWindow = new JFrame();
		chooseFarmerWindow.setTitle("Choose Farmer");
		chooseFarmerWindow.setBounds(100, 100, 784, 482);
		chooseFarmerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chooseFarmerWindow.getContentPane().setLayout(null);
		
		JLabel femaleAvatar = new JLabel("");
		femaleAvatar.setIcon(new ImageIcon(ChooseFarmer.class.getResource("/Images/FemaleFarmerHeadResized.jpg")));
		femaleAvatar.setBounds(93, 137, 200, 164);
		chooseFarmerWindow.getContentPane().add(femaleAvatar);
		
		JLabel maleAvatar = new JLabel("");
		maleAvatar.setIcon(new ImageIcon(ChooseFarmer.class.getResource("/Images/MaleHead.jpg")));
		maleAvatar.setBounds(303, 126, 193, 175);
		chooseFarmerWindow.getContentPane().add(maleAvatar);
		
		JLabel alienAvatar = new JLabel("");
		alienAvatar.setIcon(new ImageIcon(ChooseFarmer.class.getResource("/Images/AlienResized.jpg")));
		alienAvatar.setBounds(506, 126, 193, 175);
		chooseFarmerWindow.getContentPane().add(alienAvatar);
		
		/**
		 * 
		 * Sets the farmerType to the chosen avatar of class Farmer to "Female Farmer"
		 *     which is then used to associate the avatar image to the farmer
		 */
		JButton femaleAvatarBtn = new JButton("Female Farmer");
		femaleAvatarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String farmerType = "Female Farmer";
				newFarmer.setType("Female Farmer");
				farmerTypeConfirm();
			}
		});
		femaleAvatarBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		femaleAvatarBtn.setBounds(119, 312, 125, 23);
		femaleAvatarBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		chooseFarmerWindow.getContentPane().add(femaleAvatarBtn);
		
		/**
		 * 
		 * Sets the farmerType to the chosen avatar of class Farmer to "Male Farmer"
		 *     which is then used to associate the avatar image to the farmer
		 */
		JButton maleAvatarBtn = new JButton("Male Farmer");
		maleAvatarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFarmer.setType("Male Farmer");
				farmerTypeConfirm();
			}
		});
		maleAvatarBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		maleAvatarBtn.setBounds(348, 312, 115, 23);
		maleAvatarBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		chooseFarmerWindow.getContentPane().add(maleAvatarBtn);
		
		/**
		 * 
		 * Sets the farmerType to the chosen avatar of class Farmer to "Alien Farmer"
		 *     which is then used to associate the avatar image to the farmer
		 */
		JButton alienAvatarBtn = new JButton("Alien Farmer");
		alienAvatarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFarmer.setType("Alien Farmer");
				farmerTypeConfirm();
				
			}
		});
		alienAvatarBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		alienAvatarBtn.setBounds(554, 312, 107, 23);
		alienAvatarBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		chooseFarmerWindow.getContentPane().add(alienAvatarBtn);
		
		JLabel chooseFarmerLbl = new JLabel("Please choose player to play as");
		chooseFarmerLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		chooseFarmerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		chooseFarmerLbl.setBounds(119, 46, 542, 41);
		chooseFarmerWindow.getContentPane().add(chooseFarmerLbl);
		
	}
}
